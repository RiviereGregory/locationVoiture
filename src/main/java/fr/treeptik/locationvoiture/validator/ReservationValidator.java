package fr.treeptik.locationvoiture.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Reservation;

@Component
public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Reservation.class);
	}

	@Override
	public void validate(Object reservation, Errors errors) {
		Reservation r = (Reservation) reservation;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String string = dateFormat.format(new Date());
		Date dateCourante = null;
		try {
			dateCourante = dateFormat.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dateCourante.after(r.getDatePriseVehicule())
				&& !dateCourante.equals(r.getDatePriseVehicule())) {
			errors.rejectValue("datePriseVehicule", "saisie-reservation.reservation.dateafter");
		}
		if (dateCourante.after(r.getDateReservation())
				&& !dateCourante.equals(r.getDateReservation())) {
			errors.rejectValue("dateReservation", "saisie-reservation.reservation.dateafter");
		}
		if (dateCourante.after(r.getDateRetour()) && !dateCourante.equals(r.getDateRetour())) {
			errors.rejectValue("dateRetour", "saisie-reservation.reservation.dateafter");
		}

		if (r.getDateRetour().equals(r.getDatePriseVehicule())) {

		} else if (r.getDateRetour().before(r.getDatePriseVehicule())) {
			errors.rejectValue("dateRetour", "saisie-reservation.reservation.dateretourbefore");
		}
		if (r.getDatePriseVehicule().equals(r.getDateReservation())) {

		} else if (r.getDatePriseVehicule().before(r.getDateReservation())) {
			errors.rejectValue("datePriseVehicule",
					"saisie-reservation.reservation.dateprisevehiculebefore");
		}
	}
}
