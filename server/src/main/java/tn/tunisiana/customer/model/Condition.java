package tn.tunisiana.customer.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "condition_table", catalog = "tunisianaDb")
public class Condition {

	int conditionId;
	String critere;
	String valeurs;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "condition_id", unique = true, nullable = false)
	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	@Column(name = "critere")
	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

	@Column(name = "valeurs")
	public String getValeurs() {
		return valeurs;
	}

	public void setValeurs(String valeurs) {
		this.valeurs = valeurs;
	}

}
