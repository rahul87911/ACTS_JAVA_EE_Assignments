<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.HashMap"%>
<%@page import="pojos.User"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate Page</title>
</head>
<%
    // Initialize the map of users
    Map<String, User> users = new HashMap<>();
    users.put("rama@gmail.com", new User("rama@gmail.com", "1234", "Rama Kher", 25));
    users.put("mihir@gmail.com", new User("mihir@gmail.com", "2234", "Mihir Patil", 35));
    System.out.println("map created...");
%>
<body>
<%
    // Validation logic
    String email = request.getParameter("em");
    String password = request.getParameter("pass");
    User user = users.get(email);
    if (user != null) {
        // Email is valid
        if (user.getPassword().equals(password)) {
            // Password is valid, store user details under session scope
            session.setAttribute("user_dtls", user);
            // Redirect to display.jsp
            response.sendRedirect(response.encodeRedirectURL("display.jsp"));
        } else {
%>
	<h5 style="color: red;">
		Invalid Password , Please <a href="login2.jsp">Retry</a>
	</h5>
	<%
	}
	} else {
	%>
	<h5 style="color: red;">
		Invalid Email , Please <a href="login2.jsp">Retry</a>
	</h5>
	<%
	}
	%>
</body>
<%
    // Clean up resources
    users = null;
%>
</html>