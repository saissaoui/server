package tn.tunisiana.customer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.services.IOfferManagerService;
import tn.tunisiana.customer.services.impl.OfferManagerServiceImpl;

public class OfferManagerServiceTest {

	private static IOfferManagerService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	service = new OfferManagerServiceImpl();
	}

	@Test
	public void test() {
	Customer customer= new Customer();
	customer.setIdcustomer(15);
	customer.setAge(30);
	customer.setRaisonAchat(4);
	List<Offer> offers = service.getOffersFor(customer);
	assertNotNull(offers);
	}

}
