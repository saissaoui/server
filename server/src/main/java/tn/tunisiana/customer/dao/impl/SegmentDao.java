package tn.tunisiana.customer.dao.impl;

import java.util.List;

import tn.tunisiana.customer.model.Segment;

public class SegmentDao extends GenericDao<Segment> {

	@Override
	public List<Segment> getAll() {
		List<Segment> list = sessionFactory.getCurrentSession()
				.createQuery("from Segment ").list();
		return list;
	}

	@Override
	public Segment get(int id) {

		try {
			List<Segment> list = sessionFactory.getCurrentSession()
					.createQuery("from Segment where segmentId=?")
					.setParameter(0, id).list();
			return list.get(0);
		} catch (Exception e) {
			return null;
		}
	}

}
