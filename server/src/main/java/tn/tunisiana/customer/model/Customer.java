package tn.tunisiana.customer.model;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "tunisianaDb")
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idcustomer;
	private String name;
	private String lastname;
	private Integer age;
	private String gouvernorat;
	private String adress;
	private String country;
	private String civilite;
	private String phone;
	private String email;
	private String idType;
	private String idNumber;
	private String profession;
	private int raisonAchat;
	private String lienParente;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private Date dateNaissanceUtilisateur;
	private String professionUtilisateur;
	private Date dateNaissance;
	private String villeUtilisateur;
	private Long codePostalUtilisateur;
	private Long codePostal;
	private String gouvernoratUtilisateur;
	private String civiliteUtilisateur;
	private boolean achatAccompagne;
	private String accompagnant;
	private String raisonChoix;

	@Transient
	private int distance;
	
	private List<Offer> offres;
	

	public Customer() {
	}
	
	
	public Customer(String name, String lastname, Integer age,
			String gouvernorat, String adress, String country, String civilite,
			String phone, String email, String idType, String idNumber,
			String profession, int raisonAchat, String lienParente,
			String nomUtilisateur, String prenomUtilisateur,
			Date dateNaissanceUtilisateur, String professionUtilisateur,
			Date dateNaissance, String villeUtilisateur,
			Long codePostalUtilisateur, Long codePostal,
			String gouvernoratUtilisateur, String civiliteUtilisateur,
			boolean achatAccompagne, String accompagnant, String raisonChoix) {
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.gouvernorat = gouvernorat;
		this.adress = adress;
		this.country = country;
		this.civilite = civilite;
		this.phone = phone;
		this.email = email;
		this.idType = idType;
		this.idNumber = idNumber;
		this.profession = profession;
		this.raisonAchat = raisonAchat;
		this.lienParente = lienParente;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
		this.professionUtilisateur = professionUtilisateur;
		this.dateNaissance = dateNaissance;
		this.villeUtilisateur = villeUtilisateur;
		this.codePostalUtilisateur = codePostalUtilisateur;
		this.codePostal = codePostal;
		this.gouvernoratUtilisateur = gouvernoratUtilisateur;
		this.civiliteUtilisateur = civiliteUtilisateur;
		this.achatAccompagne = achatAccompagne;
		this.accompagnant = accompagnant;
		this.raisonChoix = raisonChoix;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcustomer", unique = true, nullable = false)
	public Integer getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "gouvernorat", length = 45)
	public String getGouvernorat() {
		return this.gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	@Column(name = "adress", length = 45)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "country", length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "sex", length = 1)
	public String getCivilite() {
		return this.civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "id_type", length = 45)
	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	@Column(name = "id_number", length = 45)
	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Column(name = "profession", length = 45)
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Column(name = "raison_achat", length = 45)
	public int getRaisonAchat() {
		return this.raisonAchat;
	}

	public void setRaisonAchat(int raisonAchat) {
		this.raisonAchat = raisonAchat;
	}

	@Column(name = "lien_parente", length = 45)
	public String getLienParente() {
		return this.lienParente;
	}

	public void setLienParente(String lienParente) {
		this.lienParente = lienParente;
	}

	@Column(name = "nom_utilisateur", length = 45)
	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	@Column(name = "prenom_utilisateur", length = 45)
	public String getPrenomUtilisateur() {
		return this.prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance_utilisateur", length = 10)
	public Date getDateNaissanceUtilisateur() {
		return this.dateNaissanceUtilisateur;
	}

	public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
	}

	@Column(name = "profession_utilisateur", length = 45)
	public String getProfessionUtilisateur() {
		return this.professionUtilisateur;
	}

	public void setProfessionUtilisateur(String professionUtilisateur) {
		this.professionUtilisateur = professionUtilisateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "ville_utilisateur", length = 45)
	public String getVilleUtilisateur() {
		return this.villeUtilisateur;
	}

	public void setVilleUtilisateur(String villeUtilisateur) {
		this.villeUtilisateur = villeUtilisateur;
	}

	@Column(name = "code_postal_utilisateur")
	public Long getCodePostalUtilisateur() {
		return this.codePostalUtilisateur;
	}

	public void setCodePostalUtilisateur(Long codePostalUtilisateur) {
		this.codePostalUtilisateur = codePostalUtilisateur;
	}

	@Column(name = "code_postal")
	public Long getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}

	@Column(name = "gouvernorat_utilisateur", length = 45)
	public String getGouvernoratUtilisateur() {
		return this.gouvernoratUtilisateur;
	}

	public void setGouvernoratUtilisateur(String gouvernoratUtilisateur) {
		this.gouvernoratUtilisateur = gouvernoratUtilisateur;
	}

	@Column(name = "sexe_utilisateur", length = 45)
	public String getCiviliteUtilisateur() {
		return this.civiliteUtilisateur;
	}

	public void setCiviliteUtilisateur(String civiliteUtilisateur) {
		this.civiliteUtilisateur = civiliteUtilisateur;
	}

	@Column(name = "achat_accompagne")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean getAchatAccompagne() {
		return this.achatAccompagne;
	}

	public void setAchatAccompagne(boolean achatAccompagne) {
		this.achatAccompagne = achatAccompagne;
	}

	@Column(name = "accompagnant", length = 45)
	public String getAccompagnant() {
		return this.accompagnant;
	}

	public void setAccompagnant(String accompagnant) {
		this.accompagnant = accompagnant;
	}

	@Column(name = "raison_choix", length = 45)
	public String getRaisonChoix() {
		return this.raisonChoix;
	}

	public void setRaisonChoix(String raisonChoix) {
		this.raisonChoix = raisonChoix;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_offer", catalog = "tunisianaDb", joinColumns = { @JoinColumn(name = "idcustomer", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "idoffer", nullable = false, updatable = false) })
	
	public List<Offer> getOffres() {
		return offres;
	}


	public void setOffres(List<Offer> offres) {
		this.offres = offres;
	}

	
}
