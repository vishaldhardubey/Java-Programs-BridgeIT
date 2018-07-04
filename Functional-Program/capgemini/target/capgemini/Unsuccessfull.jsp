 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Form</title>
    </head>
    <body>
    
    <h1 fontcolor="Red">User Already Exists</h1>
    <h3> Please try with the different Email ID</h3>
    <%-- 
    <%
    	if((session.getAttribute("username")==null)||(session.getAttribute("password")==null)){
    		response.sendRedirect("login.jsp");
    	}
    %> --%>
    
    <fieldset title="Registration Page">
<legend>Registration Page</legend>
    <form action="Registration" method="post">
    			<table>
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
    					<td><input type="email" name="email" /></td>
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