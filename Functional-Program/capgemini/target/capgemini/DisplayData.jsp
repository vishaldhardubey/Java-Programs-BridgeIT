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

	     ServletContext sc = request.getServletContext();
	     Integer a=(Integer)sc.getAttribute("total");
	     Integer b=(Integer)sc.getAttribute("currentUser");

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
		<tr>
		<td>Total Users : </td>
		<td>Current Users :</td>
		</tr>
		<tr>
		<td><%=a %></td>
		<td><%=b %></td>
		</tr>
	</table>
	<form action="ss">
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>