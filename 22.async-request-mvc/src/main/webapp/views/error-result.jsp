<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asynchronous Error</title>
</head>
<body>
	<h1>Asynchronous Error Page</h1>
	
	<p>${ message }</p>
	
	<ul>
		<li>
			<c:url value="/" var="home"></c:url>
			<a href="${ home }">Home</a>
		</li>
	</ul>
</body>
</html>