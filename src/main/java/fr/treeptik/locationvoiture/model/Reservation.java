package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Voiture voiture;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateResevation;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datePriseVehicule;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateRetour;

	public Reservation() {
	}

	public Reservation(Integer id, Client client, Voiture voiture, Date dateResevation,
			Date datePriseVehicule, Date dateRetour) {
		super();
		this.id = id;
		this.client = client;
		this.voiture = voiture;
		this.dateResevation = dateResevation;
		this.datePriseVehicule = datePriseVehicule;
		this.dateRetour = dateRetour;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", client=" + client + ", voiture=" + voiture
				+ ", dateResevation=" + dateResevation + ", datePriseVehicule=" + datePriseVehicule
				+ ", dateRetour=" + dateRetour + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
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
		Reservation other = (Reservation) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Date getDateResevation() {
		return dateResevation;
	}

	public void setDateResevation(Date dateResevation) {
		this.dateResevation = dateResevation;
	}

	public Date getDatePriseVehicule() {
		return datePriseVehicule;
	}

	public void setDatePriseVehicule(Date datePriseVehicule) {
		this.datePriseVehicule = datePriseVehicule;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

}
