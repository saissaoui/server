package tn.tunisiana.customer.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import tn.tunisiana.customer.business.SegmentTester;
import tn.tunisiana.customer.dao.impl.OfferDaoImpl;
import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.services.IOfferManagerService;
import tn.tunisiana.customer.util.GeoCalculator;
import tn.tunisiana.customer.util.GlobalConf;
import tn.tunisiana.customer.util.SegmentsFileManager;



public class OfferManagerServiceImpl implements IOfferManagerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 597013903416774611L;
	private SegmentTester segTester = new SegmentTester();
	private SegmentsFileManager segFileMan = new SegmentsFileManager();
	private OfferDaoImpl odi = new OfferDaoImpl();
	private static final Logger logger = Logger
			.getLogger(OfferManagerServiceImpl.class);

	
	public List<Offer> getOffersFor(Customer customer) {

		GeoCalculator gc = new GeoCalculator();
		int distance = gc.distance(customer.getGouvernorat(),
				GlobalConf.getLocalisation());
		customer.setDistance(distance);

		if (segTester.getSegments() == null) {

			System.out.println("offers " + segFileMan.getAllSegments().size());
			segTester.setSegments(segFileMan.getAllSegments());

		}
		List<Integer> offerIds = segTester.defineOffers(customer);
		List<Offer> offers = odi.listOffers(offerIds);

		return offers;

	}

}
