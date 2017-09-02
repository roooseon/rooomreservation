package edu.cs545.jungleResort.DAOImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.cs545.jungleResort.DAO.OfferRepo;
import edu.cs545.jungleResort.domain.Offer;

@Component
public class OfferRepoImpl implements OfferRepo {

	private final Map<String, Offer> offerList = new HashMap<String, Offer>();

	public OfferRepoImpl() {

		offerList.put("1", new Offer("1", "Samsung Mobile", "The lucky customer will get Samsung Edge 6", "11/12/2013",
				"Rabin Pantha"));
		offerList.put("2",
				new Offer("2", "Iphone", "The lucky customer will get Iphone", "11/12/2013", "Santosh Ghimire"));
		offerList.put("3", new Offer("3", "Ipad", "The lucky customer will get Ipad", "11/12/2013", "Rojan Piya"));
	}

	@Override
	public void addOffer(Offer offer) {
		offerList.put(offer.getOfferId(), offer);

	}

	@Override
	public Offer getOfferById(String id) {
		// TODO Auto-generated method stub
		return offerList.get(id);
	}

	@Override
	public List<Offer> getAllOffer() {
		List<Offer> myOfferList = new ArrayList<>();
		for (String key : offerList.keySet()) {
			myOfferList.add(offerList.get(key));
		}
		return myOfferList;
	}

	@Override
	public void deleteOffer(String id) {
		offerList.remove(id);

	}

	@Override
	public void updateOfferById(String id, Offer offer) {
		offerList.put(id, offer);

	}

}
