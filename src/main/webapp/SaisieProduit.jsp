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
<h3>Saisie d'un produit</h3>
<form action="SaveProduit.php" method="post">
<label  >Designation</label>
<input name="designation" value="${produit.designation}" type="text" required="required">
<span></span><br><br>
<label  >Prix</label>
<input name="prix" type="text" value="${produit.prix}">
<span></span>
<br/><br/>
<label  >Quantite</label>
<input name="quantite" type="text" value="${produit.quantite}">
<span></span>
<br/><br/>
<button type="submit">Save</button>
</form>

</body>
</html>