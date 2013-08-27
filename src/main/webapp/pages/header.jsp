
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

<style type="text/css">

<%@ include file="/pages/style.css"%>

</style>
<!-- il ne faut pas mettre les balises pour que le fichier soit unique avec les includes -->

<div id="header">
	<p id="header">
		<fmt:message key="header.titre" />
	</p>
	<a href="/location-voiture/j_spring_security_logout"><fmt:message
			key="bouton.deconnexion" /></a> <br /> <br /> <br />
	<!-- permet de faire un trait -->

	<hr />
</div>
