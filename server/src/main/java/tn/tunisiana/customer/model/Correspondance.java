package tn.tunisiana.customer.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "correspondance", catalog = "tunisianaDb")
public class Correspondance {

	private int idCorrespondance;
	private String conditions;
	private Offer Offre;
	private Segment segment;

	public Correspondance() {
		super();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcorrespondance", unique = true, nullable = false)
	public int getIdCorrespondance() {
		return idCorrespondance;
	}

	public void setIdCorrespondance(int idCorrespondance) {
		this.idCorrespondance = idCorrespondance;
	}

	@Column(name = "conditions")
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offre_id", nullable = false)
	public Offer getOffre() {
		return Offre;
	}

	public void setOffre(Offer offre) {
		Offre = offre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsegment", nullable = false)
	public Segment getSegment() {
		return segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

}
