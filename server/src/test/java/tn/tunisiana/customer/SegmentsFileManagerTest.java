package tn.tunisiana.customer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import tn.tunisiana.customer.model.Segment;
import tn.tunisiana.customer.util.SegmentsFileManager;

public class SegmentsFileManagerTest {
	private static SegmentsFileManager sfg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		sfg = new SegmentsFileManager();
	}

	 @Test
	public void testReadSegment() {

		assertNotNull(sfg.readSegment(new File("segments/1.xml")));
	}

	@Test
	public void testGetAllSegments() {
		List<Segment> sgmts = sfg.getAllSegments();
		assertNotNull(sgmts);
	}

	// @Test
	public void testSaveSegment() {
		fail("Not yet implemented");
	}

}
