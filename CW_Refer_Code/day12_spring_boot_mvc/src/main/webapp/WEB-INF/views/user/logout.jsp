<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="user" value="${requestScope.user_details}" />
	<h5>Hello , ${user.firstName} ${user.lastName}</h5>
	<h6>You have logged out ....</h6>
	<c:url var="url" value="/user/login" />
	<h5>
		<a href="${url}">Visit Again</a>
	</h5>


</body>
</html>