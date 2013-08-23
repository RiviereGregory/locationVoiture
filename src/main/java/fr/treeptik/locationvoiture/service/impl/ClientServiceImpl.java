package fr.treeptik.locationvoiture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Integer, ClientDAO> implements
		ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	protected ClientDAO getDao() {
		return clientDAO;
	}

	@Override
	public List<Client> findAllOrderByNomPrenom() throws ServiceException {
		List<Client> list;
		try {
			list = clientDAO.findAllOrderByNomPrenom();
		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}
}
