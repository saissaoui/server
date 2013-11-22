package tn.tunisiana.customer.dao;

import java.util.List;

import tn.tunisiana.customer.model.Offer;

public interface IOfferDao {

	public void addOffer();

	public void deleteOffer();

	public Offer getOffer();

	public void updateOffer();

	public List<Offer> listOffers( List<Integer> offers);

}
