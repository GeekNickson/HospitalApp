<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title> Выбранный доктор </title>
</head>
<body>
<div class="preloader">
    <div class="preloader__row">
        <div class="preloader__item"></div>
        <div class="preloader__item"></div>
    </div>
</div>

<div class="view"
     style="background-image: url('/img/hospital.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
    <div class="mask rgba-black-light align-items-center">
        <div class="container-fluid align-items-center">
            <div class="row h-100 d-flex align-items-center justify-content-center">
                <div class="card grow"
                     style="width: 22rem; border-color:black; border-radius: 10px; border-width: 3px;">

                    <img src="${pageContext.request.contextPath}/img/person.jpg" class="card-img-top">

                    <ul class="list-group list-group-flush">
                        <li class="list-group-item card-text">ФИО: ${doctor.getDoctorName()}</li>
                        <li class="list-group-item card-text">
                            Специальность: ${doctor.getSpecialty().getSpecialtyName()}</li>
                        <li class="list-group-item card-text">Категория: ${doctor.getCategory()}</li>
                        <li class="list-group-item card-text">Расписание: ${doctor.getDoctorSchedule()}</li>
                    </ul>

                    <div class="card-body text-center">
                        <a class="btn btn-pink btn-lg grow btn-text" style="border-radius: 8px;"> Записаться на прием
                            &nbsp; <i class="fas fa-user-plus"></i> </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/preloader.js"></script>

</body>
</html>