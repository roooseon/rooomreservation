package edu.cs545.jungleResort.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cs545.jungleResort.DAO.OfferRepo;
import edu.cs545.jungleResort.DAOImpl.OfferRepoImpl;
import edu.cs545.jungleResort.domain.Offer;
import edu.cs545.jungleResort.service.OfferService;


@Service
public class OfferServiceImpl implements OfferService {

	//@Autowired
	OfferRepo offerRepo = new OfferRepoImpl();

	@Override
	public void addOffer(Offer offer) {
		offerRepo.addOffer(offer);
	}

	@Override
	public Offer getOfferById(String id) {
		return offerRepo.getOfferById(id);
	}

	@Override
	public List<Offer> getAllOffer() {

		return offerRepo.getAllOffer();
	}

	@Override
	public void deleteOffer(String id) {
		offerRepo.deleteOffer(id);

	}

	@Override
	public void updateOfferById(String id, Offer offer) {
		offerRepo.updateOfferById(id, offer);

	}

}
