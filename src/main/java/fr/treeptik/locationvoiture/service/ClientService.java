package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;

public interface ClientService extends GenericService<Client, Integer, ClientDAO> {

	List<Client> findAllOrderByNomPrenom() throws ServiceException;

	List<Client> findAllOrderByPrenomNom() throws ServiceException;

}
