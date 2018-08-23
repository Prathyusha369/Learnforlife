<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>


</head>
<body>
	<h1>Register</h1>
	<form:form action="${pageContext.request.contextPath}/registration"
		modelAttribute="register">
		<hr>
		<h3>USERNAME</h3>

		<form:input path="userName" />
		<hr>
		<h3>PWD</h3>

		<form:input path="password" />
		<hr>
		<h3>EMAIL</h3>

		<form:input path="email" />
		<hr>
		<h1>ROLE</h1>
		<form:radiobutton path="role" value="Student" />Student 
<form:radiobutton path="role" value="tutor" />Tutor 
<hr>
		<h1>GENDER</h1>
		<form:radiobutton path="gender" value="Male" />Male 
<form:radiobutton path="gender" value="Female" />Female 
<hr>

		<input type="submit" value="register"></input>


	</form:form>
</body>
</html>