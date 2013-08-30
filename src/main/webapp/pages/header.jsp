
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
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- pour utiliser le style css -->
<style>
<%@ include file="/css/style.css"%>
</style>

<!-- il ne faut pas mettre les balises pour que le fichier soit unique avec les includes -->

<!-- Permet d'utiliser la config dans le fichier css -->
<div id="header">
	<p id="header">
		<spring:message code="header.titre" />
	</p>
	<a href="/location-voiture/j_spring_security_logout"><spring:message
			code="bouton.deconnexion" /></a> <br />
	<!-- 	on peut passer les parametres des resquest utilisé dans le controller -->
	<spring:message code="header.bienvenue" /> : ${userName} 
	<span style="float: right"> 
	<a href="?lang=en">en <img border="0" src="images/en.gif" alt="en"
			width="20" height="15"></a> | <a href="?lang=fr">fr <img
			border="0" src="images/fr.gif" alt="fr" width="20" height="15"></a>
	</span> <br /> <br />
	<!-- permet de faire un trait -->

	<hr />
</div>
