<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/bucket.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="bucket.js"></script>
        <title>Insert title here</title>
    </head>

    <body>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
        <table id="myTable">

        </table>
        
    </body>
		<script>
            $('html').animate({
                    scrollTop: $('.h-100.gradient-form').offset().top
                },
                500);
        </script>
    </html>