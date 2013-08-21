package fr.treeptik.locationvoiture.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "VOITURE")
public class Voiture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_voiture")
	private Integer id;

	@Column(name = "marque_voiture")
	@NotEmpty
	private String marque;

	@Column(name = "modele_voiture")
	@NotBlank
	@Size(min = 2, max = 10)
	private String modele;

	public Voiture() {
	}

	public Voiture(Integer id, String marque, String modele) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", modele=" + modele + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

}
