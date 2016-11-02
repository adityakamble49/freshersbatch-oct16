<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	    String username = (String) session.getAttribute("username");
	    out.println(username);

	    ArrayList<String> list = (ArrayList<String>) session
	            .getAttribute("comp_list");
	    out.println(list);
	%>

	<form action="controller?forward=logout" method="post">
		<input type="submit" value="Logout">
	</form>

</body>
</html>