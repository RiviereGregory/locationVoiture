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
<title>Liste des Clients</title>
</head>
<body>
	<c:if test="${empty clients}">
		<h1 align="center">La liste des clients est vide</h1>
		<br />
		<br />
		<form:form action="client.do" commandName="client" method="GET"
			align="center">
			<input type="submit" value="Ajouter client" />
		</form:form>
	</c:if>
	<c:if test="${not empty clients}">
		<h1 align="center">liste des clients</h1>
		<br />
		<p align="center">
			<font color=red>${erreurClientReservation}</font>
		</p>
		<br />
		<table border="2" align="center">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th colspan="2">Action</th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.id}</td>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td>${client.mail}</td>
					<td><a href="modifier-client.do?id=${client.id}">Modifier
					</a></td>
					<td><a href="supprimer-client.do?id=${client.id}">Supprimer
					</a></td>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<table border="2" align="center">
			<tr>
				<td><form:form action="client.do" commandName="client"
						method="GET">
						<input type="submit" value="Ajouter client" />
					</form:form></td>
				<td><form:form action="reservations.do"
						commandName="reservation" method="GET">
						<input type="submit" value="Liste des reservations" />
					</form:form></td>
				<td><form:form action="voitures.do" commandName="voiture"
						method="GET">
						<input type="submit" value="Liste des voitures" />
					</form:form></td>
			</tr>
		</table>
		<br />
	</c:if>
	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="SOMMAIRE" />
		</p>
	</form:form>
</body>
</html>