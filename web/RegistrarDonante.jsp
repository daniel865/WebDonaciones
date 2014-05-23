<%-- 
    Document   : RegistrarDonante
    Created on : 28-mar-2014, 9:17:02
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Donante</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
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



            <div class="container">
                <form class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Gestionar Donantes</legend>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tipo_doc">Tipo de Documento</label>
                            <div class="col-md-4 input-group">
                                <select id="tipo_doc" name="tipo_doc" class="form-control">
                                    <option value="1">Tarjeta de Identidad</option>
                                    <option value="2">Cédula de Ciudadanía</option>
                                    <option value="3">Cédula de Extranjería</option>
                                    <option value="4">Pasaporte</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nro_doc">Número de Documento</label>  
                            <div class="col-md-4 input-group">
                                <input id="nro_doc" name="nro_doc" type="text" placeholder="" class="form-control input-md" required="">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre Completo</label>  
                            <div class="col-md-4 input-group">
                                <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md" required="">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telefono">Teléfono </label>  
                            <div class="col-md-4">
                                <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección</label>  
                            <div class="col-md-4">
                                <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="departamento">Departamento</label>
                            <div class="col-md-4 input-group">
                                <select id="departamento" name="departamento" class="form-control input-md">
                                    <option value="1">Amazonas</option>
                                    <option value="2">Antioquia</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="ciudad">Ciudad</label>
                            <div class="col-md-4 input-group">
                                <select id="ciudad" name="ciudad" class="form-control input-md">
                                    <option value="1">Medellín</option>
                                    <option value="2">Itaguí</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="genero">Género</label>
                            <div class="col-md-4 input-group">
                                <select id="genero" name="genero" class="form-control input-md">
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo Electrónico</label>  
                            <div class="col-md-4">
                                <input id="correo" name="correo" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fecha_nacimiento">Fecha de Nacimiento</label>  
                            <div class="col-md-4 input-group">
                                <input id="fecha_nacimiento" name="fecha_nacimiento" type="date" class="form-control input-md">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fec_ultdonacion">Fecha Última Donación</label>  
                            <div class="col-md-4">
                                <input id="fec_ultdonacion" name="fec_ultdonacion" type="date"  class="form-control input-md">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="enfermedades">Enfermedades</label>
                            <div class="col-md-4 input-group">
                                <select id="enfermedades" name="enfermedades" class="form-control input-md">
                                    <option>Ninguna</option>
                                    <option value="1">Hepatitis A</option>
                                    <option value="2">Hepatitis B</option>
                                    <option value="">Cáncer</option>
                                    <option value="">Sida</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="habitos">Hábitos</label>
                            <div class="col-md-4 input-group">
                                <select id="habitos" name="habitos" class="form-control input-md">
                                    <option>Ninguno</option>
                                    <option value="1">Fumar</option>
                                    <option value="2">Drogas</option>
                                    <option value="">Alcohol</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nom_responsable">Nombre Responsable</label>  
                            <div class="col-md-4">
                                <input id="nom_responsable" name="nom_responsable" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tel_responsable">Teléfono Responsable</label>  
                            <div class="col-md-4">
                                <input id="tel_responsable" name="tel_responsable" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control input-md">
                                    <option value="1">Activo</option>
                                    <option value="2">Inactivo</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Groups Buttons -->
                        <div class="btn-group col-lg-offset-4 col-lg-4">
                            <input type="button" class="btn btn-default" id="registrar" name="accion" value="Registrar" />
                            <button type="button" class="btn btn-default">Buscar</button>
                            <button type="button" class="btn btn-default">Modificar</button>
                            <button type="button" class="btn btn-default">Eliminar</button> 
                        </div>

                    </fieldset>
                </form>
            </div>    

        </div>








    </body>
</html>
