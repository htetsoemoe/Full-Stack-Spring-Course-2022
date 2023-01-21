<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scope Demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container pt-4">
		<h1>Scope Demo</h1>

		<div class="row mt-4 mb-4">
			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>
					<div class="card-body">
						${request}
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>
					<div class="card-body">
						${session}
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>
					<div class="card-body">
						${application}
					</div>
				</div>
			</div>
		</div>
		
		<h3>Access Scope Object</h3>
		
			<div class="row mt-4 mb-4">
				<div class="col">
					<div class="card">
						<div class="card-header">Request Scope</div>
						<div class="card-body">${requestScope.counter.count}</div>
						<!-- requestScope is Servlet Request Scope -->
					</div>
				</div>
				<div class="col">
					<div class="card">
						<div class="card-header">Session Scope</div>
						<div class="card-body">${sessionScope.counter.count}</div>
						<!-- requestScope is Servlet Session Scope -->
					</div>
				</div>
				<div class="col">
					<div class="card">
						<div class="card-header">Application Scope</div>
						<div class="card-body">${applicationScope.counter.count}</div>
						<!-- requestScope is Servlet Context (Application Scope) -->
					</div>
				</div>
			</div>

		<div class="mb-4">
			<c:url value="/" var="home"></c:url>
			<a href="${home}" class="btn btn-primary">Load Home</a>
			
			<c:url value="/create-session" var="cart"></c:url>
			<a href="${cart}" class="btn btn-primary">Session Demo</a>
		</div>
		
	</div>


</body>
</html>