package com.emergentes.controlador;

import com.emergentes.dao.GastosDAO;
import com.emergentes.dao.GastosDAOImpl;
import com.emergentes.dao.IngresosDAO;
import com.emergentes.dao.IngresosDAOImpl;
import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOImpl;
import com.emergentes.dao.TotalesDAO;
import com.emergentes.dao.TotalesDAOImpl;
import com.emergentes.modelo.Gastos;
import com.emergentes.modelo.Ingresos;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ComunControlador", urlPatterns = {"/ComunControlador"})
public class ComunControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession ses = request.getSession();
            Gastos gas = new Gastos();  
            GastosDAO daoGastos = new GastosDAOImpl();    
            Ingresos ingresos = new Ingresos();
            IngresosDAO daoIngresos = new IngresosDAOImpl();
            Usuarios usu = new Usuarios();
            UsuariosDAO daoUsuarios= new UsuariosDAOImpl();

            TotalesDAO daoTotales = new TotalesDAOImpl();
            
            int idu = Integer.parseInt(ses.getAttribute("idusuario").toString());            
            
            List<Usuarios> lista_usuarios = null;     
              
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = " + action);
            switch(action){
                case "add-ingresos":
                    lista_usuarios = daoUsuarios.getOne(idu);
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("ingresos", ingresos);
                    request.getRequestDispatcher("frmingresosA.jsp").forward(request, response);
                    break;
                case "add-gastos":
                    lista_usuarios = daoUsuarios.getOne(idu);
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("gastos",gas);
                    request.getRequestDispatcher("frmgastosA.jsp").forward(request, response);
                    break; 
                case "view":
                    usu =  daoUsuarios.getById(idu);
                    request.setAttribute("usuario", usu);
                    List<Gastos> lista_gastos = daoGastos.getByIdu(idu);
                    request.setAttribute("gastos", lista_gastos);
                    List<Ingresos> lista_ingresos = daoIngresos.getByIdu(idu);
                    request.setAttribute("ingresos", lista_ingresos);
                    request.getRequestDispatcher("usu_normal.jsp").forward(request, response);                    
                    break;
                case "gastos":
                    gas = daoTotales.GastosTotales();
                    request.setAttribute("gastos_idu", gas);
                    request.getRequestDispatcher("gasto_total.jsp").forward(request, response);
                    break;
                case "ingresos":
                    ingresos = daoTotales.IngresosTotales();
                    request.setAttribute("ingresos_idu", ingresos);
                    request.getRequestDispatcher("ingreso_total.jsp").forward(request, response);
                    break;
                case "only-view":
                    usu =  daoUsuarios.getById(idu);
                    request.setAttribute("usuario", usu);
                    gas = daoGastos.GastosTotales();
                    request.setAttribute("total_g", gas);                    
                    ingresos = daoIngresos.IngresosTotales();
                    request.setAttribute("total_i", ingresos);
                    request.getRequestDispatcher("visitante.jsp").forward(request, response);
                    break;
            }            
        }catch(Exception ex){
            System.out.println("Error con el usuario comun " + ex.getMessage());
        }
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String caso = (request.getParameter("new") != null) ? request.getParameter("new") : "null";
        
        switch (caso) {
            case "ingreso":
                {                    
                    String descripcion = request.getParameter("descripcion");
                    float monto = Float.parseFloat(request.getParameter("monto_ingreso")); 
                    int idu = Integer.parseInt(request.getParameter("idu"));
                    Ingresos ing = new Ingresos();
                    
                    ing.setDescripcion(descripcion);
                    ing.setMonto_ingreso(monto);
                    ing.setIdu(idu);
                    
                    // Nuevo
                    IngresosDAO dao = new IngresosDAOImpl();
                    try {
                        dao.insert(ing);
                    } catch (Exception ex) {
                        System.out.println("Error al insertar "+ex.getMessage());
                    }
                    break;
                }
            case "gastos":
                {
                    String descripcion = request.getParameter("descripcion");              
                    int idu = Integer.parseInt(request.getParameter("idu"));
                    float monto = Float.parseFloat(request.getParameter("monto_gasto"));
                    Gastos gas = new Gastos();                    
                    gas.setIdu(idu);
                    gas.setDescripcion(descripcion);
                    gas.setMonto_gastado(monto);
                    GastosDAO dao = new GastosDAOImpl();                    
                    try {
                        // Nuevo registro
                        dao.insert(gas);
                    } catch (Exception ex) {
                        System.out.println("Error al insertar "+ex.getMessage());
                    }
                    break;
                }           
        }
        response.sendRedirect("ComunControlador");
    }
}
