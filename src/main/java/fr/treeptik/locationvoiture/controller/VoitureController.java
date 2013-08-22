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
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;
import fr.treeptik.locationvoiture.validator.VoitureValidator;

// Annotation pour dire que l'on utilise un controleur
@Controller
public class VoitureController {

	@Autowired
	private VoitureService voitureService;

	@Autowired
	private VoitureValidator validator;

	// // Pour l'appeler dans une servlet
	// // ici on sera dans localhost:8080/location-voiture/hello
	// @RequestMapping("/hello.do")
	// public void sayHello() {
	// System.out.println("HelloWorld!");
	// }

	// il faut mettre .do pour quelle passe par le controlleur
	@RequestMapping(value = "/voiture.do", method = RequestMethod.GET)
	public ModelAndView intiForm() {

		// Création d'un objet voiture qui va etre rempli par le formulaire
		Voiture v = new Voiture();

		// Saisie-voiture c'est la page ou va aller
		// voiture c'est le nom de la variable que l'on va utilise dans la page jsp
		// v c'est la que la variable voiture va remplir
		ModelAndView modelAndView = new ModelAndView("saisie-voiture", "voiture", v);

		return modelAndView;

	}

	@RequestMapping(value = "/voiture.do", method = RequestMethod.POST)
	public ModelAndView saisieVoiture(Voiture voiture) {

		System.out.println("Voiture marque : " + voiture.getMarque());

		return new ModelAndView("afficher-voiture", "voiture", voiture);

	}

	@RequestMapping(value = "/voitures.do", method = RequestMethod.POST)
	// @valid permet de valider l'objet s'il y a des erreurs elles sont mise dans l'objet errors de
	// type BindingResult
	public ModelAndView saveVoitures(@Valid Voiture voiture, BindingResult errors) {

		if (errors.hasErrors()) {
			return new ModelAndView("saisie-voiture", "voiture", voiture);

		} else {
			validator.validate(voiture, errors);
			if (errors.hasErrors()) {
				return new ModelAndView("saisie-voiture", "voiture", voiture);

			}
		}

		try {
			voitureService.save(voiture);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		Map<String, Object> params = new HashMap<String, Object>();

		// on passe la list de voiture par le service avec l'objet voitures
		try {
			params.put("voitures", voitureService.findAll());
			// params.put("supervoiture", new Voiture(5, "SUPER VOITURE", "SUPER VOITURE"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		// La map nous permet de passer plusieurs paramètre

		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/voitures.do", method = RequestMethod.GET)
	public ModelAndView findAllVoitures() {

		Map<String, Object> params = new HashMap<String, Object>();

		// on passe la list de voiture par le service avec l'objet voitures
		try {
			params.put("voitures", voitureService.findAll());
			// params.put("supervoiture", new Voiture(5, "SUPER VOITURE", "SUPER VOITURE"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		// La map nous permet de passer plusieurs paramètre

		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/modifier-voiture.do", method = RequestMethod.GET)
	public ModelAndView updateVoiture(@RequestParam("id") Integer id) {
		Voiture v = null;
		try {
			v = voitureService.findById(id);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("saisie-voiture", "voiture", v);

	}

	@RequestMapping(value = "/supprimer-voiture.do", method = RequestMethod.GET)
	public ModelAndView removeVoiture(@RequestParam("id") Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			voitureService.removeById(id);
			params.put("voitures", voitureService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

}
