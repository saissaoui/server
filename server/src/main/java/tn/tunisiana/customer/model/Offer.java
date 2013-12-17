package tn.tunisiana.customer.model;

// default package
// Generated Sep 25, 2013 12:39:34 PM by Hibernate Tools 4.0.0

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Offer generated by hbm2java
 */
@Entity
@Table(name = "offer", catalog = "tunisianaDb")
public class Offer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idoffer;
	private String offerName;
	private String description;
	private String operateur;
	private Set<Offer> equivalents;

	public Offer() {
	}

	public Offer(int idoffer) {
		this.idoffer = idoffer;
	}

	public Offer(int idoffer, String offerName, String description) {
		this.idoffer = idoffer;
		this.offerName = offerName;
		this.description = description;
	}

	@Id
	@Column(name = "idoffer", unique = true, nullable = false)
	public int getIdoffer() {
		return this.idoffer;
	}

	public void setIdoffer(int idoffer) {
		this.idoffer = idoffer;
	}

	@Column(name = "offerName", length = 45)
	public String getOfferName() {
		return this.offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "equivalent_offer", catalog = "tunisianaDb", joinColumns = { @JoinColumn(name = "concurent_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "offer_id", nullable = false, updatable = false) })
	public Set<Offer> getEquivalents() {
		return equivalents;
	}

	public void setEquivalents(Set<Offer> equivalents) {
		this.equivalents = equivalents;
	}

}
