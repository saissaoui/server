package tn.tunisiana.customer.dao.impl;

import java.util.List;

import tn.tunisiana.customer.model.Customer;

public class CustomerDao extends GenericDao<Customer> {

	@Override
	public List<Customer> getAll() {
		List<Customer> list = sessionFactory.getCurrentSession()
				.createQuery("from Customer ").list();
		return list;
	}

	@Override
	public Customer get(int id) {
		try {
			List<Customer> list = sessionFactory.getCurrentSession()
					.createQuery("from Customer where customerId=?")
					.setParameter(0, id).list();
			return list.get(0);
		} catch (Exception e) {
			return null;
		}
	}

}
