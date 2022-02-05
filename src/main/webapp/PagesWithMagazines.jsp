<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<header class="header">
    <p class="header_title">Shop Magazine</p>
</header>
<main class="main">
	<div class="block_header" >
		<h1 style="font-size: 50px; margin: 0 auto; width:100% ;">Welcome ${nameUser}</h1>
        <br>
	    <h1 style="font-size: 50px; margin: 0 auto; width:100% ;">You can choose any magazine from our site...</h1>
	</div>
    <form action="forwardLogin" method="get">
    		<button style="width: 100%" type="submit" class="btn">Login</button>
    </form>
</main>
</body>
</html>