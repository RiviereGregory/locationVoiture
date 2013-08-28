<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="saisie-client.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->
	
	<fmt:bundle basename="messages" />
	<!-- Dans le if la condition on la met ${ici } -->
	<c:if test="${empty client.id}">
		<h1 align="center">
			<spring:message code="saisie-client.titre" />
		</h1>
		<br />
	</c:if>
	<c:if test="${not empty client.id}">
		<h1 align="center">
			<spring:message code="saisie-client.titre.modifier" />
		</h1>
		<br />
	</c:if>

	<!--  action page sur laquelle il va lorsque l'on appui sur valider -->
	<form:form action="clients.do" commandName="client" method="POST">


		<!-- 		Pour recuperer la variable id dans voiture -->
		<form:hidden path="id" />
		<table align="center">
			<tr>
				<td><spring:message code="client.nom" /> :</td>
				<td><form:input path="nom" /> <form:errors path="nom" /></td>
			</tr>
			<tr>
				<td><spring:message code="client.prenom" /> :</td>
				<td><form:input path="prenom" /> <form:errors path="prenom" /></td>
			</tr>
			<tr>
				<td><spring:message code="client.mail" /> :</td>
				<td><form:input path="mail" placeholder="mail@domain.com" /> <form:errors
						path="mail" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="bouton.valider" />" /></td>
			</tr>
		</table>
	</form:form>
	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="<spring:message code="bouton.sommaire" />" />
		</p>
	</form:form>
	<!-- FOOTER -->
	<%@ include file="/pages/footer.jsp"%>

	<!-- **** -->
</body>
</html>