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
<title>Location Voiture</title>
</head>
<body>

	<h1 align="center">SOMMAIRE</h1>
	<br />
	<br />
	<br />


	<form:form action="reservation.do" commandName="reservation"
		method="GET">
		<p align="center">
			<input type="submit" value="Ajouter reservation" />
		</p>
	</form:form>
	<form:form action="reservations.do" commandName="reservation"
		method="GET">
		<p align="center">
			<input type="submit" value="Liste des reservations" />
		</p>
	</form:form>
	<br />


	<form:form action="client.do" commandName="client" method="GET">
		<p align="center">
		<p align="center">
			<input type="submit" value="Ajouter client" />
		</p>
	</form:form>
	<form:form action="clients.do" commandName="client" method="GET">
		<p align="center">
			<input type="submit" value="Liste des clients" />
		</p>
	</form:form>
	<br />

	<form:form action="voiture.do" commandName="voiture" method="GET">
		<p align="center">
			<input type="submit" value="Ajouter Voiture" />
		</p>
	</form:form>
	<form:form action="voitures.do" commandName="voiture" method="GET">
		<p align="center">
			<input type="submit" value="Liste des voitures" />
		</p>
	</form:form>
	<br />
</body>
</html>