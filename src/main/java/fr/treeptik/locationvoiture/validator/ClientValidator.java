package fr.treeptik.locationvoiture.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ReservationService;

@Component
public class ClientValidator implements Validator {
	@Autowired
	private ReservationService reservationService;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Client.class);
	}

	@Override
	public void validate(Object client, Errors errors) {

	}

}
