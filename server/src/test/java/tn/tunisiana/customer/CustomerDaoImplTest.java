package tn.tunisiana.customer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tn.tunisiana.customer.dao.impl.CustomerDaoImpl;

public class CustomerDaoImplTest {

	private static CustomerDaoImpl service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		service = new CustomerDaoImpl();
	}

	@Test
	public void testGetAll() {
		assertNotNull(service.getAll());
	}

}
