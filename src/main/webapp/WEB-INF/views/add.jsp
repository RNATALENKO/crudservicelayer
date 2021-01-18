<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<!-- performing data binding to a dto inside a model attribute -->
		<!--  action sends it to /studentData -->
		<!-- use POST because you're posting something to the database/server -->
		<!--remember, GET shows everything in the URL  -->
		<form:form action="studentData" modelAttribute="studentDto" method="POST">
		
			<div>
				<label>Student Name: </label>
				<form:input path="name"/>
			</div>
			
			<div>
				<label>Student's school: </label>
				<form:input path="school"/>
			</div>
				
				<form:button type="submit">Add Student</form:button>
	
		</form:form>
		<a href="http://localhost:8080/SpringJDBCmaincrud/">Home</a>
			

</body>
</html>