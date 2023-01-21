<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Async MVC Demo</title>
</head>
<body>
	<h1>Asynchronous MVC Demo</h1>
	<ul>
		<li>
			<c:url value="/async/callable" var="callableLink"></c:url>
			<a href="${ callableLink }">Async Result</a>
		</li>
		<li>
			<c:url value="/async/deferred" var="deferredLink"></c:url>
			<a href="${ deferredLink }">Deferred Result</a>
		</li>		
	</ul>
</body>
</html>