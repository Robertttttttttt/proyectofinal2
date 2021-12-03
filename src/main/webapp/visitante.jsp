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
    #clock {
        
        .date {
            letter-spacing: 0.1em;
            left: 50%;
            top: 50%;
            transform: translate(-50%, 0%);
            font-size: 24px;
            color: greenyellow;
        }
        .date1 {
            letter-spacing: 0.1em;
            left: 50%;
            top: 50%;
            transform: translate(0%, 0%);
            font-size: 24px;
        }
    }
    </style>
        <title>Visitante</title>
    </head>
    <body style="background: #FFE3B3">
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <a href="Logout" class="btn btn-danger"> Cerrar Sesión</a>
        </div>
        <br>
        <h1 style=" padding: 10px; background-color: #FFC172; color: black; font-family: arial,helvetica; font-size: 20px; font-weight: bold;" align="center">Bienvenido Visitante ${usuario.nombre} ${usuario.apellido}</h1>        
        <br><br>
        <table style="width:99%; background-color:#26798E; " align="center" border="1" cellpadding="5" cellspacing="0"  class="table table-success table-striped" >
            <tr>
                <th style="width:50%; text-align: center;" >INGRESOS</th>
                <th style="width:50%; text-align: center;">GASTOS</th>
            </tr>
            <tr>
                <td>
                    <br>
                    <div id="clock">
                        <p class="date1" style="font-size: 100px; color: #45B068" align="center"><strong>${total_i.monto_ingreso}</strong></p>              
                    </div>
                </td>
                <td>
                    <br>
                    <div id="clock">
                        <p class="date" style="font-size: 100px; color: #D83C24" align="center"><strong>${total_g.monto_gastado}</strong></p>               
                    </div>
                </td>
            </tr>
        </table> 
        <br>        
    </body>
</html>
