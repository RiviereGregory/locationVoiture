package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;

public interface ReservationService extends GenericService<Reservation, Integer, ReservationDAO> {

	List<Reservation> findByClient(Integer id) throws ServiceException;

	List<Reservation> findByVoiture(Integer id) throws ServiceException;
}
