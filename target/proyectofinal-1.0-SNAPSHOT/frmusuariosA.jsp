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

        <title>Punto de Registro de Nuevo Usuario</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de Usuarios</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="usuario" />
                <jsp:param name="nivel" value="usuario" />
            </jsp:include>      
            <br>
            <form action="UsuarioControlador" method="post" >
                <input type="hidden" name="idu" value="${usuario.idu}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${usuario.nombre}" placeholder=" porfavor escriba su nombre">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Apellido</label>
                    <input type="text" class="form-control" name="apellido" value="${usuario.apellido}" placeholder="porfavor escriba su apellido">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">CI</label>
                    <input type="text" class="form-control" name="ci" value="${usuario.CI}" placeholder="porfavor escriba su CI">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Telefono</label>
                    <input type="text" class="form-control" name="telefono" value="${usuario.telefono}" placeholder="porfavor escriba su numero de telefono">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Celular</label>
                    <input type="text" class="form-control" name="celular" value="${usuario.celular}" placeholder="porfavor escriba su numero de celular">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Correo electrónico</label>
                    <input type="email" class="form-control" name="correo" value="${usuario.correo}" placeholder="porfavor escriba su correo electrónico">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" value="${usuario.password}" placeholder="porfavor escriba su password">
                </div>                
                <div class="form-group">
                    <label for="" class="form-label">Cargo</label>
                    <select name="nivel" class="form-control">
                        <option>Administrador</option>
                        <option>Usuario</option>
                        <option>Visitante</option>                                      
                    </select>
                </div>                
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    </body>
</html>
