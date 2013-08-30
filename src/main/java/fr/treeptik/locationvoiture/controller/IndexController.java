package fr.treeptik.locationvoiture.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
// Permet d'avoir des attributs que l'on passe pour la validité de la session
// Si on veut plusieurs attribut on {"name","name2","name3"}
@SessionAttributes("userName")
public class IndexController {
	private Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	// Il faut mettre HttpServletRequest pour recuperer les user il faut une dependance
	// javax.servlet-api en scope provided pour ne pas l'importé car elle est déja dans tomcat
	public ModelAndView intIndex(HttpServletRequest request) {
		// Permet d'avoir le login de l'utilisateur
		logger.info("User connecte :" + request.getUserPrincipal().getName());
		logger.info("Appel intIndex Methode GET");
		ModelAndView modelAndView = new ModelAndView("index", "userName", request
				.getUserPrincipal().getName());

		return modelAndView;

	}
}
