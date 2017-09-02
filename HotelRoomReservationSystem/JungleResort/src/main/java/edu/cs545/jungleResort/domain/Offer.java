package edu.cs545.jungleResort.domain;

import java.util.Date;

public class Offer {

	private String offerId;

	private String offerName;

	private String OfferDescription;

	private String offerDate;

	private String offeredBy;

	public Offer(String offerId, String offerName, String offerDescription, String offerDate, String offeredBy) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		OfferDescription = offerDescription;
		this.offerDate = offerDate;
		this.offeredBy = offeredBy;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDescription() {
		return OfferDescription;
	}

	public void setOfferDescription(String offerDescription) {
		OfferDescription = offerDescription;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public String getOfferedBy() {
		return offeredBy;
	}

	public void setOfferedBy(String offeredBy) {
		this.offeredBy = offeredBy;
	}

}
