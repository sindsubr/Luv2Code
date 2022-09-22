<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>
<style type="text/css">
.errorcss {
	color: red;
}
</style>
</head>
<body>
	<h2>
		<b>Registration Form:</b>
	</h2>
	<br>
	<br>
	<form:form action="submitForm" modelAttribute="studentModel">
First Name (*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="errorcss" />
		<br>
		<br>
Last Name (*) : <form:input path="lastName" />
		<form:errors path="lastName" cssClass="errorcss" />
		<br>
		<br>
		<!-- drop down list : static setup -->
Country :
<form:select path="country">
			<form:option value="India" label="India"></form:option>
			<form:option value="UAE" label="UAE"></form:option>
			<form:option value="USA" label="USA"></form:option>
			<form:option value="Germany" label=""></form:option>
		</form:select>
		<br>
		<br>
		<!-- drop down list : student class setup		 -->
Course:
<form:select path="course">
			<form:options items="${studentModel.courseList}" />
		</form:select>
		<br>
		<br>
		
YearsOfExp:
<form:select path="yearsOfExp">
			<form:options items="${yearsOfExpMap}" />
		</form:select>
		<br>
		<br>
		
Gender:(*)
<form:radiobuttons path="gender" items="${studentModel.genderMap}" />
		<form:errors path="gender" cssClass="errorcss" />
		<br>
		<br>
		<%-- <form:radiobutton path="gender" value="male" label="Male" /> --%>
		<%-- <form:radiobutton path="gender" value="female" label="Female" /> --%>


Skills:
<form:checkbox path="skills" value="JAVA" label="JAVA" />
		<form:checkbox path="skills" value="DBMS" label="DBMS" />
		<form:checkbox path="skills" value="JS" label="JS" />
		<form:checkbox path="skills" value="Spring" label="Spring" />
		<form:checkbox path="skills" value="Hibernate" label="Hibernate" />
		<br>
		<br>
		
FreePasses:
<form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="errorcss" />
		<br>
		<br>

Email:
<form:input path="email" />
		<form:errors path="email" cssClass="errorcss" />
		<br>
		<br>
Course Code (If any):
<form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="errorcss" />
		<br>
		<br>
Birthday:
<form:input type="date" path="birthday" />
		<form:errors path="birthday" cssClass="errorcss" />
		<br>
		<br>
		<input type="submit" />
	</form:form>

</body>

</html>