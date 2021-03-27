<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>Customer Search</h2>
	<spring:form method="post" action="./searchCustomer" modelAttribute="customer">
Enter Phone Number: <spring:input path="phoneNumber" />
		<br>
		<br>
		<input type="submit" value="Check Customer">
	</spring:form>
	
	<br>
	<br>
	<a href="./">Go Back</a>
	</div>
</body>
</html>