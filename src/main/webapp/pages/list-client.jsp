<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- pour spring security -->
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="list-client.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->
	
	<fmt:bundle basename="messages" />
	<c:if test="${empty clients}">
		<h1 align="center">
			<fmt:message key="list-client.titre.vide" />
		</h1>
		<br />
		<br />
		<form:form action="client.do" commandName="client" method="GET"
			align="center">
			<input type="submit" value="<fmt:message key="bouton.client" />" />
		</form:form>
	</c:if>
	<c:if test="${not empty clients}">
		<h1 align="center">
			<fmt:message key="list-client.titre" />
		</h1>
		<br />
		<p align="center">
			<font color=red>${erreurClientReservation}</font>
		</p>
		<br />
		<table border="2" align="center">
			<tr>
				<th><fmt:message key="client.id" /> <a
					href="orderbyid-client.do"><fmt:message key="bouton.trie.haut" /></a>
					<a href="orderbyidinvert-client.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="client.nom" /> <a
					href="orderbynom-client.do"><fmt:message key="bouton.trie.haut" /></a>
					<a href="orderbynominvert-client.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="client.prenom" /><a
					href="orderbyprenom-client.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbyprenominvert-client.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="client.mail" /></th>
				<th colspan="2"><fmt:message key="titre.action" /></th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.id}</td>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td>${client.mail}</td>
					<td><a href="modifier-client.do?id=${client.id}"><fmt:message
								key="bouton.modifier" /> </a></td>
					<security:authorize ifAllGranted="ROLE_ADMIN">
						<td><a href="supprimer-client.do?id=${client.id}"><fmt:message
									key="bouton.supprimer" /> </a></td>
					</security:authorize>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<table border="2" align="center">
			<tr>
				<td><form:form action="client.do" commandName="client"
						method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.ajouterclient" />" />
					</form:form></td>
				<td><form:form action="reservations.do"
						commandName="reservation" method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.listreservation" />" />
					</form:form></td>
				<td><form:form action="voitures.do" commandName="voiture"
						method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.listvoiture" />" />
					</form:form></td>
			</tr>
		</table>
		<br />
	</c:if>
	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="<fmt:message	key="bouton.sommaire" />" />
		</p>
	</form:form>
	<!-- FOOTER -->
	<%@ include file="/pages/footer.jsp"%>

	<!-- **** -->
</body>
</html>