package fr.treeptik.locationvoiture.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/dispatcher-servlet.xml" })
public class VoitureServiceImplTest {

	@Autowired
	private VoitureService voitureService;

	@Before
	public void premiereMethode() {
		System.out.println("******* Test Service *******");
	}

	@Test
	@Transactional
	public void testSave() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");

			voitureService.save(voiture);
		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void testfindall() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");
			voitureService.save(voiture);
			voiture = new Voiture(null, "Peugeot", "206");
			voitureService.save(voiture);
			voiture = new Voiture(null, "Peugeot", "305");
			voitureService.save(voiture);
			voiture = new Voiture(null, "Renault", "clio");
			voitureService.save(voiture);
			voiture = new Voiture(null, "Citroen", "c2");
			voitureService.save(voiture);

			List<Voiture> list = voitureService.findAll();
			for (Voiture voiture2 : list) {
				System.out.println(voiture2);
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void testremote() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");
			voitureService.save(voiture);
			voiture = new Voiture(null, "Peugeot", "206");
			voitureService.save(voiture);
			List<Voiture> list = voitureService.findAll();
			for (Voiture voiture2 : list) {
				System.out.println(voiture2);
				System.out.println("");
			}

			voitureService.remove(voiture);
			list = voitureService.findAll();
			for (Voiture voiture2 : list) {
				System.out.println(voiture2);
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void testFindById() {
		try {
			Voiture voiture = new Voiture(null, "Peugeot", "205");
			voitureService.save(voiture);
			voiture = new Voiture(null, "Peugeot", "206");
			voitureService.save(voiture);
			voitureService.findAll();

			Voiture voiture2 = voitureService.findVoiture(voiture.getId());

			System.out.println(voiture2);
			System.out.println("");

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

}
