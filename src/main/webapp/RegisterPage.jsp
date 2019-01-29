<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="windows-1256"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Register Page</title>
</head>

<body>
	<form action="RegisterServlet">
	
		User-name for new account <input type="text" name="username" /><br>

		Full name of user <input type="text" name="fullname" /><br>
		
		Password for new account <input type="password" name="password" />
		<input type="submit" value="submit">
	</form>

</body>
</html>