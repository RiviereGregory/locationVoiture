package fr.treeptik.locationvoiture.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class LogNotifier {

	private Logger logger;

	@SuppressWarnings("rawtypes")
	public void afterReturning(StaticPart staticPart, Object result) {
		try {

			System.out.println("result get class : " + result.getClass());

			// On logge sur la le type passer en paramètre sur Staticpart
			logger = Logger.getLogger(staticPart.getSignature().getDeclaringTypeName());
			// On recupère le nom de la méthode
			String serviceMethod = staticPart.getSignature().getName();

			// Teste si le result est pas null
			if (result != null) {

				// On teste si on a le nom de la classe fait partie du pojo
				if (result.getClass().getName().startsWith("fr.treeptik.locationvoiture.model")) {
					Method[] pojoMethods = result.getClass().getMethods();

					StringBuilder builder = new StringBuilder();

					builder.append(serviceMethod).append(" ");

					for (Method method : pojoMethods) {
						// Ajoute toute les methodes du pojo
						if (method.getName().startsWith("get")) {
							builder.append(method.getName()).append(" : ")
									.append(method.invoke(result)).append(" ");
						}
					}

					logger.info(builder.toString());

					// On teste si on a une list
				} else if (result.getClass().getName().equals("java.util.ArrayList")
						|| result.getClass().getName().equals("java.util.List")) {
					List list = (List) result;

					// ParameterizedType stringListType = (ParameterizedType)
					// result.getClass().getFgetGenericType();
					// Class<?> stringListClass = (Class<?>)
					// stringListType.getActualTypeArguments()[0];
					// System.out.println(stringListClass); // class java.lang.String.

					// Teste si la liste est pas vide pour utiliser le get(0)
					if (list.size() > 0) {
						list.get(0).getClass();
						logger.info(serviceMethod + " list " + list.get(0).getClass() + " size "
								+ list.size());

					}

				}
			}

		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
		}

	}

	public void beforeSaveService(JoinPoint joinPoint) {

		System.out.println("Avant save  ");

	}
	public void beforeSaveController(JoinPoint joinPoint) {

		System.out.println("Avant save  ");

	}

}
