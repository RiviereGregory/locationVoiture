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
<title>Saisie client</title>
</head>
<body>
	<!-- Dans le if la condition on la met ${ici } -->
	<c:if test="${empty client.id}">
		<h1 align="center">Saisie client</h1>
		<br />
	</c:if>
	<c:if test="${not empty client.id}">
		<h1 align="center">Modifier client</h1>
		<br />
	</c:if>

	<!--  action page sur laquelle il va lorsque l'on appui sur valider -->
	<form:form action="clients.do" commandName="client" method="POST">


		<!-- 		Pour recuperer la variable id dans voiture -->
		<form:hidden path="id" />
		<table align="center">
			<tr>
				<td>Nom :</td>
				<td><form:input path="nom" /> <form:errors path="nom" /></td>
			</tr>
			<tr>
				<td>Prenom :</td>
				<td><form:input path="prenom" /> <form:errors path="prenom" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="mail" placeholder="mail@domain.com" /> <form:errors
						path="mail" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Valider" /></td>
			</tr>
		</table>
	</form:form>
	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="SOMMAIRE" />
		</p>
	</form:form>
</body>
</html>