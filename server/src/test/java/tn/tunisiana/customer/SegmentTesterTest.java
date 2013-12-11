package tn.tunisiana.customer;

import static org.junit.Assert.*;

import org.junit.Test;

import tn.tunisiana.customer.business.SegmentTester;
import tn.tunisiana.customer.dao.impl.SegmentDao;
import tn.tunisiana.customer.model.Customer;


public class SegmentTesterTest {

	@Test
	public void testDefineOffers() {
		SegmentTester st = new SegmentTester();
		SegmentDao sd= new SegmentDao();
		Customer customer = new Customer();
		
		customer.setRaisonChoix("prix");
		customer.setRaisonAchat(1);
		customer.setGouvernorat("Tunis");
		customer.setAchatAccompagne(true);
		customer.setAccompagnant("ami");
		
		st.setSegments(sd.getAll());
		assertNotNull( st.defineOffers(customer));
//		//segs.add(sfm.readSegment(1));
//		SegmentTester st = new SegmentTester();
//		st.setSegments(segs);
//		Customer cust = new Customer();
//		cust.setAge(30);
//		List<Integer> offers = st.defineOffers(cust);
//
//		assertTrue(true);
//
//		assertNotNull("fail", offers);
	}

}
