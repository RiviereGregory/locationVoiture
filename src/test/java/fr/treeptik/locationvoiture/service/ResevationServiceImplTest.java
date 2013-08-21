package fr.treeptik.locationvoiture.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import fr.treeptik.locationvoiture.model.Reservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/dispatcher-servlet.xml" })
public class ResevationServiceImplTest {

	@Autowired
	private ReservationService reservationService;

	@Before
	public void premiereMethode() {
		System.out.println("******* Test Service Reservation *******");
	}

	@Test
	@Transactional
	public void testSave() {
		try {
			Reservation reservation = new Reservation();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			reservation.setDatePriseVehicule(dateFormat.parse("20/12/2012"));
			reservation.setDateResevation(dateFormat.parse("19/12/2012"));
			reservation.setDateRetour(dateFormat.parse("24/12/2012"));

			reservationService.save(reservation);

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void testfindall() {
		try {
			Reservation reservation = new Reservation();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			reservation.setDatePriseVehicule(dateFormat.parse("20/12/2012"));
			reservation.setDateResevation(dateFormat.parse("19/12/2012"));
			reservation.setDateRetour(dateFormat.parse("24/12/2012"));
			reservationService.save(reservation);

			reservation = new Reservation();
			reservation.setDatePriseVehicule(dateFormat.parse("20/07/2013"));
			reservation.setDateResevation(dateFormat.parse("15/06/2013"));
			reservation.setDateRetour(dateFormat.parse("25/07/2013"));
			reservationService.save(reservation);

			reservation = new Reservation();
			reservation.setDatePriseVehicule(dateFormat.parse("20/06/2013"));
			reservation.setDateResevation(dateFormat.parse("15/05/2013"));
			reservation.setDateRetour(dateFormat.parse("24/06/2013"));
			reservationService.save(reservation);

			List<Reservation> list = reservationService.findAll();
			for (Reservation reserv : list) {
				System.out.println(reserv);
				System.out.println("");

			}

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}
	}

}
