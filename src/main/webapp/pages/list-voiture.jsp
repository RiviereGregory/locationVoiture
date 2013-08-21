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
<title>Liste des voitures</title>
</head>
<body>
	<c:if test="${empty voitures}">
		<h1>La liste des voitures est vide</h1>
		<br />
		<br />
		<form:form action="voiture.do" commandName="voiture" method="GET">
			<input type="submit" value="Ajouter Voiture" />
		</form:form>
	</c:if>
	<c:if test="${not empty voitures}">
		<h1>liste des voitures</h1>
		<br />
		<table border="2">
			<tr>
				<th>ID</th>
				<th>Marque</th>
				<th>Modele</th>
				<th>Date mise en circulation</th>
				<th colspan="2">Action</th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${voitures}" var="v">
				<tr>
					<td>${v.id}</td>
					<td>${v.marque}</td>
					<td>${v.modele}</td>
					<td>${v.dateMiseEnCirculation}</td>
					<td><a href="modifier-voiture.do?id=${v.id}">Modifier </a></td>
					<td><a href="supprimer-voiture.do?id=${v.id}">Supprimer </a></td>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<form:form action="voiture.do" commandName="voiture" method="GET">
			<input type="submit" value="Ajouter Voiture" />
		</form:form>
	</c:if>
</body>
</html>