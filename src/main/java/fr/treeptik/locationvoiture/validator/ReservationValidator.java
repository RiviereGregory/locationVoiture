package fr.treeptik.locationvoiture.validator;

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
