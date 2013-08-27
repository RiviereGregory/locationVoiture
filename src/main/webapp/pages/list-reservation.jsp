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
<title><fmt:message key="list-reservation.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->
	
	<c:if test="${empty reservations}">
		<h1 align="center">
			<fmt:message key="list-reservation.titre.vide" />
		</h1>
		<br />
		<br />
		<form:form action="reservation.do" commandName="reservation"
			method="GET" align="center">
			<input type="submit"
				value="<fmt:message key="bouton.ajouterreservation" />" />
		</form:form>
	</c:if>
	<c:if test="${not empty reservations}">
		<h1 align="center">
			<fmt:message key="list-reservation.titre" />
		</h1>
		<br />
		<table border="2" align="center">
			<tr>
				<th><fmt:message key="reservation.id" /> <a
					href="orderbyid-reservation.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbyidinvert-reservation.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="reservation.client.id" /></th>
				<th><fmt:message key="reservation.voiture.id" /></th>
				<th><fmt:message key="reservation.date.reservation" /> <a
					href="orderbydatereservation-reservation.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbydatereservationinvert-reservation.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="reservation.date.prisevehicule" /> <a
					href="orderbydateprisevehicule-reservation.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbydateprisevehiculeinvert-reservation.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th><fmt:message key="reservation.date.retour" /> <a
					href="orderbydateretour-reservation.do"><fmt:message
							key="bouton.trie.haut" /></a> <a
					href="orderbydateretourinvert-reservation.do"><fmt:message
							key="bouton.trie.bas" /></a></th>
				<th colspan="2"><fmt:message key="titre.action" /></th>
			</tr>

			<!-- Permet de faire une boucle sur la list voitures avec comme variable utilisable v -->
			<c:forEach items="${reservations}" var="reservation">
				<tr>
					<td>${reservation.id}</td>
					<td>${reservation.client.id}</td>
					<td>${reservation.voiture.id}</td>

					<td><fmt:formatDate value="${reservation.dateReservation}"
							pattern="dd/MM/yyyy" /></td>

					<td><fmt:formatDate value="${reservation.datePriseVehicule}"
							pattern="dd/MM/yyyy" /></td>

					<td><fmt:formatDate value="${reservation.dateRetour}"
							pattern="dd/MM/yyyy" /></td>

					<td><a href="modifier-reservation.do?id=${reservation.id}"><fmt:message
								key="bouton.modifier" /></a></td>
					<security:authorize ifAllGranted="ROLE_ADMIN">
						<td><a href="supprimer-reservation.do?id=${reservation.id}"><fmt:message
									key="bouton.supprimer" /> </a></td>
					</security:authorize>

				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<table border="2" align="center">
			<tr>
				<td><form:form action="reservation.do"
						commandName="reservation" method="GET">
						<input type="submit"
							value="<fmt:message key="bouton.ajouterreservation" />" />
					</form:form></td>
				<td><form:form action="voitures.do" commandName="voiture"
						method="GET">
						<input type="submit"
							value="<fmt:message key="bouton.listvoiture" />" />
					</form:form></td>
				<td><form:form action="clients.do" commandName="client"
						method="GET">
						<input type="submit"
							value="<fmt:message	key="bouton.listclient" />" />
					</form:form></td>
			</tr>
		</table>
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