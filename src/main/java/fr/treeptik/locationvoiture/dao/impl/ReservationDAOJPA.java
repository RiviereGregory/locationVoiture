package fr.treeptik.locationvoiture.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;

@Repository
public class ReservationDAOJPA extends GenericDAOJPA<Reservation, Integer> implements
		ReservationDAO {

	public ReservationDAOJPA() {
		super(Reservation.class);

	}

	@Override
	public List<Reservation> findByClient(Integer id) throws DAOException {
		try {
			TypedQuery<Reservation> query = entityManager.createQuery(
					"SELECT r FROM  Reservation r WHERE r.client.id=:id", Reservation.class);
			query.setParameter("id", id);

			return query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Reservation> findByVoiture(Integer id) throws DAOException {
		try {
			TypedQuery<Reservation> query = entityManager.createQuery(
					"SELECT r FROM  Reservation r WHERE r.voiture.id=:id", Reservation.class);
			query.setParameter("id", id);

			return query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

}