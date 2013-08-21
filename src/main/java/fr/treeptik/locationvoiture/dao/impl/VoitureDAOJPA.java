package fr.treeptik.locationvoiture.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.model.Voiture;

@Repository
public class VoitureDAOJPA extends GenericDAOJPA<Voiture, Integer> implements VoitureDAO {

	public VoitureDAOJPA() {
		super(Voiture.class);
	}

	// @PersistenceContext
	// private EntityManager entityManager;
	//
	// @Override
	// public Voiture save(Voiture voiture) throws DAOException {
	// try {
	// // Utilisation de merge au lieu de persist pour faire un update
	// // Attention il faut l'id pour faire un update aussinon il fait un insert
	// entityManager.merge(voiture);
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	//
	// return voiture;
	// }
	//
	// @Override
	// public void remove(Voiture voiture) throws DAOException {
	// try {
	// entityManager.remove(voiture);
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public List<Voiture> findAll() throws DAOException {
	// try {
	// return entityManager.createQuery("SELECT v FROM Voiture v", Voiture.class)
	// .getResultList();
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public Voiture findVoiture(Integer id) throws DAOException {
	// try {
	// return entityManager.find(Voiture.class, id);
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public void removeById(Integer id) throws DAOException {
	// try {
	// Query query = entityManager.createQuery("DELETE FROM Voiture v WHERE v.id = :id");
	// query.setParameter("id", id);
	// query.executeUpdate();
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }

}
