<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title><spring:message code="login.titre" /></title>
</head>
<body>
	<h1><spring:message code="login.erreur" /></h1>
	<form action="/location-voiture/j_spring_security_check" method="POST">
		<!-- 		Login : <input type="text" name="j_username"> Password : <input -->
		<!-- 			type="password" name="j_password"> <input type="submit" -->
		<!-- 			value="Login"> -->
		<label for="username"><spring:message
				code="login.label.username" />:</label> <input type="text"
			name="j_username"> <br> <label for="password"><spring:message
				code="login.label.password" />:</label> <input type="password"
			name="j_password"> <br> <input type="submit"
			value="<spring:message code="login.button.submit"/>">

	</form>
</body>
</html>