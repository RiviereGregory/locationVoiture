package fr.treeptik.locationvoiture.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Voiture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/dispatcher-servlet.xml" })
public class VoitureDAOImplTest {

	@Autowired
	private VoitureDAO voitureDAO;

	@Ignore
	@Test
	@Transactional
	public void testSave() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");

			voitureDAO.save(voiture);
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Ignore
	@Test
	@Transactional
	public void testfindall() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");
			voitureDAO.save(voiture);
			voiture = new Voiture(null, "Peugeot", "206");
			voitureDAO.save(voiture);
			voiture = new Voiture(null, "Peugeot", "305");
			voitureDAO.save(voiture);
			voiture = new Voiture(null, "Renault", "clio");
			voitureDAO.save(voiture);
			voiture = new Voiture(null, "Citroen", "c2");
			voitureDAO.save(voiture);

			List<Voiture> list = voitureDAO.findAll();
			for (Voiture voiture2 : list) {
				System.out.println(voiture2);
				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Ignore
	@Test
	@Transactional
	public void testremote() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");
			voitureDAO.save(voiture);
			voiture = new Voiture(null, "Peugeot", "206");
			voitureDAO.save(voiture);
			List<Voiture> list = voitureDAO.findAll();
			for (Voiture voiture2 : list) {
				System.out.println(voiture2);
				System.out.println("");
			}

			voitureDAO.remove(voiture);
			list = voitureDAO.findAll();
			for (Voiture voiture2 : list) {
				System.out.println(voiture2);
				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void testFindById() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");
			voitureDAO.save(voiture);
			voiture = new Voiture(null, "Peugeot", "206");
			voitureDAO.save(voiture);
			voitureDAO.findAll();

			Voiture voiture2 = voitureDAO.findVoiture(voiture.getId());

			System.out.println(voiture2);
			System.out.println("");

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}
}
