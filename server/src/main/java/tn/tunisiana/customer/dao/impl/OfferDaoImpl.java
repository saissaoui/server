package tn.tunisiana.customer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tn.tunisiana.customer.dao.IOfferDao;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.util.HibernateUtil;

public class OfferDaoImpl implements IOfferDao {

	Session session;

	
	
	
	
	public OfferDaoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();

	}

	public void addOffer() {
		// TODO Auto-generated method stub

	}

	public void deleteOffer() {
		// TODO Auto-generated method stub

	}

	public Offer getOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateOffer() {
		// TODO Auto-generated method stub

	}

	public List<Offer> listOffers(List<Integer> offers) {
		
		
		session.getTransaction().begin();
		Query query;
		if(offers !=  null){
			 query =  session.createQuery("from Offer where idoffer in (:idList)");
			 query.setParameterList("idList", offers);	
		}
			 else
			 query =  session.createQuery("from Offer");
		
		session.getTransaction().commit();
		List<Offer> list = (List<Offer>)query.list();
		return list;

	}
}
