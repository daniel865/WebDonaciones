<%-- 
    Document   : Inicio
    Created on : 10-mar-2014, 12:00:58
    Author     : daniel
--%>
<%@page import="java.util.List" %>
<%@page import="Entidades.BolsasSangre" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<BolsasSangre> bolsas = request.getAttribute("bolsas") != null ? (List<BolsasSangre>) request.getAttribute("bolsas") : null;
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <link rel="stylesheet" type="text/css" href="css/inicio.css" />
        <link href='http://fonts.googleapis.com/css?family=Playfair+Display+SC' rel='stylesheet' type='text/css'>
        <style>
            h1 {
                text-align: center;
                color: black;
                font-family: 'Playfair Display SC', serif;
            }  

        </style>
        <script src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Tipo de Sangre', 'Cantidad'],
                    ['A+', 11],
                    ['A-', 89],
                    ['AB+', 50],
                    ['AB-', 28],
                    ['B+', 30],
                    ['B-', 31],
                    ['O+', 10],
                    ['O-', 10]
                ]);

                var options = {
                    title: 'Cantidades de Sangre Donada por Tipo',
                    is3D: true,
                };

                var chart = new google.visualization.PieChart(document.getElementById('flot-chart-pie'));
                chart.draw(data, options);
            }
        </script>



    </head>
    <body>
        <div id="wrapper">

            <!-- Menu Horizontal -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Agrupación de Elementos en navbar para dispositivos mobiles-->
                <div class="navbar-header"> 
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"> <!-- Organizar data-target -->
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="Inicio.jsp">Donaciones Web</a>
                </div>

                <!-- Colección de Link del Nav para el dashboard  parte izquierda-->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li><a href="Inicio.jsp"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-save"></i> Gestionar <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="RegistrarUsuario.jsp">Gestionar Usuario</a></li>
                                <li><a href="RegistrarDonante.jsp">Gestionar Donante</a></li>
                                <li><a href="RegistrarBolsas.jsp">Gestionar Bolsa de Sangre</a></li>
                                <li><a href="RegistrarHospital.jsp">Gestionar Hospital</a></li>
                                <li><a href="RegistrarJornada.jsp">Gestionar Jornada de Donación</a></li>
                            </ul>                      
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-clipboard"></i> Reportes<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Reporte Donantes</a></li>
                                <li><a href="#">Reporte Bolsas de Sangre</a></li>
                                <li><a href="#">Reporte Jornadas de Donación</a></li>
                            </ul>
                        </li> 
                    </ul>


                    <!-- Coleccion de links del nav parte superior derecha -->
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li><a>Ayuda</a></li>
                        <li><a href="index.jsp">Salir</a></li>
                    </ul>

                </div> <!-- Fin Barra Colapsada -->
            </nav>

            <!-- Comienzo del contenido interno de la página -->
            <div class="container">
                <br>
                <br>

                <h1>Bienvenido al Sistema de Gestión de Donaciones de Sangre</h1>
                
                <br>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> Cantidad Bolsas de Sangre por Tipo</h3>
                            </div>
                            <div class="panel-body">
                                <!-- Contenido del Chart -->
                                <div class="flot-chart container">
                                    <div id="flot-chart-pie" style="width: 1000px; height: 415px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>






            </div>




        </div>



    </body>
</html>
