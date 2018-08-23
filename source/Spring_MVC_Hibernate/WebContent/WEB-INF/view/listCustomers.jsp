<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<table>
		<tr>
			<th>Company</th>
			<th>Contact</th>
			<th>Country</th>
		</tr>
		<c:forEach var="customer" items="${customers}">

			<tr>
				<td><b>${customer.lastName}</b></td>
				<td><b>${customer.firstName}</b></td>
				<td><b>${customer.email}</b></td>

			</tr>
	

	</c:forEach>
</table>

	<a href="${pageContext.request.contextPath}/add"><button>Add
			Customer</button> </a>


</body>
</html>