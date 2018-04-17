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
	<c:if test="${not empty ponude}">
		<table>
			<tr>
				<th>Id Proizvoda</th>
				<th>opis</th>
				<th>pocetna cena</th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${ponude}">
				<tr>
					<td>${p.idponude}</td>
					<td>${p.iznos}</td>
					<td>${p.proizvod.opis}</td>
					<td>${p.klijent.ime}</td>
					<td><a
						href="/RestWebClient/ZatvoriPonudu?idPonude=${p.idponude}&idKlijenta=${p.klijent.idklijenta}&idVlasnika=${p.proizvod.vlasnik.idvlasnika}">Zatvori
							ponudu i obavesti klijenta</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>