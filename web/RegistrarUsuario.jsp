<%-- 
    Document   : Usuario
    Created on : 1/03/2014, 12:46:29 PM
    Author     : sala306
--%>

<%@page import="Entidades.Usuario" %>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario datos = (Usuario) request.getSession().getAttribute("usuario") != null ? (Usuario) request.getSession().getAttribute("usuario") : null;
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String nro_identificacion = request.getAttribute("nro_identificacion") != null ? (String) request.getAttribute("nro_identificacion") : "";
    String nombre = request.getAttribute("nombre") != null ? (String) request.getAttribute("nombre") : "";
    String apellidos = request.getAttribute("apellidos") != null ? (String) request.getAttribute("apellidos") : "";
    String usuario = request.getAttribute("usuario") != null ? (String) request.getAttribute("usuario") : "";
    String correo = request.getAttribute("correo") != null ? (String) request.getAttribute("correo") : "";
    String pass = request.getAttribute("pass") != null ? (String) request.getAttribute("pass") : "";
    String perfil = request.getAttribute("perfil") != null ? (String) request.getAttribute("perfil") : "";
    String estado = request.getAttribute("estado") != null ? (String) request.getAttribute("estado") : "";
    String buscar_usu = request.getAttribute("buscar_usu") != null ? (String) request.getAttribute("buscar_usu") : "";
    List<Usuario> usuarios = request.getAttribute("usuarios") != null ? (List<Usuario>) request.getAttribute("usuarios") : null;

    

%>

<%if (mensaje != null) {%>
<script>
    alert('<%=mensaje%>');

</script>
<%}%>


<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/additional-methods.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.bootstrap.popover.min.js"></script>
        <script type="text/javascript" src="js/ValidacionesUsuario.js"></script>

        <%if (mensaje != null) {%>
        <script>
    $(document).ready(function() {
        var estado = '<%=estado%>';
        if (estado === "Activo") {
            $("#estado option[value=Activo]").attr("selected", true);
        }
        if (estado === "Inactivo") {
            $("#estado option[value=Inactivo]").attr("selected", true);
        }
        var perfil = '<%=perfil%>';
        if (perfil === "Medico") {
            $("#perfil option[value=Medico]").attr("selected", true);
        }
        if (perfil === "Enfermera") {
            $("#perfil option[value=Enfermera]").attr("selected", true);
        }
        if (perfil === "Bacteriologo") {
            $("#perfil option[value=Bacteriologo]").attr("selected", true);
        }

        

    });

    //alert(estado);
        </script>
        <%}%>   


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




            <div class="container" >
                <form id="FormUsuario" class="form-horizontal"  action="UsuarioServlet" method="POST">
                    <fieldset>


                        <!-- Form Name -->
                        <legend>Registar Usuario</legend>

                        <br>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nro_identificacion">Número de Identificación</label>  
                            <div class="col-md-4 input-group">
                                <input id="nro_identificacion" name="nro_identificacion" type="text" placeholder="" class="form-control input-md" value="<%=nro_identificacion%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombres</label>
                            <div class="col-md-4 input-group">
                                <input id="nombre" name="nombre" placeholder="" class="form-control input-md"  required="" type="text" value="<%=nombre%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="apellidos">Apellidos</label>  
                            <div class="col-md-4 input-group">
                                <input id="apellidos" name="apellidos" placeholder="" class="form-control input-md" required="" type="text" value="<%=apellidos%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="usuario">Usuario</label>  
                            <div class="col-md-4 input-group">
                                <input id="usuario" name="usuario" placeholder="" class="form-control input-md"  type="text" value="<%=usuario%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pass">Contraseña</label>
                            <div class="col-md-4 input-group">
                                <input id="pass" name="pass" placeholder="" class="form-control input-md"  type="password" value="<%=pass%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pass2">Confirme Contraseña</label>
                            <div class="col-md-4 input-group">
                                <input id="pass2" name="pass2" placeholder="" class="form-control input-md"  type="password" value="<%=pass%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Campo de Correo -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo electrónico</label>
                            <div class="col-md-4 input-group">
                                <input id="correo" name="correo" placeholder="" class="form-control input-md"  type="text" value="<%=correo%>" >
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="perfil">Perfil</label>
                            <div class="col-md-4 input-group">
                                <select id="perfil" name="perfil" class="form-control" >
                                    <option value=""></option>                                  
                                    <option value="Medico">Médico</option>
                                    <option value="Enfermera">Enfermera(o)</option>
                                    <option value="Bacteriologo">Bacteriólogo(a)</option>

                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control"  >
                                    <option value=""></option>  
                                    <option value="Activo">Activo</option>
                                    <option value="Inactivo">Inactivo</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>


                        <!-- Groups Buttons -->
                        <div class="btn-group col-lg-offset-4 col-lg-4">
                            <!--<button type="button" class="btn btn-default" name="btnnuevo" id="btnnuevo">Nuevo</button>-->
                            <input type="submit" class="btn btn-default" name="accion" value="Guardar" id="btnguardar" />
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#ModalBuscar" name="btnbuscar" id="btnbuscar">Consultar</button>
                            <input type="submit" class="btn btn-default" name="accion" value="Modificar" id="btnmodificar" /> 
                            <button type="button" class="btn btn-default" name="btneliminar" id="btneliminar">Eliminar</button> 

                        </div>
                    </fieldset>
                </form>

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="UsuarioServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Usuario</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Nombre de Usuario</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_usu" name="buscar_usu" placeholder="" class="form-control input-md"  type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <input type="submit" value="Consultar" class="btn btn-primary" name="accion" id="btnbuscarb">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>




    </body>
</html>
