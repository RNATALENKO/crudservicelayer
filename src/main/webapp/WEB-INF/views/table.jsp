<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ page isELIgnored="false" %>
</head>
<body>

		<h1>my home</h1>
		<p>${studentList}<p>
		<br>
		
		
	<a href="http://localhost:8080/SpringJDBCmaincrud/add" style="font-size: 18px;text-decoration:none; width:7%; text-align:center; padding:20px; background-color:lightblue; color: white; display:block;">Add Student</a>
	<table align="center">
	
		<tr>
			<th>id</th>
			<th>name</th>
			<th>school</th>
		</tr>
		
		<form:form>
		<c:forEach var="student" items="${studentList}">
		<tr>
			<td style="padding:30px; border:1px solid black; min-width:125px;">${student.id}</td>
			<td style="padding:30px; border:1px solid black;min-width:125px;">${student.name}</td>
			<td style="padding:30px; border:1px solid black;min-width:125px;">${student.school}</td>
			<td style="padding:30px;"><a href="http://localhost:8080/SpringJDBCmaincrud/updateStudent?userId=${student.id}" >update</a><td>
			<td style="padding:30px;"><a onclick="if (!confirm('Delete listing?')){return false} else {return true}" href="http://localhost:8080/SpringJDBCmaincrud/deleteStudent?userId=${student.id}">delete</a></td> <!-- the onlick opens a dialogue box, but notice it still cancels, we must cancel the operation by returning false-->
			
		</tr>	
		</c:forEach>
		
		</form:form>
	</table>	
		

</body>
</html>