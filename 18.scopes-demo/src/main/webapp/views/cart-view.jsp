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
		<h3>@ScopeAttributes Demo</h3>

		<div class="card">

			<h3 class="card-header">Using @SessionAttributes</h3>

			<div class="card-body">
				<div class="row">
					<c:url value="/add-item" var="action"></c:url>
					<form action="${action}" method="post" class="row">

						<div class="col-7">
							<input type="text" name="data" placeholder="Enter String Data"
								class="form-control" />
						</div>

						<div class="col-auto">
							<button type="submit" class="btn btn-primary">Add Item</button>

							<c:url value="/clear-session" var="clearCart"></c:url>
							<a href="${clearCart}" class="btn btn-danger">Clear Item</a>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="mt-4 list-group">
			<div class="list-group-item active">Items in Cart :
				${sessionScope.cart.count}</div>

			<c:forEach var="item" items="${sessionScope.cart.list}">
				<div class="list-group-item">${item}</div>
			</c:forEach>
		</div>


	</div>


</body>
</html>