package edu.cs545.jungleResort.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import edu.cs545.jungleResort.DAO.CustomerDAO;
import edu.cs545.jungleResort.domain.Booking;
import edu.cs545.jungleResort.domain.Customer;
import edu.cs545.jungleResort.domain.Images;
import edu.cs545.jungleResort.domain.Room;
import edu.cs545.jungleResort.enumeration.RoomFeatures;
import edu.cs545.jungleResort.enumeration.RoomStatus;
import edu.cs545.jungleResort.enumeration.RoomType;
import edu.cs545.jungleResort.library.ByteToMultipart;
import edu.cs545.jungleResort.service.BookingService;
import edu.cs545.jungleResort.service.ICustomerService;
import edu.cs545.jungleResort.service.MailClient;
import edu.cs545.jungleResort.serviceImpl.RoomServiceImpl;

@Controller
public class RoomController {
	@Autowired
	RoomServiceImpl roomService;
	@Autowired
	ICustomerService customerService;
	@Autowired
	BookingService bookingService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	MailClient mailClient;

	@ModelAttribute("roomFeaturesTrans")
	public List<RoomFeatures> roomFeatures() {
		List<RoomFeatures> roomFeaturesTrans = Arrays.asList(RoomFeatures.values());
		return roomFeaturesTrans;
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homepage() {
		return "homepage";
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room,
			@ModelAttribute("roomFeaturesTrans") List<RoomFeatures> roomFeaturesTrans, HttpSession session) {
		/*
		 * if(session.getAttribute("user")!=null &&
		 * session.getAttribute("user").equals(true)) {
		 */
		return "addRoom";
		/*
		 * } return "redirect:/adminlogin";
		 */
	}

	@RequestMapping(value = "/addroom/servererror", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room, Model model, @RequestParam String errorMessage) {
		model.addAttribute("imageType", errorMessage);
		return "AddRoom";
	}

	public boolean checkJPEG(MultipartFile tempImg) {
		String fileName = tempImg.getContentType().toLowerCase();
		return fileName.equals("image/jpg") || fileName.equals("image/jpeg") || fileName.equals("image/png");
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public String addRoom(@Valid Room room, BindingResult result, Model model,
			@RequestParam List<MultipartFile> tempImg2, Exception exception) throws IOException {

		String view = "AddRoom";
		boolean flagSize = false;
		boolean flagType = false;

		for (int i = 0; i < tempImg2.size(); i++) {
			MultipartFile tempImg23 = tempImg2.get(i);
			if (tempImg23.getSize() <= 2097152) {
				if (checkJPEG(tempImg23)) {
					Images image = new Images();
					image.setImage3(tempImg23.getBytes());
					room.getImage2().add(image);
				} else {
					flagType = true;
					break;
				}
			} else {
				flagSize = true;
				break;
			}
		}
		if (!flagSize) {
			if (!flagType) {
				if (!result.hasErrors()) {
					try {
						roomService.addRoom(room);
						view = "redirect:/allroomslist";
					} catch (Exception e) {
						model.addAttribute("errorMessage", new String("Duplicate entry found"));
					}
				}
			} else {
				model.addAttribute("imageType2", new String("Select a file in .jpg, .jpeg or .png format"));
			}

		} else {
			model.addAttribute("imageType2", new String("File size exceeded"));

		}
		return view;
	}

	@RequestMapping(value = "/roomDetail/{id}", method = RequestMethod.GET)
	public String roomDetail(@ModelAttribute("room") Room room, @PathVariable("id") int id, Model model)
			throws UnsupportedEncodingException {
		byte[] encodeBasee64;
		Room newRoom = roomService.getRoomById(id);
		String base64EncodeImage;
		for (Images image : newRoom.getImage2()) {
			encodeBasee64 = Base64.encode(image.getImage3());
			base64EncodeImage = new String(encodeBasee64, "UTF-8");
			image.setEncodeImage3(base64EncodeImage);
		}
		model.addAttribute("room", newRoom);
		return "roomDetail";
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.GET)
	public String updateRoom(@ModelAttribute("room") Room room, @PathVariable("id") int id, Model model)
			throws UnsupportedEncodingException {
		// Room room1 = roomService.getRoomById(id);
		// List<MultipartFile> temp = new ArrayList<MultipartFile>();
		// for (Images image : room1.getImage2()) {
		// temp.add(new ByteToMultipart(Base64.encode(image.getImage3())));
		// }
		// room1.setTempImg2(temp);
		model.addAttribute("room", roomService.getRoomById(id));
		return "UpdateRoom";
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.POST)
	public String updateRoom(@Valid Room room, BindingResult result, Model model,
			@RequestParam List<MultipartFile> tempImg2, @PathVariable("id") int id, Exception exception)
			throws IOException {

		boolean flagSize = false;
		boolean flagType = false;
		String view = "UpdateRoom";

		System.out.println("======================");
		System.out.println(tempImg2.toString());

		room.setId(id);

		if (tempImg2.size() == 0) {
			room.setImage2(roomService.getRoomById(id).getImage2());
		}

		for (int i = 0; i < tempImg2.size(); i++) {
			MultipartFile tempImg23 = tempImg2.get(i);
			if (tempImg23.getSize() <= 2097152) {
				if (checkJPEG(tempImg23)) {
					Images image = new Images();
					image.setImage3(tempImg23.getBytes());
					room.getImage2().add(image);
				} else {
					System.out.println("Type not satisfied");
					flagType = true;
					break;
				}
			} else {
				System.out.println("File size exceeded");
				flagSize = true;
				break;
			}
		}
		if (!flagSize) {
			if (!flagType) {
				if (!result.hasErrors()) {
					try {
						roomService.addRoom(room);
						view = "redirect:/allroomslist";
					} catch (Exception e) {
						model.addAttribute("errorMessage", new String("Duplicate entry found"));
					}
				}
			} else {
				model.addAttribute("imageType2", new String("Select a file in .jpg, .jpeg or .png format"));
			}

		} else {
			model.addAttribute("imageType2", new String("File size exceeded"));
		}
		return view;
	}

	@RequestMapping(value = "/allroomslist", method = { RequestMethod.GET })
	public String allRoomsList(Map<String, Object> model, Model m, HttpServletRequest request, HttpSession session)
			throws UnsupportedEncodingException {

		System.out.println("admin session credentials " + session.getAttribute("adminSession"));
		if (session.getAttribute("adminSession") != null) {

			byte[] encodeBasee64;
			String base64EncodeImage;
			for (Room room : roomService.getAllAvailableRoom()) {
				for (Images image : room.getImage2()) {
					encodeBasee64 = Base64.encode(image.getImage3());
					base64EncodeImage = new String(encodeBasee64, "UTF-8");
					image.setEncodeImage3(base64EncodeImage);
				}
			}

			model.put("allrooms", roomService.getAllRoom());
			return "AllRoomsList";
		}
		return "redirect:/adminlogin";

	}

	@RequestMapping("/deleteroom/{id}")
	public String removeRoom(@PathVariable("id") int id) {
		roomService.deleteRoom(id);
		return "redirect:/allroomslist";
	}

	/*
	 * @RequestMapping(value = "booking/{roomNo}", method = RequestMethod.POST)
	 * public String processOrder(Model model, @PathVariable String roomNo) {
	 * System.out.println("inside Booking !!"); //
	 * orderService.processOrder(productId, quantity);
	 * 
	 * return "redirect:/home";
	 * 
	 * }
	 */
	@RequestMapping(value = "/availableroomslist", method = RequestMethod.GET)
	public String availableRoomsList(Map<String, Object> model) throws UnsupportedEncodingException {
		byte[] encodeBasee64;
		String base64EncodeImage;
		for (Room room : roomService.getAllAvailableRoom()) {
			for (Images image : room.getImage2()) {
				encodeBasee64 = Base64.encode(image.getImage3());
				base64EncodeImage = new String(encodeBasee64, "UTF-8");
				image.setEncodeImage3(base64EncodeImage);
			}
		}
		model.put("availablerooms", roomService.getAllAvailableRoom());
		return "AvailableRoomsList";
	}
	
	
	@RequestMapping(value = "/availableroomslist/{roomtype}", method = {RequestMethod.GET, RequestMethod.POST})
	public String singleRoomsList(Map<String, Object> model, @PathVariable ("roomtype") String roomtype) throws UnsupportedEncodingException {
		byte[] encodeBasee64;
		String base64EncodeImage;
		for (Room room : roomService.getRoomsByType(RoomType.valueOf(roomtype))){ 
			for (Images image : room.getImage2()) {
				encodeBasee64 = Base64.encode(image.getImage3());
				base64EncodeImage = new String(encodeBasee64, "UTF-8");
				image.setEncodeImage3(base64EncodeImage);
			}
		}
		model.put("availablerooms", roomService.getAllAvailableRoom());
		return "AvailableRoomsList";
	}
	
	

}
