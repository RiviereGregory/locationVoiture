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
<title><fmt:message key="saisie-voiture.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->

	<fmt:bundle basename="messages" />

	<!-- Dans le if la condition on la met ${ici } -->
	<c:if test="${empty voiture.id}">
		<h1 align="center">
			<fmt:message key="saisie-voiture.titre" />
		</h1>
		<br />
	</c:if>
	<c:if test="${not empty voiture.id}">
		<h1 align="center">
			<fmt:message key="saisie-voiture.titre" />
		</h1>
		<br />
	</c:if>

	<!--  action page sur laquelle il va lorsque l'on appui sur valider -->
	<form:form action="voitures.do" commandName="voiture" method="POST">


		<!-- 		Pour recuperer la variable id dans voiture -->
		<form:hidden path="id" />
		<table align="center">



			<tr>
				<td><fmt:message key="voiture.marque" /> :</td>
				<td><form:input path="marque" /> <form:errors path="marque" /></td>
			</tr>
			<tr>
				<td><fmt:message key="voiture.modele" /> :</td>
				<td><form:input path="modele" /> <form:errors path="modele" /></td>
			</tr>
			<tr>
				<td><fmt:message key="voiture.date" /> :</td>
				<td><form:input path="dateMiseEnCirculation"
						placeholder="JJ/MM/AAAA" /> <form:errors
						path="dateMiseEnCirculation" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<fmt:message key="bouton.valider" />" /></td>
			</tr>
		</table>
	</form:form>
	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="<fmt:message key="bouton.sommaire" />" />
		</p>
	</form:form>

	<!-- FOOTER -->
	<%@ include file="/pages/footer.jsp"%>

	<!-- **** -->
</body>
</html>