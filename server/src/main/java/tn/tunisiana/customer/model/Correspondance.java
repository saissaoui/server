package tn.tunisiana.customer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "correspondance", catalog = "tunisianaDb")
public class Correspondance {

	private int idCorrespondance;
	private List<Condition> conditions;
	private Set<Offer> Offres;

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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "correspondance_condition", catalog = "tunisianaDb", joinColumns = { @JoinColumn(name = "correspondance_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "conditions_id", nullable = false, updatable = false) })
	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "correspondance_offer", catalog = "tunisianaDb", joinColumns = { @JoinColumn(name = "correspondance_id",nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "offer_id",nullable = false, updatable = false) })
	@IndexColumn(name="idoffer")
	public Set<Offer> getOffres() {
		return Offres;
	}

	public void setOffres(Set<Offer> offres) {
		Offres = offres;
	}

}
