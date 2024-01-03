<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
fieldset{
	border-radius:4px ;
}
div{
	width: 300px;
    position:fixed ;
	top: 30%;
	left:calc(50% - 150px) ;
}
form input{
	float:right ;
	margin-right:20px ;
	border:0.5px solid black ;
}
p{
	margin:10px 20px 0px 0px;
	font-size: small;
	float:right ;
	color:red ;
}
span{
	font-size: small;
	color:red ;
}
</style>
</head>
<body>

<div id="login">
<fieldset>
<legend >Enter Login Details</legend>
<form action="login" method ="post">
<label>Username : <input name="userName" required></label><form:errors path="loginDetails.userName"/>
<br><br>
<label>Password : <input name="password" type="password" required></label><form:errors path="loginDetails.password"/>
<br><br>
<a href="register">Register User </a>
<input type="submit" value= "Login" id ="loginSubmitBtn">
</form>
<p >${InvalidationMsg}</p>
</fieldset>
</div>

</body>
</html>