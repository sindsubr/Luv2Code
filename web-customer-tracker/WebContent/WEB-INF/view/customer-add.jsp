<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<title>Add Customer</title>
</head>
<body>
	<form:form modelAttribute="customer" action="saveCustomer">
		<table>
			<tr>
				<th><h1>Register Customer:</h1></th>
			</tr>
			<!-- associate this date to customer id -->
			<form:hidden path="id" />
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstName" />
					<form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input path="lastName" />
				<form:errors cssClass="error" path="lastName"/>
				</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" />
				<form:errors path="email" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" class="save" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>