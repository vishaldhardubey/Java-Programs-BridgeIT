<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if ((session.getAttribute("username") == null) || (session.getAttribute("password") == null)) {
			response.sendRedirect("login.jsp");
		}
	%>

	<h1>Successfully Entered</h1>
	<table border="1">
		<tr>
			<td>Serial Number :</td>
			<td>Name :</td>
			<td>Mobile Number :</td>
			<td>Email ID :</td>
		</tr>
		<tr>
			<td>${serialNum}</td>
			<td>${name}</td>
			<td>${mobileNum}</td>
			<td>${emailId}</td>
		</tr>
	</table>
</body>
</html>