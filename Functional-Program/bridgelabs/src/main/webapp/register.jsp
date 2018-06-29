    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Form</title>
    </head>
    <body>
    <%-- 
    <%
    	if((session.getAttribute("username")==null)||(session.getAttribute("password")==null)){
    		response.sendRedirect("login.jsp");
    	}
    %> --%>
    
    <fieldset title="Registration Page">
<legend>Registration Page</legend>
    <form action="RegistrationServlet" method="post">
    			<table style="with: 50%">
    				<tr>
    					<td>Enter Name</td>
    					<td><input type="text" name="name" /></td>
    				</tr>
    				<tr>
    					<td>Contact No</td>
    					<td><input type="text" name="contact" /></td>
    				</tr>
    				<tr>
    					<td>Email ID</td>
    					<td><input type="text" name="username" /></td>
    				</tr>
    					<tr>
    					<td>Password</td>
    					<td><input type="password" name="password" /></td>
    				</tr>
    				</table>
    			<input type="submit" value="Submit" /></form>
    			</fieldset>
    </body>
    </html>