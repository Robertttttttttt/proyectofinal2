<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.83.1">
        <title>Formulario Usuario Externo</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <style>
            .login {
            margin: 20px auto;
            width: 300px;
            background-color: #FFF;
            padding: 8px;
            border-radius: 5px
            }
            
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
            html,
            body {
                
                height: 100%;
            }

            body {
                display: flex;
                align-items: center;
                padding-top: 40px;
                padding-bottom: 40px;
                background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 35%, rgba(0,212,255,1) 100%);
              
            }

            .form-signin {
                width: 100%;
                max-width: 330px;
                padding: 15px;
                margin: auto;
            }

            .form-signin .checkbox {
                font-weight: 400;
            }

            .form-signin .form-floating:focus-within {
                z-index: 2;
            }

            .form-signin input[type="email"] {
                margin-bottom: -1px;
                border-bottom-right-radius: 0;
                border-bottom-left-radius: 0;
            }

            .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
         </style>
    </head>
    <body>
	<div class="login">
		<form action="NuevoUsuarioControlador" method="post">
                <img class="mb-4" src="https://turismosurdelosrios.cl/wp-content/uploads/2018/02/male-user.png" alt="" width="270" height="230">
                <h1 class="h3 mb-3 fw-normal"></h1>
                <input type="hidden" name="id" value="${usuario.idu}">
                <div class="form-floating">
                    <input type="text" name="nombre" class="form-control" id="floatingInput" placeholder="">
                    <label for="floatingInput">Nombre:</label>
                </div>
                
                <div class="form-floating">
                    <input type="text" name="apellido" class="form-control" id="floatingPassword" placeholder="">
                    <label for="floatingInput">Apellidos:</label>
                </div>
                
                <div class="form-floating">
                    <input type="text" name="ci" class="form-control" id="floatingPassword" placeholder="">
                    <label for="floatingInput">CI:</label>
                </div>
                
                <div class="form-floating">
                    <input type="text" name="telefono" class="form-control" id="floatingPassword" placeholder="">
                    <label for="floatingInput">Telefono:</label>
                </div>
                
                <div class="form-floating">
                    <input type="text" name="celular" class="form-control" id="floatingPassword" placeholder="">
                    <label for="floatingInput">Celular:</label>
                </div>
                
                <div class="form-floating">
                    <input type="email" name="correo" class="form-control" id="floatingPassword" placeholder="name@example.com">
                    <label for="floatingInput">Correo:</label>
                </div>
                
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="">
                    <label for="floatingPassword">Password:</label>
                </div>
                
                <div class="form-floating">
                    <input type="hidden" name="nivel" value="Visitante" class="form-control" id="floatingPassword" placeholder="">
                </div>
                <br>
                <br>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Crear Usuario</button>
            </form>
	</div>
</body>
</html>