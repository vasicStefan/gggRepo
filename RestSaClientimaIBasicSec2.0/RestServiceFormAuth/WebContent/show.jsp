<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<FORM action="/RestServiceFormAuth/rest/restic/vratiProizvodeZaKategoriju"
		method="get">
		<P>
			Id kategorije <INPUT type="text" name="idKat"><BR>
		<P>
			<INPUT type="submit" value="Send">
		</P>
	</FORM>
	<p>
					<h1>Proizvodi</h1>
		
			<c:forEach items="${proizvodi}" var="proizvod">
			
			<p>opis: ${proizvod.opis}</p>
			<p>cena: ${proizvod.pocetnacena}</p>
			
			</c:forEach>
		<c:if test="${!empty request.getRemoteUser()}">
			<a href="/RestServiceFormAuth/logout.jsp">Logout</a>
			<br>
		</c:if>
</body>
</html>