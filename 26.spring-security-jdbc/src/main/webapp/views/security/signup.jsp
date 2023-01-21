<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
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
		<h1>Sign Up</h1>
		<div class="row">
			<div class="col-6">
			
				<sf:form action="/signup" modelAttribute="dto"> 
					<div class="mb-3">
						<label for="name">Name</label>
						<sf:input path="name"  placeholder="Enter Name" class="form-control" />
						<sf:errors path="name"></sf:errors>
					</div>
					
					<div class="mb-3">
						<label for="loginId">Login ID</label>
						<sf:input path="loginId"  placeholder="Enter Login ID" class="form-control" />
						<sf:errors path="loginId"></sf:errors>
					</div>
					
					<div class="mb-3">
						<label for="password">Password</label>
						<sf:input path="password"  placeholder="Enter Password" class="form-control" />
						<sf:errors path="password"></sf:errors>
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary">Sign Up</button>
						<a href="/" class="btn btn-warning">Home</a>
					</div>
				</sf:form>

			</div>
		</div>
	</div>

</body>
</html>