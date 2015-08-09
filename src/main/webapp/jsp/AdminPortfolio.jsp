<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Administrate Portfolio</title>
	</head>
	<body>
		<ul>
			<li><a href="<s:url action='AddImage'/>">Add image to portfolio.</a></li>
			<li><a href="<s:url action='RemoveImage'/>">Remove an image from portfolio.</a> </li>
		</ul>
	</body>
</html>