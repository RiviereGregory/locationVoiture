package fr.treeptik.locationvoiture.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;
import fr.treeptik.locationvoiture.validator.ClientValidator;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientValidator validator;

	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
	public ModelAndView intiClient() {

		Client c = new Client();

		ModelAndView modelAndView = new ModelAndView("saisie-client", "client", c);

		return modelAndView;

	}

	@RequestMapping(value = "/client.do", method = RequestMethod.POST)
	public ModelAndView saisieClient(Client client) {

		System.out.println("client id : " + client.getId());

		return new ModelAndView("saisie-client", "client", client);

	}

	@RequestMapping(value = "/clients.do", method = RequestMethod.POST)
	public ModelAndView saveClient(@Valid Client client, BindingResult errors) {

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
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("clients", clientService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return new ModelAndView("list-client", params);

	}

	@RequestMapping(value = "/clients.do", method = RequestMethod.GET)
	public ModelAndView afficheClient() {

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
		Client c = null;
		try {
			c = clientService.findById(id);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("saisie-client", "client", c);

	}

	@RequestMapping(value = "/supprimer-client.do", method = RequestMethod.GET)
	public ModelAndView removeClient(@RequestParam("id") Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			clientService.removeById(id);
			params.put("clients", clientService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-client", params);

	}

}
