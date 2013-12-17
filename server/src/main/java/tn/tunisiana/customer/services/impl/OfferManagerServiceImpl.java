package tn.tunisiana.customer.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.tunisiana.customer.business.SegmentTester;
import tn.tunisiana.customer.dao.impl.OfferDao;
import tn.tunisiana.customer.dao.impl.SegmentDao;
import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.services.IOfferManagerService;
import tn.tunisiana.customer.util.GeoCalculator;
import tn.tunisiana.customer.util.GlobalConf;

public class OfferManagerServiceImpl implements IOfferManagerService {

	private SegmentTester segTester = new SegmentTester();
	private SegmentDao sDao;
	private OfferDao oDao;

	@Transactional
	public List<Offer> getOffersFor(Customer customer) {

		GeoCalculator gc = new GeoCalculator();
		int distance = gc.distance(customer.getGouvernorat(),
				GlobalConf.getLocalisation());
		customer.setDistance(distance);

		if (segTester.getSegments() == null) {

			segTester.setSegments(sDao.getAll());

		}

		List<Offer> offers = segTester.defineOffers(customer);

		return offers;

	}
	
	public List<Offer> getOffersByOperator(String operator){
		
		return oDao.getOffersByOperator(operator);
	}

	public SegmentDao getsDao() {
		return sDao;
	}

	public void setsDao(SegmentDao sDao) {
		this.sDao = sDao;
	}

	public OfferDao getoDao() {
		return oDao;
	}

	public void setoDao(OfferDao oDao) {
		this.oDao = oDao;
	}
	
	
	
}
