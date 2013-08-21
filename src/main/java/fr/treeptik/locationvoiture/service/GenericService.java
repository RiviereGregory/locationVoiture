package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.exception.ServiceException;

public interface GenericService<T, PK, D>  {
	T save(T entite) throws ServiceException;

	void remove(T entite) throws ServiceException;

	T findById(PK id) throws ServiceException;

	List<T> findAll() throws ServiceException;

	void removeById(PK id) throws ServiceException;

}
