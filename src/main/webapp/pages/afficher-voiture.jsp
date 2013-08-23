<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     pour utiliser les balises pour le java on fait des taglib -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Afficher voiture</title>
</head>
<body>

	<h1>Afficher voiture</h1>
	<br />

	<table>
		<tr>
			<td>Marque :</td>
			<td>${voiture.marque}</td>
		</tr>
		<tr>
			<td>Modele :</td>
			<td>${voiture.modele}</td>
		</tr>

	</table>

	<form:form action="index.do" commandName="index" method="GET">
		<p align="center">
			<input type="submit" value="SOMMAIRE" />
		</p>
	</form:form>
</body>
</html>