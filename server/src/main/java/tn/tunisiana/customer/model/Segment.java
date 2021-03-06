package tn.tunisiana.customer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "segment", catalog = "tunisianaDb")
public class Segment {

	private int idSegment;

	private String criteres;

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

	@Column(name = "criteres")
	public String getCriteres() {
		return criteres;
	}

	public void setCriteres(String criteres) {
		this.criteres = criteres;
	}
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idsegment")
	public List<Correspondance> getCorrespondances() {
		return correspondances;
	}

	public void setCorrespondances(List<Correspondance> correspondances) {
		this.correspondances = correspondances;
	}

	
	

}
