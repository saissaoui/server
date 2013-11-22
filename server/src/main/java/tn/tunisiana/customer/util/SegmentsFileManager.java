package tn.tunisiana.customer.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tn.tunisiana.customer.model.Segment;

public class SegmentsFileManager {

	JAXBContext jaxbContext;

	public SegmentsFileManager() {
		try {
			jaxbContext = JAXBContext.newInstance(Segment.class);
		} catch (JAXBException e) {

			e.printStackTrace();
		}

	}

	public Segment readSegment(File segFile) {

		Segment segment = null;

		try {
			Unmarshaller jaxbUnmarshaller;
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			segment = (Segment) jaxbUnmarshaller.unmarshal(segFile);

		} catch (JAXBException e) {

			System.out.println("format fichier inconnu");
			e.printStackTrace();

		}

		return segment;

	}

	public List<Segment> getAllSegments() {

		File rep = new File("segments");

		if (rep.isDirectory()) {
			File[] seFiles = rep.listFiles();

			List<Segment> segments = new ArrayList<Segment>();

			for (File file : seFiles)
				segments.add(readSegment(file));

			return segments;
		} else
			return null;
	}

	public void saveSegment(Segment segment) {

		Marshaller jaxbMarshaller;
		try {
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(segment,
					new File("segments/" + segment.getIdSegment() + ".xml"));
		} catch (JAXBException e) {

			e.printStackTrace();
		}

	}

}
