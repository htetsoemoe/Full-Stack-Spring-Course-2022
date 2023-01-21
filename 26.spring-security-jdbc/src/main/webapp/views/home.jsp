<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Demo</title>
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
	<div class="container mt-4">
		<h1>Home Page | Spring Security with JDBC</h1>

		<div class="mt-4">
			<a href="/" class="btn btn-primary me-2">Home</a> 
			<a href="/admin/home" class="btn btn-secondary me-2">Admin</a> 
			<a href="/member/home" class="btn btn-warning me-2">Member</a>

			<sec:authorize access="isAnonymous()">
				<a href="/signup" class="btn btn-success me-2">Sign Up</a>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<a href="/logout" class="btn btn-danger me-2">Log Out</a>
			</sec:authorize>

		</div>

		<div class="card mt-4" style="width: 800px" style="height: 600px">
			<img src="/resources/image/cover.jpg" alt="Cover Photo" />
		</div>
	</div>
</body>
</html>