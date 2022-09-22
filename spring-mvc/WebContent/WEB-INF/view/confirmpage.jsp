<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>confirmation page</title>
</head>
<body>
<h2>Student Details</h2>
	<b>Name: </b>${studentModel.firstName} ${studentModel.lastName}<br><br>
	<b>Country: </b>${studentModel.country}<br><br> 
	<b>Course: </b>${studentModel.course}<br><br>
	<b>No Of Experience: </b>${studentModel.yearsOfExp} <br><br>
	<b>Gender: </b>${studentModel.gender}<br><br>
	<b>Skills:</b>
	<ul>
		<c:forEach var="temp" items="${studentModel.skills}">
			<li>${temp}</li>
		</c:forEach>
	</ul><br>
	<b>Free passes:</b>${studentModel.freePasses}<br><br>
	<b>Email:</b>${studentModel.email}<br><br>
	<b>CourseCode:</b>${studentModel.courseCode}<br><br>
</body>
</html>