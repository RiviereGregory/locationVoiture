package fr.treeptik.locationvoiture.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.model.Client;

@Repository
public class ClientDAOJPA extends GenericDAOJPA<Client, Integer> implements ClientDAO {

	public ClientDAOJPA() {
		super(Client.class);
	}

}
