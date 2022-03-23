<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/bucket.css">
        
        <title>Insert title here</title>
    </head>

    <body>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
        <table id="myTable">

        </table>
        
    </body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
        $(document).ready(function() {
            var magazine = null;
            $.get('bucket', function(data) {
                if (data != '') {
                    magazine = data;
                }
                debugger;
            }).done(function() {
                var cardsContect = "<tr class='header'>" +
                    "<th style='width:20%;'>Name</th>" +
                    "<th style='width:20%;'>Description</th>" +
                    "<th style='width:20%;'>Price</th>" +
                    "<th style='width:20%;'>Create Date</th>" +
                    "<th style='width:20%;'>Option</th>" +
                    "</tr>";
                jQuery.each(magazine, function(i, value) {
                    cardsContect += "<tr>" +
                        "<td>" + value.name + "</td>" +
                        "<td>" + value.information + "</td>" +
                        "<td>" + value.price + "</td>" +
                        "<td>" + value.purchase_date + "</td>" +
                        "<td><button id='my_bucket'  bucket_id='"+ value.bucket_id +"'>delete</button></td>";
                })
                $('#myTable').html(cardsContect);

            })
        function droper() {
        	var bucket_id = $('button#my_bucket').attr('bucket_id');
            var customURL = '';
            var urlContent = window.location.href.split('/');
         debugger;
            for (var i = 0; i < urlContent.lenght - 1; i++) {
                customURL += urlContent[i] + '/'
            }
            customURL += 'bucket?bucketId=' + bucket_id;

            $.ajax({
                url: customURL,
                type: 'DELETE',
                success: function(data) {
                    if (data == 'Success') {
                        location.reload();
                    }
                }
            })
        }
        $('button#my_bucket').click(droper);


        })</script>
    </html>