<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- Pour formater les date -->
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des reservations</title>
</head>
<body>
	<c:if test="${empty reservations}">
		<h1 align="center">La liste des reservations est vide</h1>
		<br />
		<br />
		<form:form action="reservation.do" commandName="reservation"
			method="GET" align="center">
			<input type="submit" value="Ajouter reservation" />
		</form:form>
	</c:if>
	<c:if test="${not empty reservations}">
		<h1 align="center">liste des reservations</h1>
		<br />
		<table border="2" align="center">
			<tr>
				<th>ID <a href="orderbyid-reservation.do">Up</a> <a
					href="orderbyidinvert-reservation.do">Down</a></th>
				<th>Client Id</th>
				<th>Voiture Id</th>
				<th>Date Reservation <a
					href="orderbydatereservation-reservation.do">Up</a> <a
					href="orderbydatereservationinvert-reservation.do">Down</a></th>
				<th>Date Prise Vehicule <a
					href="orderbydateprisevehicule-reservation.do">Up</a> <a
					href="orderbydateprisevehiculeinvert-reservation.do">Down</a></th>
				<th>Date Retour <a href="orderbydateretour-reservation.do">Up</a>
					<a href="orderbydateretourinvert-reservation.do">Down</a></th>
				<th colspan="2">Action</th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${reservations}" var="reservation">
				<tr>
					<td>${reservation.id}</td>
					<td>${reservation.client.id}</td>
					<td>${reservation.voiture.id}</td>

					<td><fmt:formatDate
							value="${reservation.dateReservation}" pattern="dd/MM/yyyy" /></td>

					<td><fmt:formatDate
							value="${reservation.datePriseVehicule}" pattern="dd/MM/yyyy" /></td>

					<td><fmt:formatDate value="${reservation.dateRetour}"
							pattern="dd/MM/yyyy" /></td>

					<td><a href="modifier-reservation.do?id=${reservation.id}">Modifier
					</a></td>
					<td><a href="supprimer-reservation.do?id=${reservation.id}">Supprimer
					</a></td>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<table border="2" align="center">
			<tr>
				<td><form:form action="reservation.do"
						commandName="reservation" method="GET">
						<input type="submit" value="Ajouter reservation" />
					</form:form></td>
				<td><form:form action="voitures.do" commandName="voiture"
						method="GET">
						<input type="submit" value="Liste des voitures" />
					</form:form></td>
				<td><form:form action="clients.do" commandName="client"
						method="GET">
						<input type="submit" value="Liste des clients" />
					</form:form></td>
			</tr>
		</table>
	</c:if>
	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="SOMMAIRE" />
		</p>
	</form:form>
</body>
</html>