package fr.treeptik.locationvoiture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.service.ReservationService;

@Service
public class ReservationServiceImpl extends
		GenericServiceImpl<Reservation, Integer, ReservationDAO> implements ReservationService {

	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	protected ReservationDAO getDao() {

		return reservationDAO;
	}

	@Override
	public List<Reservation> findByClient(Integer id) throws ServiceException {
		List<Reservation> list;
		try {
			list = getDao().findByClient(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<Reservation> findByVoiture(Integer id) throws ServiceException {
		List<Reservation> list;
		try {
			list = getDao().findByVoiture(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

}
