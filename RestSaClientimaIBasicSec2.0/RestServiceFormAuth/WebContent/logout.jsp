<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty request.getRemoteUser()}">
User '<%=request.getRemoteUser()%>' has been logged out.
</c:if>
<% session.invalidate(); %>
<jsp:include page="index.jsp"></jsp:include>
