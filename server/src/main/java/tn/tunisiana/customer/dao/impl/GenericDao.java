package tn.tunisiana.customer.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDao<T> {

	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Integer add(T object) {

		return (Integer) sessionFactory.getCurrentSession().save(object);
	}

	public void update(T object) {
		sessionFactory.getCurrentSession().update(object);
	}

	public void delete(int id) {

		sessionFactory.getCurrentSession().delete(id);
	}

	public abstract List<T> getAll();

	public abstract T get(int id);
}
