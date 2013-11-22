package tn.tunisiana.customer.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "segment")
public class Segment {

	private int idSegment;

	private String critere;

	private List<Correspondance> correspondances;

	@XmlAttribute(name = "id")
	public int getIdSegment() {
		return idSegment;
	}

	public void setIdSegment(int idSegment) {
		this.idSegment = idSegment;
	}

	@XmlAttribute
	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "correspondance", type = Correspondance.class) })
	public List<Correspondance> getCorrespondances() {
		return correspondances;
	}

	public void setCorrespondances(List<Correspondance> correspondances) {
		this.correspondances = correspondances;
	}

}
