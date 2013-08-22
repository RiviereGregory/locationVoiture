package fr.treeptik.locationvoiture.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.service.ClientService;
import fr.treeptik.locationvoiture.service.ReservationService;
import fr.treeptik.locationvoiture.service.VoitureService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private VoitureService voitureService;
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView intiReserv() {
		Map<String, Object> params = new HashMap<String, Object>();
		Reservation reservation = new Reservation();

		try {
			params.put("voitures", voitureService.findAll());
			params.put("clients", clientService.findAll());
			params.put("reservation", reservation);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("saisie-reservation", params);

		return modelAndView;

	}

	@RequestMapping(value = "/reservation.do", method = RequestMethod.POST)
	public ModelAndView saisieReservation(Reservation reservation) {

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("voitures", voitureService.findAll());
			params.put("clients", clientService.findAll());
			params.put("reservation", reservation);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println("reservation date  : " + reservation);
		System.out.println("voiture  : " + reservation.getVoiture().getId());
		System.out.println("client  : " + reservation.getClient().getId());

		return new ModelAndView("saisie-reservation", params);

	}

	@RequestMapping(value = "/reservations.do", method = RequestMethod.POST)
	public ModelAndView saveReservation(Reservation reservation) {

		try {
			reservationService.save(reservation);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("reservations", reservationService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return new ModelAndView("list-reservation", params);

	}

	@RequestMapping(value = "/reservations.do", method = RequestMethod.GET)
	public ModelAndView afficheReservation() {

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("reservations", reservationService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return new ModelAndView("list-reservation", params);

	}

	@RequestMapping(value = "/modifier-reservation.do", method = RequestMethod.GET)
	public ModelAndView updateReservation(@RequestParam("id") Integer id) {
		Reservation r = null;
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			r = reservationService.findById(id);
			params.put("voitures", voitureService.findAll());
			params.put("clients", clientService.findAll());
			params.put("reservation", r);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("saisie-reservation", params);

	}

	@RequestMapping(value = "/supprimer-reservation.do", method = RequestMethod.GET)
	public ModelAndView removeReservation(@RequestParam("id") Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			reservationService.removeById(id);
			params.put("reservations", reservationService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-reservation", params);

	}

}
