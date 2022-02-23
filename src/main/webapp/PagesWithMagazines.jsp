<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/footer.css">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/login.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Insert title here</title>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <!-- #header -->


        <main class="main">
            <div class="block_header">
                <h1 style="font-size: 50px; margin: 0 auto; width:100% ;">Welcome ${nameUser}</h1>
                <br>
                <h1 style="font-size: 50px; margin: 0 auto; width:100% ;">You can choose any magazine from our site...</h1>
            </div>
            <form action="forwardLogin" method="get">
                <button style="width: 300px;" type="submit" class="btn crossClass btn-primary btn-block fa-lg gradient-custom-2 mb-3 my-gradient my-gradient2 block-center">Login</button>
            </form>
        </main>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>

    </html>