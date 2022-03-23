<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Insert title here</title>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <div class='col-sm-4'>
            <div class='card'>
                <div class='image'>
                </div>
                <div class='card-inner'>
                    <div class='header'>
                        <h2>${product.name}</h2>
                        <h2>${product.information}</h2>
                    </div>
                    <div class='content'>
                        <p> ${product.price}</p>
                    </div>

                </div>
            </div>
        </div>
        <button onclick="" type="button" product-id="${product.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  Launch demo modal
</button>



        <!-- Modal -->
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
                        <button type="button" product-id="${product.id}" id="buy">Buy Magazine</button>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="registrationAllElementAndLinkToTheOtherPages.js"></script>
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