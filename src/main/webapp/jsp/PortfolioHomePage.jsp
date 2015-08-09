<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>PortfolioHomePage</title>
	</head>
	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4>
		<ul>
			<li><a href="<s:url action='Registration'/>">Create an Account</a></li>
			<li><a href="<s:url action='ErrorProne'/>">Error Prone Action</a></li>
		</ul>	
	</body>
</html>