<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
	<h2>Add On Menu</h2>

	
		<table border="1" cellpadding="3">
		<tr>
		<th>Add On Name</th>
		<th>Add On Price</th>
						
		</tr>
		<c:forEach items="${addOnList }" var="addOn">
			<tr>
				<td>${addOn.addOnName }</td>
				<td>${addOn.addOnPrice }</td>
				
			</tr>
		</c:forEach>
	</table>
	<br><br>

	<spring:form method="post"   modelAttribute="addOn">
	Select Add On : <spring:select path="addOnName">
		<spring:options items="${addOnName }"/>
	</spring:select>
		<br>
		<br>


 	<a href="./addAddOn">Add AddOn</a>
		<a href="./orderCreation">Place Order</a>
		<a href="./coffeeSelect">Add More Coffee</a>
		
	</spring:form>
</div>
	<br>
	<br>
	<a href="./">Go Back</a>
</body>
</html>