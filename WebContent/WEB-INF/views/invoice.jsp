<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>************************************Final Invoice of Your Order******************************************</h4>
<br>
Customer Name :
<br>
Invoice Date : 
<br><br>
<table border="1" cellpadding="3">
		<tr>
		<th>Coffee Name</th>
			<th>Coffee Size</th>
			<th>Add On</th>
			
		</tr>
		<c:forEach items="${invoiceList }" var="invoice">
			<tr>
				<td>${coffee.coffeeName }</td>
				<td>${coffee.coffeeSize }</td>
				<td>${coffee.AddOn }</td>
				
			</tr>
		</c:forEach>
	</table>
	<br><br>
Total Value : 
<br>
Discount : 
<br>
Net Value : 
<br>
GST : 
<br>
Service Tax :	
<br>
Total Bill : 	
</body>
</html>