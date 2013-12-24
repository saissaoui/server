package tn.tunisiana.customer.dao.impl;

import java.util.List;

import tn.tunisiana.customer.model.Offer;


public class OfferDao extends GenericDao<Offer>  {

	@Override
	public List<Offer>  getAll() {
		List<Offer> list = sessionFactory.getCurrentSession()
				.createQuery("from Offer ").list();
		return list;
	}

	@Override
	public Offer get(int id) {
		try {
			List<Offer> list = sessionFactory.getCurrentSession()
					.createQuery("from Offer where idoffer=?")
					.setParameter(0, id).list();
			return list.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Offer> getOffersByOperator(String operatorName){
		try {
			List<Offer> list = sessionFactory.getCurrentSession()
					.createQuery("from Offer where operateur=?")
					.setParameter(0, operatorName).list();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
}
