<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<form action="SendMailServlet">
			To:<input type="text" name="to" required /><br /> 
			Subject:<input type="text" name="subject" ><br /> 
			Text:<textarea rows="10" cols="70" name="msg"></textarea><br/> 
			<input type="submit" value="send" />
		</form>
	</body>
</html>