<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <style>
            html,body {
                height: 100%;
            }
            body {
                background: #0BE13F;
                background: radial-gradient(ellipse at center,  #0BE13F  90%, #000000 90%);
                background-size: 100%;
            }
            p {
                margin: 0;
                padding: 0;
            }
            #clock {
                font-family: 'Share Tech Mono', monospace;
                color: #ffffff;
                text-align: center;
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                color: #daf6ff;
                text-shadow: 0 0 20px rgba(10, 175, 230, 1),  0 0 20px rgba(10, 175, 230, 0);
                .date {
                    letter-spacing: 0.1em;
                    font-size: 24px;
                }
                .text {
                    letter-spacing: 0.1em;
                    font-size: 12px;
                    padding: 20px 0 0;
                }
            }
        </style>
        <title>Ingresos Totales de la Empresa</title>
    </head>
    <body>        
<%  if (session.getAttribute("cargo").equals("Administrador")){  %>               
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="opcion" value="ingresos_total" />
        </jsp:include>                  
<%  } else {    %>
        <jsp:include page="WEB-INF/menu_u.jsp">
            <jsp:param name="opcion" value="ingresos" />
        </jsp:include>
<%  }   %> 
        <div id="clock">
            <p class="date" style="font-size: 100px;">Bs ${ingresos_idu.monto_ingreso}</p>
            <p class="text">INGRESO TOTAL</p>
        </div>
    </body>
</html>
