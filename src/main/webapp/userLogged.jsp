<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="com.billsbackyardbees.opal.bean.OpalUser"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>User Logged Successfully</title>
</head>

<body>

	<center>
		<% OpalUser currentUser = (OpalUser) (session.getAttribute("currentSessionUser"));%>

		Welcome
		<%= currentUser.getFullName() %>
	</center>
	
	<form action="NewPAServlet">
		Please enter the URL this site is located at: <input type="text" name="url" /><br>
		
		Please enter a name for this site: <input type="text" name="name" /><br>
		
		Please enter your user-name for this site: <input type="text" name="username" /><br>

		Please enter your password for this site: <input type="password" name="password" /><br>
		
		Notes: <input type="text" name="notes" />
		<input type="submit" value="submit">
	</form>

</body>

</html>
