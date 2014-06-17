<%-- 
    Document   : ReporteJornada
    Created on : 16/06/2014, 05:53:58 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensaje = request.getParameter("mensaje")!=null ? (String) request.getParameter("mensaje") : null;
%>

<%if (mensaje != null) {%>
<script>
    alert('<%=mensaje%>');

</script>
<%}%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de Jornadas de Donación</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <link rel="stylesheet" type="text/css" href="css/inicio.css" />
        <script src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
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
                                <li><a href="UsuarioServlet">Gestionar Usuario</a></li>
                                <li><a href="DonanteServlet">Gestionar Donante</a></li>
                                <li><a href="BolsaServlet">Gestionar Bolsa de Sangre</a></li>
                                <li><a href="HospitalServlet">Gestionar Hospital</a></li>
                                <li><a href="JornadaServlet">Gestionar Jornada de Donación</a></li>
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

                <form id="FormUsuario" class="form-horizontal"  action="JornadaServlet" method="POST">
                    <fieldset>


                        <!-- Form Name -->
                        <legend>Reportes Jornadas de Donación</legend>

                        <br>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nro_identificacion">Código</label>  
                            <div class="col-md-4 input-group">
                                <input id="codigo" name="codigo" type="text" placeholder="" class="form-control input-md">
                            </div>
                        </div>

                        <br/>

                        <div class="container">
                            <button type="submit" class="btn btn-primary btn-lg col-md-4" name="accion" value="Reporte Jornada">Reporte Jornada</button>
                            <button type="submit" class="btn btn-primary btn-lg col-md-4" name="accion" value="Listar Jornadas" style="margin-left: 10px;">Listar Jornadas</button>
                        </div>




                    </fieldset>
                </form>



            </div>


        </div>



    </body>
</html>


