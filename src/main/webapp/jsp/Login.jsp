<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<h4>Enter you username and password to login to your portfolio</h4>
	<s:form action="Login">
		<s:textfield name="username" label="Username"/>
		<s:password name="password" label="Password"/>
		<s:submit/>
	</s:form>

</body>
</html>