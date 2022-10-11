<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css">
<title>Order Form</title>
</head>
<body onreset="updateAmount">
	<table>
		<tr>
			<th><h1>Order Your Cake..</h1></th>
		</tr>
		<form:form modelAttribute="customerOrderModel" action="placeOrder"
			enctype="multipart/form-data" method="POST" >
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /> <form:errors
						path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" />
					<form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mobile :</td>
				<td><form:input path="mobileNo" />
					<form:errors path="mobileNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date Of Birth :</td>
				<td><input type="date" name="dateString"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:textarea path="address" />
					<form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" />
					<form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Cake Flavor :</td>
				<td><form:select path="cakeFlavor" items="${cakeFlavors}" />
					<form:errors path="cakeFlavor" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Cake Model :</td>
				<td>
				<input id="file" type="file" name="file" />
				<div class="error">${errorString}</div>
				<form:errors path="cakeModel" cssClass="error" />
				</td> 
			</tr>
			<tr>
				<td>Kg :</td>
				<td><form:input id="kg" path="kg" value="1" onblur="updateAmount()"/>
<%-- 				onblur="window.location.href='processAmount';return false;" --%>
					<form:errors path="kg" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><form:input id="amount" path="amount" readonly="true" cssStyle="font-family:monospace;color:green"/></td>
			</tr>
			<tr>
				<td>Mode Of Payment :</td>
				<td>Cash<form:radiobutton path="modeOfPayment" value="cash"
						item="cash" /> <form:errors path="modeOfPayment" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="PlaceOrder" /></td>
			</tr>
		</form:form>
	</table>
	
	  <script type="text/javascript"> 
          
        function updateAmount(){ 
            var kg = document.getElementById("kg").value; 
            var amount = kg * 100;
            document.getElementById("amount").value = amount; 
              
        } 
    </script> 
</body>
</html>