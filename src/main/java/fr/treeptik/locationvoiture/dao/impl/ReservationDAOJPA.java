package fr.treeptik.locationvoiture.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.model.Reservation;

@Repository
public class ReservationDAOJPA extends GenericDAOJPA<Reservation, Integer> implements ReservationDAO {

	public ReservationDAOJPA() {
		super(Reservation.class);

	}

}
