package tn.tunisiana.customer;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import tn.tunisiana.customer.dao.impl.CustomerDao;

public class CustomerDaoImplTest {

	private static CustomerDao service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		service = new CustomerDao();
	}

	@Test
	public void testGetAll() {
		assertNotNull(service.getAll());
	}

}
