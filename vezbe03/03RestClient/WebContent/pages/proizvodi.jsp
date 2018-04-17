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
	<c:if test="${not empty proizvodi}">
		<table>
			<tr>
				<th>Id Proizvoda</th>
				<th>opis</th>
				<th>pocetna cena</th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${proizvodi}">
				<tr>
					<form action="/RestWebClient/NapraviPonuduServlet" method="get">
					<td><input type="hidden" value="${p.idproizvoda}" name="idproizvoda">${p.idproizvoda}</td>
					<td>${p.opis}</td>
					<td>${p.pocetnacena}</td>
					<td><input type="text" name="ponuda"></td>
					<!--  <td><a
							href="/RestWebClient/NapraviPonuduServlet?idPond=${p.idproizvoda}&iznos=${ponuda}">ponudi</a></td>
						-->
					<td>
						<button type="submit">ponudi!</button>
					</td>
					</form>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>