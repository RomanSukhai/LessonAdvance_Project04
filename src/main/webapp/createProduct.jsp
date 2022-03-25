<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="style/header.css">
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <section class="h-100 gradient-form" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="card-body p-md-5 mx-md-4">

                                        <div class="text-center">
                                            <img src="img/uploads_magazine_magazine_PNG44.png" style="width: 185px;" alt="logo">
                                            <h4 class="mt-1 mb-5 pb-1">We are The Lotus Team</h4>
                                        </div>

                                        <form>
                                            <p>Please Create new Magazine</p>



                                            <div class="form-outline mb-4">
                                                <input type="text" id="name" class="form-control" placeholder="magazine name" />
                                                <label class="form-label" for="form2Example11">Name</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="number" id="pages" class="form-control" placeholder="magazine pages" />
                                                <label class="form-label" for="form2Example22">Pages</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text" id="information" class="form-control" placeholder="magazine information" />
                                                <label class="form-label" for="form2Example22">Information</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="number" step="0.01" max="1000" min="0" id="price" class="form-control" placeholder="magazine price" />
                                                <label class="form-label" for="form2Example22">Price</label>
                                            </div>

                                            <div class="text-center pt-1 mb-5 pb-1">
                                                <button style="width: 300px;" id="magazine" class="btn crossClass btn-primary btn-block fa-lg gradient-custom-2 mb-3 my-gradient my-gradient2" type="button">Log in</button>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-center gradient-custom-2 my-gradient">
                                    <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                        <h4 style="
                                        color: gray;
                                    " class="mb-4">We are more than just a company</h4>
                                        <p style="
                                        color: gray;
                                    " class="small mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
                                            ea commodo consequat.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="alert alert-success w-25 disp-none" style="margin: auto;" role="alert">
            <b>Success!</b> You are registred
        </div>

        <div class="alert alert-danger w-25 disp-none" style="margin: auto;" role="alert">
            <b>Form is empty!</b> Please print your data
        </div>

        <div class="alert alert-warning w-25 disp-none" style="margin: auto;" role="alert">
            Password must be bigger of the 8 sumbols
        </div>

        <div class="alert alert-warning w-25 disp-none" id="confirm" style="margin: auto;" role="alert">
            <b>Password Confirm isn't correct!</b> Please print correct value
        </div>



        <jsp:include page="footer.jsp"></jsp:include>
        
    </body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="JavaScript/allForCreatedBucketAndthisPages.js"></script>
        <script src="registrationAllElementAndLinkToTheOtherPages.js"></script>
        <script src="bucket.js"></script>
    </html>