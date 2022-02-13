<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="get">
		<h2 class="header_title">Form login</h2>
		<div class="input-container">
		  <i class="fa fa-user icon"></i>
		  <input class="input-field" type="text" placeholder="Email" name="emailUser">
		</div>
	  
		<div class="input-container">
		  <i class="fa fa-key icon"></i>
		  <input class="input-field" type="text" placeholder="Password" name="passwordUser">
		</div>
	  
		<button type="submit" class="btn">Login</button>
	  </form>
</body>
</html>