<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
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
		<h1>Sing In</h1>
		<div class="row">
			<div class="col">
				<form action="/login" method="post">
					<div class="mb-4">
						<label>Login ID</label>
						<input type="text" name="loginId" placeholder="Enter Login ID" class="form-control" />
					</div>
					
					<div class="mb-4">
						<label>Password</label>
						<input type="password" name="password" placeholder="Enter Password" class="form-control" />
					</div>
					
					<button type="submit" class="btn btn-primary">Sign In</button>
					<a href="/signup" class="btn btn-warning">Sign Up</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>