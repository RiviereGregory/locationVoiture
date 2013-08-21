package fr.treeptik.locationvoiture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	private VoitureDAO voitureDAO;

	@Override
	@Transactional
	public Voiture save(Voiture voiture) throws ServiceException {
		try {
			voiture = voitureDAO.save(voiture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return voiture;
	}

	@Override
	@Transactional
	public void remove(Voiture voiture) throws ServiceException {
		try {
			voitureDAO.remove(voiture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public List<Voiture> findAll() throws ServiceException {
		List<Voiture> list;
		try {
			list = voitureDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public Voiture findVoiture(Integer id) throws ServiceException {
		Voiture voiture;
		try {
			voiture = voitureDAO.findVoiture(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return voiture;
	}

	@Override
	@Transactional
	public void removeById(Integer id) throws ServiceException {
		try {
			voitureDAO.removeById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

}
