<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matching Tshirts</title>
<style>
table{
	margin-left: auto;
	margin-right: auto;
	width: 70%
}
caption {
	font-size: 20px;
	margin-top: 40px;
	margin-bottom:20px;
	font-transform: bold;
}
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

p {
	/* margin:10px 20px 0px 0px; */
	font-size: small;
	float: right;
	color: red;
}
footer{
	margin-top: 3%;
}
</style>
</head>
<body>
	<header>
		<a href="logout" style="float: left"><button>sign out</button> </a>
		<p>${loginedUser.userName} is currently logged in</p>
	</header>
	<main>
		<table class="show_table">
			<caption>Matching Tshirt List</caption>
			<tr>
				<th>S.no.</th>
				<th>name</th>
				<th>colour</th>
				<th>gender</th>
				<th>size</th>
				<th>price</th>
				<th>rating</th>
				<th>availability</th>
			</tr>
			<c:forEach var="listValue" items="${list}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${listValue.name}</td>
					<td>${listValue.colour}</td>
					<td>${listValue.gender_recommendation}</td>
					<td>${listValue.size}</td>
					<td>${listValue.price}</td>
					<td>${listValue.rating }</td>
					<td>${listValue.availability}</td>
				</tr>
			</c:forEach>
		</table>
		</main>
		
		<footer>
			<a href="tshirtSearch">Search for anothor tshirt</a>
		</footer>
</body>
</html>