<%
    String opcion =  request.getParameter("opcion");
%>
        <ul class="nav nav-tabs">
            <li class="nav-item">                                     
                <a class="nav-link <%= (opcion.equals("admin") ?  "active" : "") %>" href="UsuarioControlador">Menu Principal</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <%= (opcion.equals("gastos") ?  "active" : "") %>" href="GastosControlador">Gastos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <%= (opcion.equals("ingresos") ?  "active" : "") %>" href="IngresosControlador">Ingresos</a>
            </li>            
            <li class="nav-item">
                <a class="nav-link <%= (opcion.equals("gastos_total") ?  "active" : "") %>" href="ComunControlador?action=gastos">Gastos Totales de la Empresa</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <%= (opcion.equals("ingresos_total") ?  "active" : "") %>" href="ComunControlador?action=ingresos">Ingresos Totales de la Empresa</a>
            </li>
        </ul>