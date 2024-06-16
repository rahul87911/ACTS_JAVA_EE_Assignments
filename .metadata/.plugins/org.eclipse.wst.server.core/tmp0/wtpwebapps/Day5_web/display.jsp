<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .details-container {
        width: 300px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
</style>
</head>
<body>
 <div class="details-container">
 
        <h2>User Details</h2>
        <p><strong>Email:</strong> ${sessionScope.user_dtls.email}</p>
        <p><strong>Full Name:</strong> ${sessionScope.user_dtls.name}</p>
        <p><strong>Age:</strong> ${sessionScope.user_dtls.age}</p>
        <%
	  String url=response.encodeURL("logout.jsp");
	  %>
	  <a href="<%= url %>">Log Out</a>
    </div>
</body>
</html>