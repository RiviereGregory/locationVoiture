package fr.treeptik.locationvoiture.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.ReservationService;
import fr.treeptik.locationvoiture.service.VoitureService;
import fr.treeptik.locationvoiture.validator.VoitureValidator;

// Annotation pour dire que l'on utilise un controleur
@Controller
public class VoitureController {

	@Autowired
	private VoitureService voitureService;
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private VoitureValidator validator;

	@Autowired
	private MessageSource messageSource;
	// Permet de faire des logs dans le tomcat
	private Logger logger = Logger.getLogger(VoitureController.class);

	// // Pour l'appeler dans une servlet
	// // ici on sera dans localhost:8080/location-voiture/hello
	// @RequestMapping("/hello.do")
	// public void sayHello() {
	// System.out.println("HelloWorld!");
	// }

	// il faut mettre .do pour quelle passe par le controlleur
	@RequestMapping(value = "/voiture.do", method = RequestMethod.GET)
	public ModelAndView intiForm() {
		// Affiche le log dans le niveau info
		logger.info("Appel intiForm Methode GET");
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
		logger.info("Appel saisieVoiture Methode POST");
		logger.debug(voiture);
		System.out.println("Voiture marque : " + voiture.getMarque());

		return new ModelAndView("afficher-voiture", "voiture", voiture);

	}

	@RequestMapping(value = "/voitures.do", method = RequestMethod.POST)
	// @valid permet de valider l'objet s'il y a des erreurs elles sont mise dans l'objet errors de
	// type BindingResult
	public ModelAndView saveVoitures(@Valid Voiture voiture, BindingResult errors) {
		logger.info("Appel saveVoitures Methode POST");
		logger.debug(voiture);
		Map<String, Object> params = new HashMap<String, Object>();

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

			// on passe la list de voiture par le service avec l'objet voitures
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
		logger.info("Appel findAllVoitures Methode GET");

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
		logger.info("Appel updateVoiture Methode GET");
		logger.debug(id);

		Voiture v = null;
		try {
			v = voitureService.findById(id);
			logger.debug(v);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("saisie-voiture", "voiture", v);

	}

	@RequestMapping(value = "/supprimer-voiture.do", method = RequestMethod.GET)
	// il faut mettre RedirectAttributes redirectAttributes, Locale locale pour pouvoir
	// internationalisé car BindingResult errors ne peut pas etre utilisé après un @RequestParam
	public ModelAndView removeVoiture(@RequestParam("id") Integer id,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.info("Appel removeVoiture Methode GET");
		logger.debug(id);

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			if (reservationService.findByVoiture(id).isEmpty()) {

				voitureService.removeById(id);

			} else {
				// params.put("erreurVoitureReservation", "La Voiture est réservée");
				// Le messageSource permet d'afficher le message internationaliser
				params.put("ERROR_DELETE_VOITURE",
						messageSource.getMessage("erreur.voiture.reservation", null, locale));
			}

			params.put("voitures", voitureService.findAll());
		} catch (ServiceException e) {
			// Permet de logger les erreurs
			logger.error(id, e);
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/orderbyid-voiture.do", method = RequestMethod.GET)
	public ModelAndView orderByIdVoiture() {
		logger.info("Appel orderByIdVoiture Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("voitures", voitureService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/orderbyidinvert-voiture.do", method = RequestMethod.GET)
	public ModelAndView orderByIdInvertVoiture() {
		logger.info("Appel orderByIdInvertVoiture Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			List<Voiture> list = voitureService.findAll();
			Collections.reverse(list);
			params.put("voitures", list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/orderbymarque-voiture.do", method = RequestMethod.GET)
	public ModelAndView orderByMarqueVoiture() {
		logger.info("Appel orderByMarqueVoiture Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("voitures", voitureService.findAllOrderByMarqueModele());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/orderbymarqueinvert-voiture.do", method = RequestMethod.GET)
	public ModelAndView orderByMarqueInvertVoiture() {
		logger.info("Appel orderByMarqueInvertVoiture Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			List<Voiture> list = voitureService.findAllOrderByMarqueModele();
			Collections.reverse(list);
			params.put("voitures", list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/orderbymodele-voiture.do", method = RequestMethod.GET)
	public ModelAndView orderByModeleVoiture() {
		logger.info("Appel orderByModeleVoiture Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("voitures", voitureService.findAllOrderByModeleMarque());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

	@RequestMapping(value = "/orderbymodeleinvert-voiture.do", method = RequestMethod.GET)
	public ModelAndView orderByModeleInvertVoiture() {
		logger.info("Appel orderByModeleInvertVoiture Methode GET");

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			List<Voiture> list = voitureService.findAllOrderByModeleMarque();
			Collections.reverse(list);
			params.put("voitures", list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("list-voiture", params);

	}

}
