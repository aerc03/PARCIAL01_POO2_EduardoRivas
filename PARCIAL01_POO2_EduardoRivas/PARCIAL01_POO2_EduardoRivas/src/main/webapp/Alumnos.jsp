<%-- 
    Document   : Alumnos
    Created on : Aug 31, 2016, 5:01:16 PM
    Author     : aerc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Alumno</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">POO2</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse in" aria-expanded="true">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Lugar Acceso</a></li>
                            <li><a href="Tipo_Docu.jsp">Tipo Documento</a></li>
                            <li><a href="tipo_gafe.jsp">Tipo Gafete</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
      </nav>
            <div class="row">
                <div class="col-md-5">
                    <form action="AlumServ" method="Post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="cod" id="cod" value="${cod}">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="nomb" name="nomb" placeholder="Nombre" value="${nomb}">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="apel" name="apel" placeholder="Apellido" value="${apel}">
                        </div>
                        <div class="form-group">
                            <label>Fecha Nac.</label>
                            <input type="date" class="form-control" id="fech" name="fech" placeholder="Fecha Nac." value="${fech}">
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" id="mail" name="mail" placeholder="Correo" value="${mail}">
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="tele" name="tele" placeholder="Telefono" value="${tele}">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="dire" name="dire" placeholder="Direccion" value="${dire}">
                        </div>
                        <div class="form-group">
                            <select id="gene" name="gene">
                                <option value="M">Masculino</option>
                                <option value="F">Femenino</option>
                            </select>
                        </div>
                    
                    <input id="send" name="CursBoton" type="submit" value="Guardar" class="btn btn-success" />
                    <input id="send" name="CursBoton" type="submit" value="Consultar" class="btn btn-info" />
                    <input id="send" name="CursBoton" type="submit" value="Modificar" class="btn btn-warning" />
                    <input id="send" name="CursBoton" type="submit" value="Eliminar" class="btn btn-danger" />
                    
                                        

                </div>
                <div class="col-md-7">
                
                <jsp:useBean id="no" class="com.sv.udb.Controlador.AlumnoCtrl" scope="page"/>
                <div class="col-md-7">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Seleccione</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${alumno.consTodo()}" var="fila">
                            <tr>
                                <td><c:out value="${alumno.nombAlum}"></c:out></td>
                                <td><c:out value="${alumno.apelAlum}"></c:out></td>
                                <td><c:out value="${alumno.mailAlum}"></c:out></td>
                                <td> <input type="radio" name="codiRadi" value="${alumno.codiAlum}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                </div>
                </form>
            </div>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
</html>
