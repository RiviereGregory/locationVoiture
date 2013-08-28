package fr.treeptik.locationvoiture.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

import fr.treeptik.locationvoiture.model.Client;

public class ConsoleNotifier {
	public void afterReturning(StaticPart staticPart, Object result) {

		System.out.println("Point cut : " + staticPart.toShortString());
		System.out.println("Object saved : " + result.getClass().getName());

		if (result instanceof Client) {
			// Client c = (Client) result;
			System.out.println("C'est un client");
		}

		System.out.println("Message send ");

	}

	public void beforeSave(JoinPoint joinPoint) {

		System.out.println("Avant save  ");

	}
}
