package edu.cs545.jungleResort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cs545.jungleResort.domain.Offer;
import edu.cs545.jungleResort.service.OfferService;

@RestController
public class OfferRestController {

	@Autowired
	private OfferService offerService;

	@RequestMapping("/offers")
	public List<Offer> offerList() {

		return offerService.getAllOffer();
	}

	@RequestMapping("/offers/{offerId}")
	public Offer getOffer(@PathVariable String offerId) {
		System.out.println(offerService.getOfferById(offerId));
		return offerService.getOfferById(offerId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/offers")
	public void addOffer(@RequestBody Offer offer) {
		offerService.addOffer(offer);
		;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/offers/{offerId}")
	public void updateOffer(@RequestBody Offer offer, @PathVariable String offerId) {
		offerService.updateOfferById(offerId, offer);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/offers/{offerId}")
	public void deleteOffers(@PathVariable String offerId) {
		offerService.deleteOffer(offerId);

	}
}
