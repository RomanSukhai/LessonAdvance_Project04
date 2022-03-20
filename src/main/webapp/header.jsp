<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/login.css">
        <link rel="stylesheet" href="style/cabinet.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Insert title here</title>
    </head>

    <body>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand font-weight-bold" href="#">Magazine Shop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a type="submit" id="loginPage" class="nav-link">LogOut</a>
                        </li>
                        <li class="nav-item">
                            <a type="submit" id="add" class="nav-link ">Add Magazine</a>
                        </li>
                        <li class="nav-item">
                            <a href='${pageContext.request.contextPath}/PagesWithMagazines.jsp' type="submit" id="bucket" class="nav-link ">Bucket</a>
                        </li>
                        <!-- <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li> -->
                    </ul>
                </div>
            </div>
        </nav>

        <header>

            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active" style="background-image: url('img/завантаження.jpeg')">
                        <div class="carousel-caption">
                            <h5>First slide label</h5>
                            <p>Some representative placeholder content for the first slide.</p>
                        </div>
                    </div>
                    <div class="carousel-item" style="background-image: url('img/завантаження2.jpg')">
                        <div class="carousel-caption">
                            <h5>Second slide label</h5>
                            <p>Some representative placeholder content for the second slide.</p>
                        </div>
                    </div>
                    <div class="carousel-item" style="background-image: url('img/Завантаження3.jpg')">
                        <div class="carousel-caption">
                            <h5>Third slide label</h5>
                            <p>Some representative placeholder content for the third slide.</p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
        </header>

        <!-- Page Content -->
        <section class="py-5">
            <div class="container">
                <h1 class="fw-light">This is front page for site of magazines</h1>
                <p class="lead">The background images for the slider are set directly in the HTML using inline CSS. The images in this snippet are from <a href="https://unsplash.com">Unsplash</a>!</p>
            </div>
        </section>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="JavaScript/headerCode.js"></script>
        <script src="cabinetMove.js"></script>
        <script src="registrationAllElementAndLinkToTheOtherPages.js"></script>
        <script src="bucket.js"></script>

    </body>

    </html>