package tn.tunisiana.customer.dao;

import java.util.List;

import tn.tunisiana.customer.model.Customer;

public interface ICustomerDao {
	List<Customer> getAll();

}
