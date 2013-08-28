package fr.treeptik.locationvoiture.aspect;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint.StaticPart;

import fr.treeptik.locationvoiture.controller.ClientController;

public class LogNotifier {

	private Logger logger;

	public void afterReturning(StaticPart staticPart, Object result) {
		try {
			Method[] methods = result.getClass().getMethods();
			System.out.println("result get class : " + result.getClass());
			logger = Logger.getLogger(ClientController.class);
			for (Method method : methods) {

				if (method.getName().startsWith("get")) {

					// System.out.println("++ " + method.getName() + " " + method.invoke(result));
					logger.info("log Appel " + method.getName() + " Methode GET");
				} else if (method.getName().startsWith("post")) {

					logger.info("log Appel " + method.getName() + " Methode POST");
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

}
