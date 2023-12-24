<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
</head>
<body>
<%@include file="header.jsp" %>>
<form action="chercher.php" method="get">
<label>Mot Cle</label>
<input type="text" name="motCle" value="${model.motCle}"/>
<button type="submit">chercher</button>
</form>
<table>
<tr>
<th>ID</th><th>Designation</th><td>Prix</td><td>Quantite</td>
</tr>
<c:forEach items="${model.produits}" var="p">
<tr>
  <td>${p.id}</td>
  <td>${p.designation}</td>
  <td>${p.prix}</td>
  <td>${p.quantite}</td>
  <td><a onclick="return confirm('Etes vous sure?')"href="Supprimer.php?id=${p.id}">Supprimer</a></td>
  <td><a href="Edit.php?id=${p.id}">Modifier</a></td>
  </tr>
</c:forEach>

</table>
</body>
</html>