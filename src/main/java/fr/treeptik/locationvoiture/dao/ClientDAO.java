package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Client;

public interface ClientDAO extends GenericDAO<Client, Integer> {

	List<Client> findAllOrderByNomPrenom() throws DAOException;

	List<Client> findAllOrderByPrenomNom() throws DAOException;

}
