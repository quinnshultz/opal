<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Login Page</title>
</head>

<body>
	<form action="LoginServlet">

		Please enter your user-name <input type="text" name="username" /><br>

		Please enter your password <input type="password" name="password" />
		<input type="submit" value="submit" name="submit">

	</form>
	<button onClick="javasript:window.location.href='RegisterPage.jsp'" name="register">Register</button>
</body>
</html>