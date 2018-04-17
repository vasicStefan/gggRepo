<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<FORM action="http://localhost:8080/RestServiceFormAuth/rest/restic/posaljiPorukuKlijentu"
		method="post">
		<table>
			<tr>
				<td>idKlijenta:</td>
				<td><INPUT type="text" name="idKlijenta"></td>
			</tr>
			<tr>
				<td>idVlasnika:</td>
				<td><INPUT type="text" name="idVlasnika"></td>
			</tr>
			<tr>
				<td>sadrzaj:</td>
				<td><INPUT type="text" name="sadrzaj"></td>
			</tr>
			<tr>
				<td>date:</td>
				<td><INPUT type="text" name="date"></td>
			</tr>
				<td></td>
				<td><INPUT type="submit" value="Posalji"></td>
			</tr>
		</table>
	</FORM>
		<c:if test="${!empty request.getRemoteUser()}">
		<a href="/RestServiceFormAuth/logout.jsp">Logout</a>
		<br>
	</c:if>
</body>
</html>