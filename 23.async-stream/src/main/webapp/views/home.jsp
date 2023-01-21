<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Async Streaming in MVC</title>

<style>
.stream-data {
	width: 350px;
	height: 300px;
	background-color: black;
	color: #02a82b;
	font-size: 17px;
	font-family: monospace;
	padding: 25px 50px;
	border-radius: 10px;
	box-sizing: border-box;
	list-style: none;
}
</style>
</head>
<body>
	<h1>Asynchronous Stream Response</h1>

	<ul id="output" class="stream-data">

	</ul>

	<div>
		<button id="streamTrigger">Load Stream Data</button>
		<button id="sseTrigger">Connect SSE Source</button>
	</div>

	<c:url value="/resources/js/client.js" var="clientJS"></c:url>
	<script type="text/javascript" src="${ clientJS }"></script>
</body>
</html>