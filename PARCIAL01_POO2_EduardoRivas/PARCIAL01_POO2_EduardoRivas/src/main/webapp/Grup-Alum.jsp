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
                <div class="col-md-4">
                    <form action="GrupAlumServ" method="Post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="cod" id="cod" value="${cod}">
                        </div>
                        <jsp:useBean id="g" class="com.sv.udb.Controlador.GrupoCtrl" scope="page"/>
                        <div class="form-group">
                            <select id="grup" class="form-control" name="grup">
                                <c:forEach items="${g.consTodo()}" var="fila">
                                    <option value="${fila.codiGrup}">${fila.nombGrup}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <jsp:useBean id="a" class="com.sv.udb.Controlador.AlumnoCtrl" scope="page"/>
                            <select id="alum" class="form-control" name="alum">
                                <c:forEach items="${a.consTodo()}" var="fila">
                                    <option value="${fila.codiAlum}">${fila.nombAlum} ${fila.apelAlum}</option>
                                </c:forEach>
                            </select>
                        </div>
                    <input id="send" name="CursBoton" type="submit" value="Guardar" class="btn btn-success" />
                    
                    <input id="send" name="CursBoton" type="submit" value="Consultar" class="btn btn-info" />
                    <input id="send" name="CursBoton" type="submit" value="Modificar" class="btn btn-warning" />
                    <input id="send" name="CursBoton" type="submit" value="Eliminar" class="btn btn-danger" />
                    
                                        

                </div>
                <div class="col-md-5">
                <input  type="hidden" name="c" id="c" value="${c}"/>
                <jsp:useBean id="no" class="com.sv.udb.Controlador.GruposAlumnosCtrl" scope="page"/>
                <div class="col-md-7">
                    <table  class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Grupo</th>
                                <th>Alumno</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${no.consTodo()}" var="alumno">
                            <tr>
                                <c:if test="${alumno.codiGrup.codiGrup ==c}">
                                    <td><c:out value="${alumno.codiGrup.nombGrup}"></c:out></td>
                                    <td><c:out value="${alumno.codiAlum.nombAlum} ${alumno.codiAlum.apelAlum}"></c:out></td>
                                    <td> <input type="radio" name="codiRadi" value="${alumno.estaGrupAlum}"/></td>
                                </c:if>
                                        <c:if test="${c == null}">
                                        <td><c:out value="${alumno.codiGrup.nombGrup}"></c:out></td>
                                        <td><c:out value="${alumno.codiAlum.nombAlum} ${alumno.codiAlum.apelAlum}"></c:out></td>
                                            <td> <input type="radio" name="codiRadi" value="${alumno.estaGrupAlum}"/></td>
                                        </c:if>
                                
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                </div>
                <div class="col-md-3">
                    <label class="label-info">Grupos</label><br>
                    <jsp:useBean id="si" class="com.sv.udb.Controlador.GruposAlumnosCtrl" scope="page"/>
                    <c:forEach items="${si.consTodo()}" var="otro">
                        <td> <input type="radio" name="codiRadi2" value="${otro.codiGrupAlum}"/>${otro.codiGrup.nombGrup}</td><br>
                    </c:forEach>
                        <input id="send" name="CursBoton" type="submit" value="Grupo" class="btn btn-success" />
                </div>
                </form>
                    
            </div>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
</html>

