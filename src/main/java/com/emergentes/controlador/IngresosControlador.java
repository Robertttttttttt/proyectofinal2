package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOImpl;
import com.emergentes.modelo.Usuarios;
import com.emergentes.dao.IngresosDAO;
import com.emergentes.dao.IngresosDAOImpl;
import com.emergentes.modelo.Ingresos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IngresosControlador", urlPatterns = {"/IngresosControlador"})
public class IngresosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Ingresos ingresos = new Ingresos();
            IngresosDAO dao = new IngresosDAOImpl();
            UsuariosDAO daoUsuarios = new UsuariosDAOImpl();
            int idi;
            List<Usuarios> lista_usuarios = null;            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = " + action);
            switch (action) {
                case "add":
                    lista_usuarios = daoUsuarios.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("ingresos", ingresos);
                    request.getRequestDispatcher("frmingresosA.jsp").forward(request, response);
                    break;
                case "edit":
                    idi = Integer.parseInt(request.getParameter("idi"));
                    ingresos = dao.getById(idi);
                    lista_usuarios = daoUsuarios.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("ingresos", ingresos);
                    request.getRequestDispatcher("frmingresosA.jsp").forward(request, response);
                    break;
                case "delete":
                    idi = Integer.parseInt(request.getParameter("idi"));
                    dao.delete(idi);
                    response.sendRedirect("IngresosControlador");
                    break;
                case "view":
                    List<Ingresos> lista = dao.getAll();
                    request.setAttribute("ingresos",lista);
                    request.getRequestDispatcher("ingresosA.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error fatal en Ingresos doGet " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idi = Integer.parseInt(request.getParameter("idi"));
        String descripcion = request.getParameter("descripcion");
        float monto = Float.parseFloat(request.getParameter("monto_ingreso"));
        int usuarios_id = Integer.parseInt(request.getParameter("idu"));
            
        Ingresos ing = new Ingresos();

        ing.setIdi(idi);
        ing.setDescripcion(descripcion);
        ing.setMonto_ingreso(monto);
        ing.setIdu(usuarios_id);
                 
        if(idi == 0){
            // Nuevo
            IngresosDAO dao = new IngresosDAOImpl();
            try {
                dao.insert(ing);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        } else{
            //Editar
            IngresosDAO dao = new IngresosDAOImpl();
            try {
                dao.update(ing);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }            
        }
        response.sendRedirect("IngresosControlador");
    }
 
}
