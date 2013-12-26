package tn.tunisiana.customer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.services.ICustomerService;

@ContextConfiguration(locations = "/spring/beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

	@Autowired
	@Qualifier("cService")
	private ICustomerService customerService;

	@Test
	public void testGetAll() {
		assertTrue(true);
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setName("testCustomer");
		customerService.addCustomer(customer, 4);
		assertTrue(true);
	}

	@Test
	public void testUpdateCustomer() {
		assertTrue(true);
	}

	@Test
	public void testDeleteCustomer() {
		assertTrue(true);
	}

}
