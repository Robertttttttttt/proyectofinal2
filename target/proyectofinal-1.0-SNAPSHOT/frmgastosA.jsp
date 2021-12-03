<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Punto de Registro de Nuevo Gasto</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de Gastos</h1>
            <br>
<%      if (session.getAttribute("cargo").equals("Administrador")){  %>            
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="gastos" />
            </jsp:include>
            <form action="GastosControlador" method="post" >
<%      } else {    %>
            <a href="ComunControlador" class="btn btn-danger">Volver</a>
            <form action="ComunControlador" method="post" >
<%      }   %>
                <input type="hidden" name="new" value="gastos">
                <input type="hidden" name="idg" value="${gastos.idg}">
                <div class="form-group">
                    <label for="" class="form-label">Usuarios</label>
                    <select name="idu" class="form-control">
                        <option value="">-- Seleccione --</option>
                            <c:forEach var="item" items="${lista_usuarios}">
                                <option value="${item.idu}" 
                                        <c:if test="${gastos.idu == item.idu}">
                                            selected
                                        </c:if>
                                            >${item.nombre}</option>
                            </c:forEach>                                   
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="${gastos.descripcion}" placeholder="Escriba una descripcion del gasto">
                </div>         
                <div class="form-group">
                    <label for="" class="form-label">Monto de gasto</label>
                    <input type="number" class="form-control" name="monto_gasto" value="${gastos.monto_gastado}" step="0.01" placeholder="Ingrese el monto a gastar">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    </body>
</html>
