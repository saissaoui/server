package tn.tunisiana.customer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tn.tunisiana.customer.dao.ICustomerDao;
import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.util.HibernateUtil;

public class CustomerDaoImpl implements ICustomerDao {

	Session session;

	public CustomerDaoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();

	}

	@Override
	public List<Customer> getAll() {
		session.getTransaction().begin();
		Query query;

		query = session.createQuery("from Customer");

		session.getTransaction().commit();
		List<Customer> list = (List<Customer>) query.list();
		return list;
	}

}
