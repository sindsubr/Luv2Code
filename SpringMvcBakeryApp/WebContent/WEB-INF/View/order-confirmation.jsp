<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/form.css">

<style type="text/css">
body {
	background-color: lightblue;
}

p {
	color: red;
}

h1 {
	color: red;
}
</style>
<title>Confirmation</title>
</head>
<body>
	<h1>Thanks for your order.</h1>
	<br>
	<br>
	<img src="${pageContext.request.contextPath}/resources/cake.jpg"
		height="200" width="200">
	<p>
		<b>Your Order Confirmed.</b>
	</p>
	<br>
	<br>
	<b>Your Details..</b>
	<br>
	<br> Name: ${customerModel.firstName} ${customerModel.lastName}
	<br>
	<br> Date Of Birth : ${customerModel.dob}
	<br>
	<br> Email: ${customerModel.email}
	<br>
	<br> Delivery Address: ${customerModel.deliveryAddress}
	<br>
	<br> State: ${customerModel.state}
	<br>
	<br> Pincode: ${customerModel.pincode}
	<br>
	<br> Country: ${customerModel.country}
	<br>
	<br> Mobile number : ${customerModel.countryCode} ${customerModel.mobileNo}
	<br>
	<br> Cake Flavour: ${customerModel.cakeFlavour}
	<br>
	<br> Cake Theme:
	<img src="${cakeThemePath}"
		height="200" width="200">
	<br>
	<br> How Many Kg Needed: ${customerModel.kg}
	<br>
	<br> Payment: ${customerModel.payment}
	<br>
	<br>

</body>
</html>