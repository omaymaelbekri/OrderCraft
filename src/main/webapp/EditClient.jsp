<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
</head>
<body>
<%@include file="header.jsp" %>
<h3>Modifier le client</h3>
<form action="UpdateClient.php" method="post">
<label  >ID</label>
<input name="id" value="${client.id}" type="text" required="required">
<span></span><br><br>
<label  >Nom</label>
<input name="nom" value="${client.nom}" type="text" required="required">
<span></span><br><br>
<label  >Email</label>
<input name="email" type="text" value="${client.email}">
<span></span>
<br/><br/>
<label  >Adresse</label>
<input name="adresse" type="text" value="${client.adresse}">
<span></span>
<br/><br/>
<button type="submit">Save</button>
</form>

</body>
</html>