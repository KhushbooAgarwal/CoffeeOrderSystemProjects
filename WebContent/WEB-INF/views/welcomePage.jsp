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
<h3>Welcome To Khushboo's Coffee Cafe</h3>
<br>
<br>
<h5>Hello</h5>
Customer Name: ${customer }
<br>
Customer Phone Number :${phoneNumber }
<h6>How are you <h6>
<h5> What would you like to have today!</h5>

<br>
	<br>
	<a href="./coffeeSelect" >Select Coffee</a>
	<br>
	<a href="./">Go Back</a>
</body>
</html>