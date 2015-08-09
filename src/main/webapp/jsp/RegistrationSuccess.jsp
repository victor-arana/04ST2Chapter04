<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Registration Success</title>
	</head>
	<body>
		<h5>Congratulations! You have created</h5>
		<h3>The <s:property value="portfolioName"/>Portfolio</h3>
		<p>You may now begin working with 
		<a href="<s:url action='secure/AdminPortfolio'/>">your portfolio.</a>
		</p>
	</body>
</html>