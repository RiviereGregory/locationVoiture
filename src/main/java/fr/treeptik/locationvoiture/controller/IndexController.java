package fr.treeptik.locationvoiture.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	private Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView intIndex() {
		logger.info("Appel intIndex Methode GET");
		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;

	}

}
