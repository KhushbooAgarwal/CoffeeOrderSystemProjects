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
 <h2>Coffee Menu</h2>

	
		<table border="1" cellpadding="3">
		<tr>
		<th>Coffee Name</th>
			<th>Coffee Size</th>
			<th>Price</th>
			
		</tr>
		<c:forEach items="${coffeeList }" var="coffee">
			<tr>
				<td>${coffee.coffeeName }</td>
				<td>${coffee.coffeeSize }</td>
				<td>${coffee.coffeePrice }</td>
				
			</tr>
		</c:forEach>
	</table>
	<br><br>
	
	
	<spring:form method="post" action="./coffeeSelect"  modelAttribute="coffee">
	Select Coffee Name : <spring:select path="coffeeName">
		<spring:options items="${coffeeName }"/>
	</spring:select>
		<br>
		<br>
 Select Coffee Size : <spring:select path="coffeeSize">
		<spring:options items="${coffeeSize }"/>
	</spring:select>
		<br>
		<br>
 	<input type="submit" name="orderNextCoffee" value="Add More Coffee">
		<input type="submit" name="orderCreation" value="Place Order">
		<a href="./addAddOn"><input type="submit" name="addAddOn" value="Add AddOn"></a>
		<!-- <a href="./addAddOn"></a> -->
		
	</spring:form>
</div>
	<br>
	<br>
	<a href="./">Go Back</a>
</body>
</html>