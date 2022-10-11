<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Confirmation</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css">
</head>
<body>
<table>
<tr><th><img src="${pageContext.request.contextPath}/resources/cake.jpg"
		height=250 width="500"><br><br>
		<b style="color:green">Your Order Confirmed...</b></th></tr>
</table>
	<table>
		<tr>
			<td><h3 style="color:blue">Thanks for your order.</h3></td>
		</tr>
		<tr>
			<th><b>Your Details..</b></th>
		</tr>
		<tr>
			<td><b>Name:</b></td>
			<td>${customerOrderModel.firstName}
				${customerOrderModel.lastName}</td>
		</tr>
		<tr>
			<td><b>Date Of Birth :</b></td>
			<td>${customerOrderModel.dob}</td>
		</tr>
		<tr>
			<td><b>Email:</b></td>
			<td>${customerOrderModel.email}</td>
		</tr>
		<tr>
			<td><b>Delivery Address:</b></td>
			<td>${customerOrderModel.address}</td>
		</tr>
		<tr>
			<td><b>Mobile number :</b></td>
			<td>${customerOrderModel.mobileNo}</td>
		</tr>
		<tr>
			<td><b>Cake Flavor:</b></td>
			<td>${customerOrderModel.cakeFlavor}</td>
		</tr>
		<tr>
			<td><b>Cake Model:</b></td>
			<td><img width="200" height="200" src="getCakeModel"></td>
		</tr>
		<tr>
			<td><b>How Many Kg Needed:</b></td>
			<td>${customerOrderModel.kg}</td>
		</tr>
		<tr>
			<td><b>Amount:</b></td>
			<td>${customerOrderModel.amount}</td>
		</tr>
		<tr>
			<td><b>Payment Mode:</b></td>
			<td>${customerOrderModel.modeOfPayment}</td>
		</tr>
	</table>

</body>
</html>