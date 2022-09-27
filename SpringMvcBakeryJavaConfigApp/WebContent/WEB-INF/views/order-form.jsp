<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/form.css">
<meta charset="ISO-8859-1">
<title>Bakery Order Form</title>
</head>
<body>
	<h1>Order Cake:</h1>
	<form:form action="order" modelAttribute="customerModel"
		enctype="multipart/form-data" method="post">
First Name: <form:input path="firstName" /><form:errors path="firstName" cssClass="error"/> Last Name: <form:input
			path="lastName" /><form:errors path="lastName" cssClass="error"/>
		<br>
		<br>
Date Of Birth : <form:input type="date" path="dob" />
<form:errors cssClass="error" path="dob"/>
		<br>
		<br>
Email: <form:input path="email" /><form:errors cssClass="error" path="email"/>
		<br>
		<br>
Delivery Address:<form:input type="textArea" path="deliveryAddress" />
		<br>
		<br>
State:<form:input path="state" />
		<br>
		<br>
Pincode:<form:input path="pincode" />
		<br>
		<br>
Country:<form:select id="country" path="country">
			<form:options items="${customerModel.countryMap}" />
		</form:select>
		<br>
		<br>
Mobile number :
<form:select path="countryCode">
			<form:options items="${countryCodeMap}" />
		</form:select>
		<form:input path="mobileNo" />
		<form:errors path="mobileNo" cssClass="error"/>
		<br>
		<br>
Cake Flavour:
<form:select path="cakeFlavour">
<form:options path="cakeFlavour" items="${flavourMap}"/></form:select>
		<br>
		<br>
Cake Theme:<form:input type="file" path="cakeTheme" />
<form:errors cssClass="error" path="cakeTheme"/>
		<br>
		<br>
How Many Kg Needed: <form:input path="kg" /><form:errors cssClass="error" path="kg"/>
		<br>
		<br>
Payment: <form:radiobuttons path="payment" items="${modeOfPayment}"/>
<form:errors path="payment" cssClass="error"/>
		<br>
		<br>
		<input type="submit" value="Place Order" />
	</form:form>
</body>
</html>