<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- pour les jstl pour utiliser foreach entre autre-->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- Pour formater les date -->
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!-- pour spring security -->
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="list-voiture.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->
	
	<fmt:bundle basename="messages" />
	<c:if test="${empty voitures}">
		<h1 align="center">
			<fmt:message key="list-voiture.titre.vide" />
		</h1>
		<br />
		<br />
		<form:form action="voiture.do" commandName="voiture" method="GET"
			align="center">
			<input type="submit"
				value="<fmt:message key="bouton.ajoutervoiture" />" />
		</form:form>
	</c:if>
	<c:if test="${not empty voitures}">
		<h1 align="center">
			<fmt:message key="list-voiture.titre" />
		</h1>
		<br />
		<p align="center">
			<font color=red>${erreurVoitureReservation}</font>
		</p>
		<br />
		<table border="2" align="center">
			<tr>
				<th><fmt:message key="voiture.id" /> <a
					href="orderbyid-voiture.do"><fmt:message key="bouton.trie.haut" /></a>
					<a href="orderbyidinvert-voiture.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="voiture.marque" /><a
					href="orderbymarque-voiture.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbymarqueinvert-voiture.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="voiture.modele" /><a
					href="orderbymodele-voiture.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbymodeleinvert-voiture.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="voiture.date" /></th>
				<th colspan="2"><fmt:message key="titre.action" /></th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${voitures}" var="v">
				<tr>
					<td>${v.id}</td>
					<td>${v.marque}</td>
					<td>${v.modele}</td>
					<td><fmt:formatDate value="${v.dateMiseEnCirculation}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="modifier-voiture.do?id=${v.id}"><fmt:message
								key="bouton.modifier" /></a></td>
					<security:authorize ifAllGranted="ROLE_ADMIN">
						<td><a href="supprimer-voiture.do?id=${v.id}"><fmt:message
									key="bouton.supprimer" /></a></td>
					</security:authorize>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<table border="2" align="center">
			<tr>
				<td><form:form action="voiture.do" commandName="voiture"
						method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.ajoutervoiture" />" />
					</form:form></td>
				<td><form:form action="clients.do" commandName="client"
						method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.listclient" />" />
					</form:form></td>
				<td><form:form action="reservations.do"
						commandName="reservation" method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.listreservation" />" />
					</form:form></td>
			</tr>
		</table>
	</c:if>
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