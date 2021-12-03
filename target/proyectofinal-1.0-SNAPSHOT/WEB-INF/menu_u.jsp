<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav nav-tabs">
                <li class="nav-item">                                     
                    <a class="nav-link <%= (opcion.equals("menu") ?  "active" : "") %>" href="ComunControlador">Menu Principal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("gastos") ?  "active" : "") %>" href="ComunControlador?action=gastos">Gastos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("ingresos") ?  "active" : "") %>" href="ComunControlador?action=ingresos">Ingresos</a>
                </li>
            </ul>