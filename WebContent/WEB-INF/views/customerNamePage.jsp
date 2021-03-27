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
<h2>Add Customer</h2>
	
<spring:form method="post" action="./addCustomer" modelAttribute="customer">
Enter Customer Name: <spring:input path="customerName" />
<br>
Phone Number: <spring:input path="phoneNumber" />
		<br>
		<br>
		<input type="submit" value="Add Customer">
	</spring:form>
	
	<br>
	<br>
	<a href="./">Go Back</a>
	</div>
</body>
</html>