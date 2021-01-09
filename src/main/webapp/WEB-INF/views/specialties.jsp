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
    <title> Специальности </title>
</head>
<body>
<%
    String pageName = "/specialty/find_doctors";
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
                <div class="col-md-8 mb-4 align-items-center my-auto"
                     style="background-color: white; opacity: 95%; border-radius: 10px;  padding: 5rem;">
                    <table id="specialtiesTable" class="table table-hover table-bordered table-sm my-auto"
                           style="background-color:white;">
                        <thead>
                        <tr>
                            <th class="th-sm table-header-text"> ID</th>
                            <th class="th-sm table-header-text"> Специальности</th>
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

<script src="${pageContext.request.contextPath}/js/preloader.js"></script>

<script src="${pageContext.request.contextPath}/js/redirect.js"></script>

<script>
    let table;
    $(document).ready(function () {
        table = $('#specialtiesTable').DataTable({
            processing: true,
            serverSide: true,
            pageLength: 10,
            lengthChange: false,
            searching: false,
            iDisplayLength: 10,
            pagingType: "numbers",
            columns: [
                {data: "id", className: "row-border", sortable: true, visible: false},
                {data: "name", className: "row-border", sortable: true},
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
                url: "/specialty/get_specialties",
                method: "get",
                dataSrc: function (response) {
                    const data = response.data;
                    let all = [];
                    for (let i = 0; i < data.length; i++) {
                        let row = {
                            rows: response.start + i + 1,
                            id: data[i].id,
                            name: data[i].name,
                        };
                        all.push(row);
                    }
                    return all;
                }
            }
        });
    });

    $('#specialtiesTable tbody').on('click', 'tr', function () {
        let data = table.row(this).data();
        redirectPage('<%=pageName%>?specialty=' + data.id);
    });
</script>

</body>
</html>