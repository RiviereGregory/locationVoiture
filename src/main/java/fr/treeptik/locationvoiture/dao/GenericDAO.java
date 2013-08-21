package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;

public interface GenericDAO<T, PK> {

	T save(T entite) throws DAOException;

	void remove(T entite) throws DAOException;

	T findById(PK id) throws DAOException;

	List<T> findAll() throws DAOException;

	void removeById(PK id) throws DAOException;
}
