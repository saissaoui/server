package tn.tunisiana.customer.services.impl;

import java.util.ArrayList;
import java.util.List;

import tn.tunisiana.customer.dao.impl.CustomerDao;
import tn.tunisiana.customer.dao.impl.OfferDao;
import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.services.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	private CustomerDao customerDao;
	private OfferDao offerDao;
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	
	public OfferDao getOfferDao() {
		return offerDao;
	}

	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}

	@Override
	public List<Customer> getAll() {

		return customerDao.getAll();
	}

	@Override
	public void addCustomer(Customer customer, int offerId) {
		Offer offer = offerDao.get(offerId);
		customer.setOffres(new ArrayList<Offer>());
		customer.getOffres().add(offer);
		customerDao.add(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		
	}

}
