<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Welcome</title>
<meta>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<h1>CRM : Customer Relationship Manager</h1>
</div>
<input type="button" value="AddCustomer" onclick="window.location.href = 'showFormForAdd';" class="add-button"/>
</div>
<div id="container">
<div id="content">
<table>
<tr> 
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="tmpCustomer" items="${customers}">
<c:url var="updateLink" value="showFormForUpdate">
<c:param name="customerId" value="${tmpCustomer.id}"/></c:url>
<c:url var="deleteLink" value="delete">
<c:param name="customerId" value="${tmpCustomer.id}"/></c:url>
<tr>
<td> ${tmpCustomer.firstName}</td>
<td> ${tmpCustomer.lastName}</td>
<td> ${tmpCustomer.email}</td>
<td> <a href="${updateLink}">update</a>
<a href="${deleteLink}"
onclick="if(!(confirm('Are You Sure? You Want To Delete The Record?'))) return false;">delete</a>
</td>
</tr>

</c:forEach>

</table>
</div>
</div>
</body>

</html>