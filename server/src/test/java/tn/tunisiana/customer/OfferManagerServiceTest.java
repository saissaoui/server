package tn.tunisiana.customer;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.services.IOfferManagerService;

@ContextConfiguration(locations="/spring/beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferManagerServiceTest {

	@Autowired
	@Qualifier("oService")
	private  IOfferManagerService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	
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
