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
<title><fmt:message key="saisie-reservation.titre.fenetre" /></title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/pages/header.jsp"%>

	<!-- **** -->

	<!-- Dans le if la condition on la met ${ici } -->
	<c:if test="${empty reservation.id}">
		<h1 align="center">
			<fmt:message key="saisie-reservation.titre" />
		</h1>
		<br />
	</c:if>
	<c:if test="${not empty reservation.id}">
		<h1 align="center">
			<fmt:message key="saisie-reservation.titre.modifier" />
		</h1>
		<br />
	</c:if>
	<br />
	<p align="center">
		<font color=red> <c:if test="${ERROR_CHOIX_VOITURE != null}">
		${ERROR_CHOIX_VOITURE} 
		</c:if>
		</font>
	</p>
	<br />
	<!--  action page sur laquelle il va lorsque l'on appui sur valider -->
	<form:form action="reservations.do" commandName="reservation"
		method="POST">

		<form:hidden path="id" />
		<table align="center">
			<tr>

				<td><fmt:message key="reservation.voiture" /> :</td>
				<!-- 				Pour mettre le id de la voiture dans la reservation -->
				<td><form:select path="voiture.id">
						<c:forEach items="${voitures}" var="v">
							<form:option value="${v.id}">${v.marque} ${v.modele}</form:option>
						</c:forEach>

					</form:select></td>

			</tr>

			<tr>

				<td><fmt:message key="reservation.client" /> :</td>
				<td><form:select path="client.id">
						<c:forEach items="${clients}" var="c">
							<form:option value="${c.id}">${c.nom} ${c.prenom} </form:option>
						</c:forEach>

					</form:select></td>

			</tr>
			<tr>
				<td><fmt:message key="reservation.date.reservation" /> :</td>
				<!-- 				Le placeholder="DD/MM/YYYY" permet de mettre le modele dans la case -->
				<td><form:input path="dateReservation" placeholder="JJ/MM/AAAA" />
					<form:errors path="dateReservation" /></td>
			</tr>
			<tr>
				<td><fmt:message key="reservation.date.prisevehicule" /> :</td>
				<td><form:input path="datePriseVehicule"
						placeholder="JJ/MM/AAAA" /> <form:errors path="datePriseVehicule" /></td>
			</tr>
			<tr>
				<td><fmt:message key="reservation.date.retour" /> :</td>
				<td><form:input path="dateRetour" placeholder="JJ/MM/AAAA" />
					<form:errors path="dateRetour" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="<fmt:message key="bouton.valider" />" /></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td><form:form action="reset-reservation.do" commandName="reset"
					method="GET">
					<input type="submit" value="<fmt:message key="bouton.reset" />" />
				</form:form></td>

			<td><form:form action="index.do" commandName="index"
					method="GET">
					<input type="submit" value="<fmt:message key="bouton.sommaire" />" />
				</form:form></td>
		</tr>
	</table>
	<!-- FOOTER -->
	<%@ include file="/pages/footer.jsp"%>

	<!-- **** -->
</body>
</html>