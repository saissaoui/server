package tn.tunisiana.customer.dao;

import java.util.List;

import tn.tunisiana.customer.model.Segment;

public interface ISegmentDao {

	void save(Segment segment);

	List<Segment> getAll();

	void updateSegment(Segment segment);

	void deleteSegment(int id);

}
