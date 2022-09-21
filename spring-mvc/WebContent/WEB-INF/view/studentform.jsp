<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>
</head>
<body>
	<form:form action="submitForm" modelAttribute="studentModel">
First Name : <form:input path="firstName" />
Last Name  : <form:input path="lastName" />

		<!-- drop down list : static setup -->
Country :
<form:select path="country" itemValue="countryItems" itemLabel="Country">
			<form:option value="India" label="India"></form:option>
			<form:option value="UAE" label="UAE"></form:option>
			<form:option value="USA" label="USA"></form:option>
			<form:option value="Germany" label=""></form:option>
		</form:select>
		<!-- drop down list : student class setup		 -->
Course:
<form:select path="course">
			<form:options items="${studentModel.courseList}" />
		</form:select>
		
Coding Languages:
<form:select path="yearsOfExp">
			<form:options items="${yearsOfExpMap}" />
		</form:select>
		
Gender:
<form:radiobutton path="gender" value="male" label="Male" />
		<form:radiobutton path="gender" value="female" label="Female" />


Skills:
<form:checkbox path="skills" value="JAVA" label="JAVA" />
		<form:checkbox path="skills" value="DBMS" label="DBMS" />
		<form:checkbox path="skills" value="JS" label="JS" />
		<form:checkbox path="skills" value="Spring" label="Spring" />
		<form:checkbox path="skills" value="Hibernate" label="Hibernate"/>
		<input type="submit" />
	</form:form>

</body>

</html>