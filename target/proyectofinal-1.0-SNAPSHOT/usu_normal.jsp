<%
    if (session.getAttribute("login") != "OK"){
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="3">        
        <style>
    #scroll{
        border:1px solid;
        height:300px;
        width:100%;
        overflow-y:scroll;
        overflow-x:hidden;
    }    
    .wrapper {
        border-radius: 2em;
        width: 80px;
        min-width: 250px;
        margin: 2em auto;
        padding: 1em;
        text-align: center;
        box-shadow: 0 0 10px rgba(0, 0, 10, .8);
        background-color: #26798E;
        color: white;
     }
    .counter {
        text-align: center;
        width: 100%;
        height: 1em;
        margin-left: auto;
        margin-right: auto;
        font-size: 4em;
        margin-bottom: 20px;
    }

    </style>
        <title>Usuario</title>
    </head>
    <body style="background: #8AFEAB">
        <jsp:include page="WEB-INF/menu_u.jsp">
            <jsp:param name="opcion" value="menu" />
        </jsp:include>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <a href="Logout" class="btn btn-danger"> Cerrar Sesión</a>
        </div>
        <br>
        <h1 style=" padding: 10px; background-color: #05D84F; color: black; font-family: arial,helvetica; font-size: 20px; font-weight: bold;" align="center">Bienvenido Usuario ${usuario.nombre} ${usuario.apellido}</h1>        
        <br><br>
        <table style="width:99%; background-color:#03AA66; " align="center" border="1" cellpadding="5" cellspacing="0"  class="table table-success table-striped" >
            <tr>
                <th style="width:50%; text-align: center;" >INGRESOS</th>
                <th style="width:50%; text-align: center;">GASTOS</th>
            </tr>
            <tr>
                <td>
                   <a href="ComunControlador?action=add-ingresos" class="btn btn-primary btn-sm"><i class="fas fa-plus-circle"></i> NUEVO INGRESO</a>
                    <br><br>
                    <div id="scroll">
                        <table border="1" cellspacing="0" cellpadding="5" class="table table-dark table-sm">
                       
                            <tr>
                                <th>Idi</th> 
                                <th>Despcipcion</th>
                                <th style="width:10%;" >Monto</th>
                                <th>Fecha</th>
                                <th>Hora</th>
                            </tr>
                            <c:forEach var="item" items="${ingresos}">
                            <tr>
                                <td>${item.idi}</td>
                                <td>${item.descripcion}</td>
                                <td>${item.monto_ingreso}</td>
                                <td>${item.fecha}</td>
                                <td>${item.hora}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>                   
                </td>
                <td>
                    <a href="ComunControlador?action=add-gastos" class="btn btn-primary btn-sm"><i class="fas fa-plus-circle"></i> NUEVO GASTO</a>
                    <br>
                    <br>
                    <div id="scroll">
                       <table border="1" cellspacing="0" cellpadding="5"class="table table-dark table-sm">
                            <tr>
                                <th>Idg</th> 
                                <th>Despcipcion</th>
                                <th style="width:10%;" >Monto</th>
                                <th>Fecha</th>
                                <th>Hora</th>
                            </tr>
                            <c:forEach var="gas" items="${gastos}">
                            <tr>
                                <td>${gas.idg}</td>
                                <td>${gas.descripcion}</td>
                                <td>${gas.monto_gastado}</td>
                                <td>${gas.fecha}</td>
                                <td>${gas.hora}</td>
                            </tr>                    
                            </c:forEach>    
                    </table>
                    </div>                   
                </td>
            </tr>
        </table> 
        <br>        
    </body>
</html>
