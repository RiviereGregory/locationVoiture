package fr.treeptik.locationvoiture.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class ConsoleNotifier {
	public void afterReturning(StaticPart staticPart, Object result) {
		try {
			Method[] methods = result.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {

					System.out.println("++ " + method.getName() + " " + method.invoke(result));

				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public void beforeSave(JoinPoint joinPoint) {

		System.out.println("Avant save  ");

	}
}
