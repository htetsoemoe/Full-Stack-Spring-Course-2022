<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Login Page</title>
</head>
<body>

	<div class="container pt-4">
		<div class="row">
			<div class="col-4">
				<div class="card">
					<h5 class="card-header">Login Form</h5>
					<form action="/login" method="post" class="card-body">
						<div class="mb-3">
							<label class="form-label"></label>
							<input type="text" name="loginId" placeholder="Enter Login ID" class="form-control" />
						</div>
						
						<div class="mb-3">
							<label class="form-label"></label>
							<input type="password" name="password" placeholder="Enter Password" class="form-control" />
						</div>
						
						<div>
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>