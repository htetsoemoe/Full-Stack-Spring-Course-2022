<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello MVC</title>
</head>
<body>
	<h1>Hello Spring MVC</h1>
	
	<c:out value="${message}"></c:out>
	
	<ul>
		<li>
		
			<c:url value="/legacy" var="legacyLink"></c:url>
			<a href="${legacyLink}">Legacy Controller</a>
		
		</li>
	</ul>
</body>
</html>