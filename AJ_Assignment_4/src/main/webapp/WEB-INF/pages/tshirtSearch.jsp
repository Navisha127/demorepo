<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tshirt Search</title>
<style>
fieldset{
	border-radius:4px ;
}
div{
	width: 350px;
    margin:auto;
    position:fixed ;
	top: 30%;
	left:calc(50% - 175px) ;
	
}
form input{
	float:right ;
	margin-right:20px ;
	border:0.5px solid black ;
}
p{
	/* margin:10px 20px 0px 0px; */
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
<a href="logout"><button >sign out</button> </a>
<p>${loginedUser.userName} is currently logged in .</p>
<div >
<fieldset>
<legend>Tshirt Search Form</legend>
<form method="post" action="tshirtSearch" >
<label>Colour <input name="colour" required></label><form:errors path="tshirtdetails.colour"/>
<br><br>
<label>Size <input name="size" required></label><form:errors path="tshirtdetails.size"/>
<br><br>
<label>gender <input name="gender" required></label><form:errors path="tshirtdetails.gender"/>
<br><br>

Output Preference <form:errors path="tshirtdetails.outputPreference"/><br><br>
	<label><input name="outputPreference" type="radio" value="PRICE" required style="margin:0px ; float:none ;">  By Price  </label>
	<label><input name="outputPreference" type="radio" value="RATING" required style="margin:0px ; float:none ;">  By Rating  </label>
<br><br>
<input type="submit" value= "Search"><br>
</form>
<p >${tshirtSearchValidationMsg}</p>
</fieldset>
</div>
</body>
</html>