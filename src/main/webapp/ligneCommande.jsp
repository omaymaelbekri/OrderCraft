<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produit Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Produit
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Produits</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${produit != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${produit == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${produit != null}">
            			Edit Todo
            		</c:if>
						<c:if test="${produit == null}">
            			Add New Produit
            		</c:if>
					</h2>
				</caption>

				<c:if test="${produit != null}">
					<input type="hidden" name="id" value="<c:out value='${produit.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Produit Title</label> <input type="text"
						value="<c:out value='${produit.title}' />" class="form-control"
						name="title" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Produit Decription</label> <input type="text"
						value="<c:out value='${produit.description}' />" class="form-control"
						name="description" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Produit Status</label> <select class="form-control"
						name="isDone">
						<option value="false">In Progress</option>
						<option value="true">Complete</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Produit Target Date</label> <input type="date"
						value="<c:out value='${produit.targetDate}' />" class="form-control"
						name="targetDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
