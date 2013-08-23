package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;

public interface ReservationDAO extends GenericDAO<Reservation, Integer> {

	List<Reservation> findByClient(Integer id) throws DAOException;

	List<Reservation> findByVoiture(Integer id) throws DAOException;

	List<Reservation> findAllOrderByDateReservation() throws DAOException;

	List<Reservation> findAllOrderByDatePriseVehicule() throws DAOException;

	List<Reservation> findAllOrderByDateRetour() throws DAOException;

}
