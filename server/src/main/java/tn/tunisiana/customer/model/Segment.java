package tn.tunisiana.customer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "segment", catalog = "tunisianaDb")
public class Segment {

	private int idSegment;

	private String critere;

	private List<Correspondance> correspondances;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idsegment", unique = true, nullable = false)
	public int getIdSegment() {
		return idSegment;
	}

	public void setIdSegment(int idSegment) {
		this.idSegment = idSegment;
	}

	@Column(name = "critere")
	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "segment")
	public List<Correspondance> getCorrespondances() {
		return correspondances;
	}

	public void setCorrespondances(List<Correspondance> correspondances) {
		this.correspondances = correspondances;
	}

	
	

}
