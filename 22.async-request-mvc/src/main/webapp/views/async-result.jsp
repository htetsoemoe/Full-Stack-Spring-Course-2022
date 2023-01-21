<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asynchronous MVC Demo</title>
</head>
<body>
	<h1>Asynchronous Result Page</h1>

	<p>${ message }</p>
	
	<ul>
		<c:forEach var="m" items="${interceptersMessage}">
			<li>${m}</li>
		</c:forEach>
	</ul>

	<c:url value="/" var="home"></c:url>
	<a href="${ home }">Home</a>

</body>
</html>