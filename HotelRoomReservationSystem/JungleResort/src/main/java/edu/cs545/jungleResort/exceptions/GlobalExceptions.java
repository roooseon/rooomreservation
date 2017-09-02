package edu.cs545.jungleResort.exceptions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(MultipartException.class)
	String handleFileException(Model model, Exception ex) {
		// return your json insted this string.
		model.addAttribute("errorMessage", new String("File size exceeded"));
	    return "redirect:/addroom/servererror";
	}
}
