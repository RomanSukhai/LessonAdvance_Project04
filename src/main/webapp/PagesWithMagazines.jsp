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
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="JavaScript/cabinetMove.js"></script>
        <script src="JavaScript/bucket.js"></script>
        <title>Insert title here</title>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <!-- #header -->
        
	
  		
  		<div class="d-flex flex-wrap" id='cabinet-magazine'>
  		
        </div>
        
	
        

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
		<script>
            $('html').animate({
                    scrollTop: $('.h-100.gradient-form').offset().top
                },
                500);
        </script>
    </html>