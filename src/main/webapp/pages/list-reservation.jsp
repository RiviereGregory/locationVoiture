<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des reservations</title>
</head>
<body>
	<c:if test="${empty reservations}">
		<h1>La liste des reservations est vide</h1>
		<br />
		<br />
		<form:form action="reservation.do" commandName="reservation"
			method="GET">
			<input type="submit" value="Ajouter reservation" />
		</form:form>
	</c:if>
	<c:if test="${not empty reservations}">
		<h1>liste des reservations</h1>
		<br />
		<table border="2">
			<tr>
				<th>ID</th>
				<th>Client Id</th>
				<th>Voiture Id</th>
				<th>dateReservation</th>
				<th>datePriseVehicule</th>
				<th>dateRetour</th>
				<th colspan="2">Action</th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${reservations}" var="reservation">
				<tr>
					<td>${reservation.id}</td>
					<td>${reservation.client.id}</td>
					<td>${reservation.voiture.id}</td>
					<td>${reservation.dateReservation}</td>
					<td>${reservation.datePriseVehicule}</td>
					<td>${reservation.dateRetour}</td>
					<td><a href="modifier-reservation.do?id=${reservation.id}">Modifier
					</a></td>
					<td><a href="supprimer-reservation.do?id=${reservation.id}">Supprimer
					</a></td>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<form:form action="reservation.do" commandName="reservation"
			method="GET">
			<input type="submit" value="Ajouter reservation" />
		</form:form>
	</c:if>
</body>
</html>