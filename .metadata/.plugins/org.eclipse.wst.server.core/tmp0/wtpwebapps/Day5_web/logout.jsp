<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>
</head>
<body>
<%--session.getAttribute("user_dtls").getName() : sent to clnt --%>
	<h5>Hello , ${sessionScope.user_dtls.name}</h5>
	<%-- invalidate the session --%>
	<%
	session.invalidate();
	%>
	<h5>You have logged out...</h5>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>