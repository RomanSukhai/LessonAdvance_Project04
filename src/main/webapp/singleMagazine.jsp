<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="style/bucket.css">
        <title>Insert title here</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="registrationAllElementAndLinkToTheOtherPages.js"></script>
        
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
<button onclick="" type="button" product-id="${product.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  Buy
</button>
                </div>
            </div>
        </div>
        



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
                        Are you ready buy magazine?
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

<script>
            $('html').animate({
                    scrollTop: $('.h-100.gradient-form').offset().top
                },
                500);
        </script>
        <script src="bucket.js"></script>
    </html>