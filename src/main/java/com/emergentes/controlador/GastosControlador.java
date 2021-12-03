package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOImpl;
import com.emergentes.modelo.Usuarios;
import com.emergentes.dao.GastosDAO;
import com.emergentes.dao.GastosDAOImpl;
import com.emergentes.modelo.Gastos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "GastosControlador", urlPatterns = {"/GastosControlador"})
public class GastosControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            Gastos gas = new Gastos();  
            GastosDAO dao = new GastosDAOImpl();           
            UsuariosDAO daoUsuarios= new UsuariosDAOImpl();
            int idg;            
            List<Usuarios> lista_usuarios = null;                                             
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = "+ action);
            switch(action){
                case "add":
                    lista_usuarios = daoUsuarios.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("gastos",gas);
                    request.getRequestDispatcher("frmgastosA.jsp").forward(request, response);
                    break;   
                case "edit":
                    idg = Integer.parseInt(request.getParameter("idg"));
                    gas = dao.getById(idg);                     
                    lista_usuarios = daoUsuarios.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("gastos",gas);
                    request.getRequestDispatcher("frmgastosA.jsp").forward(request, response);
                    break;    
                case "delete":
                    idg = Integer.parseInt(request.getParameter("idg"));
                    dao.delete(idg);
                    response.sendRedirect("GastosControlador");
                    break;
                case "view":
                    List<Gastos> lista = dao.getAll();
                    request.setAttribute("gastos", lista);
                    request.getRequestDispatcher("gastosA.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error fatal en Gastos doGet " + ex.getMessage());
        }
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idg = Integer.parseInt(request.getParameter("idg"));
        int idu = Integer.parseInt(request.getParameter("idu"));
        String descripcion = request.getParameter("descripcion");
        float monto_gastado = Float.parseFloat(request.getParameter("monto_gasto"));
                                 
        Gastos gas = new Gastos();
        
        gas.setIdg(idg);
        gas.setIdu(idu);
        gas.setDescripcion(descripcion);
        gas.setMonto_gastado(monto_gastado);
                 
        GastosDAO dao = new GastosDAOImpl();
        if (idg == 0){
            try {
                // Nuevo registro
                dao.insert(gas);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                // Edicion de registro
                dao.update(gas);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("GastosControlador");
    }
}
