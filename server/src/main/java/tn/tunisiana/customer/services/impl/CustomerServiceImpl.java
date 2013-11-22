package tn.tunisiana.customer.services.impl;

import java.util.List;

import tn.tunisiana.customer.dao.ICustomerDao;
import tn.tunisiana.customer.dao.impl.CustomerDaoImpl;
import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.services.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAll() {

		return customerDao.getAll();
	}

}
