package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;

public interface VoitureService extends GenericService<Voiture, Integer, VoitureDAO> {

	List<Voiture> findAllOrderByMarqueModele() throws ServiceException;

	// Voiture save(Voiture voiture) throws ServiceException;
	//
	// void remove(Voiture voiture) throws ServiceException;
	//
	// List<Voiture> findAll() throws ServiceException;
	//
	// Voiture findVoiture(Integer id) throws ServiceException;
	//
	// void removeById(Integer id) throws ServiceException;
}
