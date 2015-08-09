<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>Image Upload Form</title>
	</head>
	<body>
	<h4>Complete and submit the form to create your own portfolio</h4>
	<s:form action="ImageUpload" method="post" enctype="multipart/form-data">
		<s:file name="pic" label="Picture"/>
		<s:submit/>	
	</s:form>
	</body>
</html>