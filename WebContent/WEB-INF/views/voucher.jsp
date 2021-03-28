<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form method="post" action="./addVoucher" modelAttribute="voucher">
Enter Voucher Code: <spring:input path="voucherName" />
		<br>
		<br>
		<input type="submit" value="Add Voucher">
	</spring:form>
            
</body>
</html>