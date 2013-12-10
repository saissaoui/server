package tn.tunisiana.customer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "correspondance", catalog = "tunisianaDb")
public class Correspondance {

	private int idCorrespondance;
	private List<Condition> conditions;
	private Offer Offre;
	

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

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="correspondance_id")
	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offre_id", nullable = false)
	public Offer getOffre() {
		return Offre;
	}

	public void setOffre(Offer offre) {
		Offre = offre;
	}

	

}
