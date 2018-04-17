<%@page import="servlets.AktivniBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="aktivni" class="servlets.AktivniBean" scope="page"></jsp:useBean>

	<c:if test="${not empty aktivni.kategorije}">
		<table>
			<tr>
				<th>Id Kategorije</th>
				<th>naziv</th>
			</tr>
			<c:forEach var="k" items="${aktivni.kategorije}">
				<tr>
					<td>${k.idkategorije}</td>
					<td>${k.naziv}</td>
				 	<td><a href="/RestWebClient/GetProizvodeKategorije?idKat=${k.idkategorije}">Prikazi
							ponude</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>