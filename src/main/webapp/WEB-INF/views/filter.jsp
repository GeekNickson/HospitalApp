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
    <!-- MDBootstrap Datatables  -->
    <link href="${pageContext.request.contextPath}/css/datatables.min.css" rel="stylesheet">
    <!-- MDBootstrap Datatables  -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datatables.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <title> Раздел 2 </title>
</head>
<body>
<%
    String pageName = "/specialty/doctor";
%>
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
                <div class="contained-fluid col-md-8 mb-4 align-items-center my-auto contents">
                    <form id="filterForm">
                        <div class="row d-flex" style="margin-left: 1rem;">
                            <div class="form-group">
                                <label for="specialtiesList" class="form-controls-text"> Специальность: </label>
                                <select id="specialtiesList" class="form-controls-text">
                                    <optgroup class="form-controls-text">
                                        <option value="0"> Все</option>
                                        <c:forEach var="specialty" items="${specialties}">
                                            <option value="${specialty.getId()}"> ${specialty.getSpecialtyName()} </option>
                                        </c:forEach>
                                    </optgroup>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="doctorName" class="form-controls-text"> ФИО: </label>
                                <input type="text" id="doctorName" class="form-controls-text">
                            </div>
                            <button class="btn btn-pink grow btn-text" style="border-radius: 8px;" type="submit"
                                    id="updateButton"> Фильтровать
                            </button>
                        </div>
                    </form>
                    <table id="doctorsTable" class="table table-hover table-bordered table-sm my-auto"
                           style="background-color: white;">
                        <thead>
                        <tr>
                            <th class="th-sm table-header-text"> Идентификатор</th>
                            <th class="th-sm table-header-text"> ФИО</th>
                            <th class="th-sm table-header-text"> Специальность</th>
                            <th class="th-sm table-header-text"> Категория</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/redirect.js"></script>

<script src="${pageContext.request.contextPath}/js/preloader.js"></script>

<script>
    $("#filterForm").submit(function (e) {
        e.preventDefault();
    });

    let table;

    $(document).ready(function () {
        table = $('#doctorsTable').DataTable({
            processing: true,
            serverSide: true,
            pageLength: 10,
            lengthChange: false,
            searching: false,
            iDisplayLength: 10,
            pagingType: "numbers",
            columns: [
                {data: "id", className: "row-border", sortable: true},
                {data: "name", className: "row-border", sortable: false},
                {data: "specialty", className: "row-border", sortable: false},
                {data: "category", className: "row-border", sortable: false}
            ],
            language: {
                info: "Показаны _START_ - _END_ элементы из _TOTAL_ ",
                search: "Поиск: ",
                infoFiltered: "",
                infoEmpty: "Нет данных",
                zeroRecords: ""
            },
            rowCallback: function (row) {
                $(row).addClass("grow row-border");
                $("td", row).css("font-size", "1.5rem");
                $("td", row).addClass("table-inner-text");
                $('table th').addClass("table-header-text");
            },
            ajax: {
                url: "/doctor/filter",
                method: "get",
                data: function (d) {
                    return $.extend({}, d, {
                        "specialty": $("#specialtiesList").val(),
                        "name": $("#doctorName").val()
                    });
                },
                dataSrc: function (response) {
                    const data = response.data;
                    let all = [];
                    for (let i = 0; i < data.length; i++) {
                        console.log(data[i].id + " " + data[i].name + " " + data[i].specialty + " " + data[i].category);
                        let row = {
                            rows: response.start + i + 1,
                            id: data[i].id,
                            name: data[i].name,
                            specialty: data[i].specialty,
                            category: data[i].category
                        };
                        all.push(row);
                    }
                    return all;
                }
            }
        });
    });

    $("#updateButton").on("click", function (event) {
        table.ajax.reload();
        table.draw();
    });
</script>
</body>
</html>