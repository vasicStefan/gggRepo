<%@page import="servlets.AktivniProizvodiBean"%>
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
	<jsp:useBean id="aktivni" class="servlets.AktivniProizvodiBean" scope="page"></jsp:useBean>

	<c:if test="${not empty aktivni.proizvodi}">
		<table>
			<tr>
				<th>Id Kategorije</th>
				<th>naziv</th>
			</tr>
			<c:forEach var="p" items="${aktivni.proizvodi}">
				<tr>
					<td>${p.idproizvoda}</td>
					<td>${p.opis}</td>
					<td>${p.pocetnacena}</td>
					<td>${p.vlasnik.idvlasnika}</td>
					 	<td><a href="/RestWebClient/GetPonude?idProiz=${p.idproizvoda}">Prikazi
							ponude</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>