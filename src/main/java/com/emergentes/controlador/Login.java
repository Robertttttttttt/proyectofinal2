package com.emergentes.controlador;

import com.emergentes.utiles.Validate;
import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOImpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Usuarios usu = new Usuarios();
        UsuariosDAO dao = new UsuariosDAOImpl();                
        
        System.out.println("Datos: \n Usuario: " +email+"\n Coontraseña: "+password);
        
        Validate v = new Validate();
        
        try{
            usu =  dao.Admin(email, password);             
        }catch(Exception ex) {
            System.out.println("Error al obtener el nivel de la persona"+ex.getMessage());
        }      
        
        if(v.checkUser(email, password)){
            System.out.println("Ok");
            HttpSession ses = request.getSession();
            ses.setAttribute("login","OK");
            ses.setAttribute("cargo", usu.getNivel());            
            ses.setAttribute("idusuario", Integer.toString(usu.getIdu()));
            request.setAttribute("idu",Integer.toString(usu.getIdu()));
            
            switch (usu.getNivel()) {
                case "Administrador":                    
                    response.sendRedirect("UsuarioControlador");
                    break;
                case "Visitante":                    
                    response.sendRedirect("ComunControlador?action=only-view");
                    break;
                case "Usuario":                    
                    response.sendRedirect("ComunControlador");
                    break;                                      
            }            
        } else{
            System.out.println("Incorrecto");
            response.sendRedirect("login.jsp");
        }
    }  
}
