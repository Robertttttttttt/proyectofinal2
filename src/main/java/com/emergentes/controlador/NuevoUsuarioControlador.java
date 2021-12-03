package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOImpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NuevoUsuarioControlador", urlPatterns = {"/NuevoUsuarioControlador"})
public class NuevoUsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Usuarios usu = new Usuarios();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "add";
            System.out.println("Opcion = " + action);
            switch(action){
                case "add":
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("nuevo_usuario.jsp").forward(request, response);
                    break;
            }            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idu = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int ci =  Integer.parseInt(request.getParameter("ci"));
        String correo =  request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String celular = request.getParameter("celular");
        String nivel =  request.getParameter("nivel");
        String password =  request.getParameter("password");
        
        System.out.println("\n"+idu+"\n");
                       
        Usuarios usu = new Usuarios();
        
        usu.setIdu(idu);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setCI(ci);
        usu.setCorreo(correo);
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
        response.sendRedirect("login.jsp");
    }
}
