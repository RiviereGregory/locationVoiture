<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- Pour formater les date -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des voitures</title>
</head>
<body>
	<c:if test="${empty voitures}">
		<h1 align="center">La liste des voitures est vide</h1>
		<br />
		<br />
		<form:form action="voiture.do" commandName="voiture" method="GET"
			align="center">
			<input type="submit" value="Ajouter Voiture" />
		</form:form>
	</c:if>
	<c:if test="${not empty voitures}">
		<h1 align="center">liste des voitures</h1>
		<br />
		<p align="center">
			<font color=red>${erreurVoitureReservation}</font>
		</p>
		<br />
		<table border="2" align="center">
			<tr>
				<th>ID <a href="orderbyid-voiture.do">Up</a> <a
					href="orderbyidinvert-voiture.do">Down</a></th>
				<th>Marque<a href="orderbymarque-voiture.do">Up</a> <a
					href="orderbymarqueinvert-voiture.do">Down</a></th>
				<th>Modele<a href="orderbymodele-voiture.do">Up</a> <a
					href="orderbymodeleinvert-voiture.do">Down</a></th>
				<th>Date mise en circulation</th>
				<th colspan="2">Action</th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${voitures}" var="v">
				<tr>
					<td>${v.id}</td>
					<td>${v.marque}</td>
					<td>${v.modele}</td>
					<td><fmt:formatDate value="${v.dateMiseEnCirculation}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="modifier-voiture.do?id=${v.id}">Modifier </a></td>
					<td><a href="supprimer-voiture.do?id=${v.id}">Supprimer </a></td>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<table border="2" align="center">
			<tr>
				<td><form:form action="voiture.do" commandName="voiture"
						method="GET">
						<input type="submit" value="Ajouter Voiture" />
					</form:form></td>
				<td><form:form action="clients.do" commandName="client"
						method="GET">
						<input type="submit" value="Liste des clients" />
					</form:form></td>
				<td><form:form action="reservations.do"
						commandName="reservation" method="GET">
						<input type="submit" value="Liste des reservations" />
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