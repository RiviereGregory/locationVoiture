<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><fmt:message key="index.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->

	<h1 align="center">
		<fmt:message key="index.titre" />
	</h1>
	<br />
	<br />
	<br />


	<form:form action="reservation.do" commandName="reservation"
		method="GET">
		<p align="center">
			<input type="submit"
				value="<fmt:message key="bouton.ajouterreservation" />" />
		</p>
	</form:form>
	<form:form action="reservations.do" commandName="reservation"
		method="GET">
		<p align="center">
			<input type="submit"
				value="<fmt:message key="bouton.listreservation" />" />
		</p>
	</form:form>
	<br />


	<form:form action="client.do" commandName="client" method="GET">
		<p align="center">
		<p align="center">
			<input type="submit"
				value="<fmt:message key="bouton.ajouterclient" />" />
		</p>
	</form:form>
	<form:form action="clients.do" commandName="client" method="GET">
		<p align="center">
			<input type="submit" value="<fmt:message key="bouton.listclient" />" />
		</p>
	</form:form>
	<br />

	<form:form action="voiture.do" commandName="voiture" method="GET">
		<p align="center">
			<input type="submit"
				value="<fmt:message key="bouton.ajoutervoiture" />" />
		</p>
	</form:form>
	<form:form action="voitures.do" commandName="voiture" method="GET">
		<p align="center">
			<input type="submit" value="<fmt:message key="bouton.listvoiture" />" />
		</p>
	</form:form>
	<br />
	<!-- FOOTER -->
	<%@ include file="/pages/footer.jsp"%>

	<!-- **** -->
</body>
</html>