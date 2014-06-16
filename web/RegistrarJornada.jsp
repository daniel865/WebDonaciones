<%-- 
    Document   : RegistrarJornada
    Created on : 29-mar-2014, 11:09:19
    Author     : daniel
--%>

<%@page import="com.donaciones.entities.Municipio"%>
<%@page import="com.donaciones.entities.Departamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String codigo = request.getAttribute("codigo") != null ? (String) request.getAttribute("codigo") : "";
    String descripcion = request.getAttribute("descripcion") != null ? (String) request.getAttribute("descripcion") : "";
    String fecha_programada = request.getAttribute("fecha_programada") != null ? (String) request.getAttribute("fecha_programada") : "";
    String departamento = request.getAttribute("departamento") != null ? (String) request.getAttribute("departamento") : "";
    String municipio = request.getAttribute("municipio") != null ? (String) request.getAttribute("municipio") : "";
    String direccion = request.getAttribute("direccion") != null ? (String) request.getAttribute("direccion") : "";
    String donantes = request.getAttribute("donantes") != null ? (String) request.getAttribute("donantes") : "";
    String sangre_a1 = request.getAttribute("sangre_a1") != null ? (String) request.getAttribute("sangre_a1") : "";
    String sangre_a2 = request.getAttribute("sangre_a2") != null ? (String) request.getAttribute("sangre_a2") : "";
    String sangre_ab1 = request.getAttribute("sangre_ab1") != null ? (String) request.getAttribute("sangre_ab1") : "";
    String sangre_ab2 = request.getAttribute("sangre_ab2") != null ? (String) request.getAttribute("sangre_ab2") : "";
    String sangre_b1 = request.getAttribute("sangre_b1") != null ? (String) request.getAttribute("sangre_b1") : "";
    String sangre_b2 = request.getAttribute("sangre_b2") != null ? (String) request.getAttribute("sangre_b2") : "";
    String sangre_o1 = request.getAttribute("sangre_o1") != null ? (String) request.getAttribute("sangre_o1") : "";
    String sangre_o2 = request.getAttribute("sangre_o2") != null ? (String) request.getAttribute("sangre_o2") : "";
    String observaciones = request.getAttribute("observaciones") != null ? (String) request.getAttribute("observaciones") : "";
    String estado = request.getAttribute("estado") != null ? (String) request.getAttribute("estado") : "";
    List<Departamento> listDepartamentos = request.getAttribute("listDepartamentos") != null ? (List<Departamento>) request.getAttribute("listDepartamentos") : null;
    List<Municipio> listMunicipios = request.getAttribute("listMunicipios") != null ? (List<Municipio>) request.getAttribute("listMunicipios") : null;
    boolean load = (Boolean) request.getAttribute("load") != null ? (Boolean) request.getAttribute("load") : false;
    String cargoDepartamentos;
    String cargoMunicipios;

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Jornada de Donación</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.bootstrap.popover.min.js"></script>
        <script type="text/javascript"></script>
        <script>
           /* $(document).ready(function() {
                $('#departamento').change(function(event) {
                    var sports = $("select#departamento").val();
                    $.get('JornadaServlet', {
                        value: sports
                    }, function(jsonResponse) {
                        var select = $('#municipio');
                        select.find('option').remove();
                        $.each(jsonResponse, function(key, value) {
                            $('<option>').val(key).text(value).appendTo(select);
                        });
                    });
                });
            });
            */
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


            <!--  Inicio del Formulario-->
            <div class="container">

                <form class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Gestionar Jornada de Donación</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="codigo">Código</label>  
                            <div class="col-md-4 input-group">
                                <input id="codigo" name="codigo" type="text" placeholder="" class="form-control input-md" value="<%=codigo%>">

                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="descripcion">Descripción</label>
                            <div class="col-md-4 input-group">                     
                                <textarea class="form-control" id="descripcion" name="descripcion"><%=descripcion%></textarea>

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fecha_programada">Fecha Programada</label>  
                            <div class="col-md-4 input-group">
                                <input id="fecha_programada" name="fecha_programada" type="date" placeholder="" class="form-control input-md" value="<%=fecha_programada%>">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="departamento">Departamento</label>
                            <div class="col-md-4 input-group">
                                <select id="departamento" name="departamento" class="form-control">
                                    <option>Seleccione un Departamento</option>
                                    <%
                                        for (int index = 0; listDepartamentos != null && index < listDepartamentos.size(); index++) {
                                            Departamento departamento1 = listDepartamentos.get(index);
                                    %>
                                    <option value="<%=departamento1.getId()%>"><%=departamento1.getNombre()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="municipio">Municipio</label>
                            <div class="col-md-4 input-group">
                                <select id="municipio" name="municipio" class="form-control">
                                    <option>Seleccione un Municipio</option>
                                    <option value="1">Medellín</option>
                                    <option value="2">Copacabana</option>
                                    <option value="3">itaguí</option>
                                    <option value="4">La Estrella</option>
                                    <option value="5">Sabaneta</option>
                                </select>

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección</label>  
                            <div class="col-md-4 input-group">
                                <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="donantes">Donantes</label>  
                            <div class="col-md-4 input-group">
                                <input id="donantes" name="donantes" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_a1">Cantidad Sangre A+</label>  
                            <div class="col-md-4">
                                <input id="sangre_a1" name="sangre_a1" type="text" placeholder="Cm3" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_a2">Cantidad Sangre A-</label>  
                            <div class="col-md-4">
                                <input id="sangre_a2" name="sangre_a2" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_ab1">Cantidad Sangre AB+</label>  
                            <div class="col-md-4">
                                <input id="sangre_ab1" name="sangre_ab1" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_ab2">Cantidad Sangre AB-</label>  
                            <div class="col-md-4">
                                <input id="sangre_ab2" name="sangre_ab2" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_b1">Cantidad Sangre B+</label>  
                            <div class="col-md-4">
                                <input id="sangre_b1" name="sangre_b1" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_b2">Cantidad Sangre B-</label>  
                            <div class="col-md-4">
                                <input id="sangre_b2" name="sangre_b2" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_o1">Cantidad Sangre O+</label>  
                            <div class="col-md-4">
                                <input id="sangre_o1" name="sangre_o1" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sangre_o2">Cantidad Sangre O-</label>  
                            <div class="col-md-4">
                                <input id="sangre_o2" name="sangre_o2" type="text" placeholder="Cm3" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="observaciones">Observaciones</label>
                            <div class="col-md-4">                     
                                <textarea class="form-control" id="observaciones" name="observaciones"></textarea>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control">
                                    <option value="Activo">Activo</option>
                                    <option value="Inactivo">Inactivo</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                    </fieldset>

                    <input type="hidden" name="cargoDepartamentos" id="cargoDepartamentos" />
                    <input type="hidden" name="cargoMunicipios" id="cargoMunicipios" />

                </form>

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="UsuarioServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Jornada</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Código de la Jornada</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_jor" name="buscar_jor" placeholder="" class="form-control input-md"  type="text">
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

                <!-- Groups Buttons -->
                <div class="btn-group col-lg-offset-4 col-lg-4">
                    <!--<button type="button" class="btn btn-default" name="btnnuevo" id="btnnuevo">Nuevo</button>-->
                    <input type="submit" class="btn btn-default " name="accion" value="Guardar" id="btnguardar" />
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#ModalBuscar" name="btnbuscar" id="btnbuscar">Consultar</button>
                    <input type="submit" class="btn btn-default" name="accion" value="Modificar" id="btnmodificar" /> 
                    <button type="button" class="btn btn-default" name="btneliminar" id="btneliminar">Eliminar</button> 
                </div>

            </div>


        </div>
    </body>
</html>
