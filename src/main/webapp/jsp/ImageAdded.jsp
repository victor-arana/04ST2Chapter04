<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Image Added</title>
	</head>
	<body>
		<h4>
			You have successfully added <s:property value="picFileName"/>. Return to
			<a href="<s:url action='AdminPortfolio'/>">your portfolio.</a>
		</h4>
	</body>
</html>