<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Početna strana</title>
</head>
<body>
	<h2>Dobrodosli!</h2>
	<br>
	<a href="/RestServiceFormAuth/show.jsp">Prikazi kategorije</a>
	<br>
	<a href="/RestServiceFormAuth/unos.jsp">Slanje poruke</a>
	<br>
	<c:if test="${not empty request.getRemoteUser()}">
	<a href="/RestServiceFormAuth/logout.jsp">Logout</a>
		<br>
	</c:if>

</body>
</html>