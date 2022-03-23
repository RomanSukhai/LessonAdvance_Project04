<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/footer.css">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/login.css">
        <link rel="stylesheet" href="style/cabinet.css">
        
        <title>Insert title here</title>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="tableBucket.jsp"></jsp:include>
        <!-- #header -->
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">

        <table id="myTable">

        </table>

        <div id='cabinet-magazine'></div>

        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
            Launch demo modal
          </button>

        
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="JavaScript/cabinetMove.js"></script>
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