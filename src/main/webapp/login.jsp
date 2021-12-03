<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.83.1">
        <title>Login</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <style>
            .login {
            margin: 20px auto;
            
            width: 400px;
            background-color: #E9BBF2;
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
                height: 101%;
            }

            body {
                display: flex;
                align-items: center;
                padding-top: 40px;
                padding-bottom: 40px;
                  
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
		<form action="Login" method="post">
                <img class="mb-2" src="https://www.prosync.pt/images/Login%20ProSync.png" alt="" width="330" height="230">
                <h1 class="h3 mb-2 fw-normal"></h1>

                <label for="floatingInput">Correoooo electrónicoooo</label> 
                <div class="form-floating">
                    
                    <input type="email" name="email" class="form-control" id="floatingInput">
                    
                </div>
                <label for="floatingPassword">Password</label>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" >
                    
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Recuerdame
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
                <br><br>
                <a href="NuevoUsuarioControlador?action=add"  class="w-100 btn btn-lg btn-primary"> Agregar Nuevo Usuario</a>
                <p class="mt-5 mb-1 text-muted" align="center">&copy; 30–11-2021</p>
            </form>
	</div>
</body>
</html>

