<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>Header Pages</title>
</head>
<body>
	<!-- <form action="exit" method="post">
	<label for="emailUser">Email : </label><input name="emailUser">
	<br>
	<label for="nameUser">Name : </label><input name="nameUser">
	<br>
	<label for="passwordUser">Password : </label><input name="passwordUser">
	<br><input type="submit" value="submit"> 
	</form> -->

	<form action="exit" method="post">
		<h2 class="header_title">Form registration</h2>
		<div class="input-container">
		  <i class="fa fa-envelope icon"></i>
		  <input class="input-field" type="text" placeholder="Email" name="emailUser">
		</div>
	  
		<div class="input-container">
		  <i class="fa fa-user icon"></i>
		  <input class="input-field" type="text" placeholder="Name" name="nameUser">
		</div>
		
		<div class="input-container">
		  <i class="fa fa-key icon"></i>
		  <input class="input-field" type="password" placeholder="Password" name="passwordUser">
		</div>
	  
		<button type="submit" class="btn">Register</button>
	  </form>
	  
</body>
</html>