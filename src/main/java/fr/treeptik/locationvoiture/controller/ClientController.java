package fr.treeptik.locationvoiture.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;
import fr.treeptik.locationvoiture.service.ReservationService;
import fr.treeptik.locationvoiture.validator.ClientValidator;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ClientValidator validator;

	@Autowired
	private MessageSource messageSource;

	private Logger logger = Logger.getLogger(ClientController.class);

	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
	public ModelAndView intiClient(HttpServletRequest request) {
		// Affiche le log dans le niveau info et affiche le nom de l'utilisateur qui est connecté
		// dans la session avec request.getSession().getAttribute("userName") que l'on a récupéré
		// dans l'indexcotroller
		logger.info("Appel intiClient Methode GET USER : "
				+ request.getSession().getAttribute("userName"));
		Client c = new Client();

		ModelAndView modelAndView = new ModelAndView("saisie-client", "client", c);

		return modelAndView;

	}

	@RequestMapping(value = "/client.do", method = RequestMethod.POST)
	public ModelAndView saisieClient(Client client) {
		logger.info("Appel saisieClient Methode POST");
		System.out.println("client id : " + client.getId());

		return new ModelAndView("saisie-client", "client", client);

	}

	@RequestMapping(value = "/clients.do", method = RequestMethod.POST)
	public ModelAndView saveClient(@Valid Client client, BindingResult errors) {
		logger.info("Appel saveClient Methode POST");

		Map<String, Object> params = new HashMap<String, Object>();

		if (errors.hasErrors()) {
			return new ModelAndView("saisie-client", "client", client);

		} else {
			validator.validate(client, errors);
			if (errors.hasErrors()) {
				return new ModelAndView("saisie-client", "client", client);

			}
		}

		try {
			clientService.save(client);

			params.put("clients", clientService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/clients.do", method = RequestMethod.GET)
	public ModelAndView afficheClient() {
		logger.info("Appel afficheClient Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("clients", clientService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/modifier-client.do", method = RequestMethod.GET)
	public ModelAndView updateClient(@RequestParam("id") Integer id) {
		// Affiche le log dans le niveau info
		logger.info("Appel updateClient Methode GET");
		Client c = null;
		try {
			c = clientService.findById(id);
			// Affiche le log dans le niveau debug
			logger.debug(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("saisie-client", "client", c);

	}

	@RequestMapping(value = "/supprimer-client.do", method = RequestMethod.GET)
	public ModelAndView removeClient(@RequestParam("id") Integer id,
			RedirectAttributes redirectAttributes, Locale locale) {
		// il faut mettre RedirectAttributes redirectAttributes, Locale locale pour pouvoir
		// internationalisé car BindingResult errors ne peut pas etre utilisé après un @RequestParam
		logger.info("Appel removeClient Methode GET");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			if (reservationService.findByClient(id).isEmpty()) {

				clientService.removeById(id);

			} else {
				// Le messageSource permet d'afficher le message internationaliser
				params.put("ERROR_DELETE",
						messageSource.getMessage("erreur.client.reservation", null, locale));

			}

			params.put("clients", clientService.findAll());

		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("Impossible effacer");
		}
		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/orderbyid-client.do", method = RequestMethod.GET)
	public ModelAndView orderByIdClient() {
		logger.info("Appel orderByIdClient Methode GET");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("clients", clientService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/orderbyidinvert-client.do", method = RequestMethod.GET)
	public ModelAndView orderByIdInvertClient() {
		logger.info("Appel orderByIdInvertClient Methode GET");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			List<Client> list = clientService.findAll();
			Collections.reverse(list);
			params.put("clients", list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/orderbynom-client.do", method = RequestMethod.GET)
	public ModelAndView orderByIdNomPrenomClient() {
		logger.info("Appel orderByIdNomPrenomClient Methode GET");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("clients", clientService.findAllOrderByNomPrenom());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/orderbynominvert-client.do", method = RequestMethod.GET)
	public ModelAndView orderByIdNomPrenomInvertClient() {
		logger.info("Appel orderByIdNomPrenomInvertClient Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			List<Client> list = clientService.findAllOrderByNomPrenom();
			Collections.reverse(list);
			params.put("clients", list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/orderbyprenom-client.do", method = RequestMethod.GET)
	public ModelAndView orderByIdPrenomNomClient() {
		logger.info("Appel orderByIdPrenomNomClient Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("clients", clientService.findAllOrderByPrenomNom());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/orderbyprenominvert-client.do", method = RequestMethod.GET)
	public ModelAndView orderByIdPrenomNomInvertClient() {
		logger.info("Appel orderByIdPrenomNomInvertClient Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			List<Client> list = clientService.findAllOrderByPrenomNom();
			Collections.reverse(list);
			params.put("clients", list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

}
