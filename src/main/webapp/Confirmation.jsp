<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
</head>
<body>
<%@include file="header.jsp" %>
<h3>Confirmation</h3>
<div>
<label>ID:</label>
<label>${produit.id}</label>
</div>
<div>
<label>Designation:</label>
<label>${produit.designation}</label>
</div>
<div>
<label>Prix:</label>
<label>${produit.prix}</label>
</div>
<div>
<label>Quatite:</label>
<label>${produit.quantite}</label>
</div>


</body>
</html>