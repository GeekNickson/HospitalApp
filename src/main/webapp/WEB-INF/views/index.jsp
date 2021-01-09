<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <title> Главная </title>
</head>
<body>
<%
    String pageName = "/specialty/specialties";
    String pageName2 = "/doctor/all_doctors";
%>
<div class="preloader">
    <div class="preloader__row">
        <div class="preloader__item"></div>
        <div class="preloader__item"></div>
    </div>
</div>

<div id="carouselMain" class="carousel slide carousel-fade" data-ride="carousel" data-interval="7000">
    <ol class="carousel-indicators">
        <li data-target="#carouselMain" data-slide-to="0" class="active"></li>
        <li data-target="#carouselMain" data-slide-to="1"></li>
        <li data-target="#carouselMain" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner" role="listbox">
        <div class="carousel-item active"
             style="background-image: url('/img/hospital.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        </div>
        <div class="carousel-item"
             style="background-image: url('/img/scope.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        </div>
        <div class="carousel-item"
             style="background-image: url('/img/doctors.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        </div>
    </div>

    <a class="carousel-control-prev" href="#carouselMain" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselMain" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="mask rgba-black-light align-items-center">
    <div class="container-fluid align-items-center">
        <div class="row h-100 align-items-center">
            <div class="col-md-12 mb-4 white-text text-center align-items-center my-auto">
                <h1 class="h1-responsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown grow"
                    data-wow-delay="0.3s" style="width: 50%; margin-left:25%; text-align:center;"><i
                        class="fas fa-clinic-medical"></i><strong>Hospital App</strong></h1>
                <hr class="hr-light my-4 wow fadeInDown" data-wow-delay="0.4s" style="width: 15%;">
                <a class="btn btn-pink btn-lg wow fadeInDown grow btn-text main-text" data-wow-delay="0.4s"
                   style="border-radius: 8px;" onclick="redirectPage('<%=pageName%>')"> Специальности </a>
                <a class="btn btn-pink btn-lg wow fadeInDown grow btn-text main-text" data-wow-delay="0.4s"
                   style="border-radius: 8px;" onclick="redirectPage('<%=pageName2%>')"> Специалисты </a>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/redirect.js"></script>

<script src="${pageContext.request.contextPath}/js/preloader.js"></script>

</body>
</html>

