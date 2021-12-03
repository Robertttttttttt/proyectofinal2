package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOImpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Usuarios usu = new Usuarios();
            int idu;
            UsuariosDAO dao = new UsuariosDAOImpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = " + action);
            switch(action){
                case "add":
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmusuariosA.jsp").forward(request, response);
                    break;
                case "edit":
                    idu = Integer.parseInt(request.getParameter("idu"));
                    usu =  dao.getById(idu);
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmusuariosA.jsp").forward(request, response);
                    break;
                case "delete":
                    idu = Integer.parseInt(request.getParameter("idu"));
                    dao.delete(idu);
                    response.sendRedirect("UsuarioControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Usuarios> lista = dao.getAll();
                    request.setAttribute("usuario",lista);
                    //request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                    break;
            }            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idu = Integer.parseInt(request.getParameter("idu"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo =  request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String celular = request.getParameter("celular");
        String nivel =  request.getParameter("nivel");
        String password =  request.getParameter("password");
                       
        Usuarios usu = new Usuarios();
        
        usu.setIdu(idu);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setCorreo(correo);
        usu.setCI(ci);
        usu.setTelefono(telefono);
        usu.setCelular(celular);
        usu.setNivel(nivel);
        usu.setPassword(password);
              
        UsuariosDAO dao = new UsuariosDAOImpl();
        
        if (idu == 0){            
            try {
                // Nuevo registro
                dao.insert(usu);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }else{
            try {
                // Edicion de registro
                dao.update(usu);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
    }
}
