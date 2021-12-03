package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOImpl extends ConexionDB implements UsuariosDAO{

    @Override
    public void insert(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios (nombre, apellido, CI, telefono, celular, correo, password, nivel) values (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getApellido());
            ps.setInt(3, usuarios.getCI());
            ps.setString(4, usuarios.getTelefono());
            ps.setString(5, usuarios.getCelular());
            ps.setString(6, usuarios.getCorreo());
            ps.setString(7, usuarios.getPassword());
            ps.setString(8, usuarios.getNivel());            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET nombre = ?, apellido = ?, CI = ?, telefono = ?, celular = ?, correo = ?, password = ?, nivel = ? where idu = ?");
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getApellido());
            ps.setInt(3, usuarios.getCI());
            ps.setString(4, usuarios.getTelefono());
            ps.setString(5, usuarios.getCelular());
            ps.setString(6, usuarios.getCorreo());
            ps.setString(7, usuarios.getPassword());
            ps.setString(8, usuarios.getNivel());  
            ps.setInt(9, usuarios.getIdu());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios WHERE idu = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Usuarios getById(int id) throws Exception {
        Usuarios usu = new Usuarios();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE idu = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                usu.setIdu(rs.getInt("idu"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setCI(rs.getInt("CI"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setCelular(rs.getString("celular"));
                usu.setCorreo(rs.getString("correo"));
                usu.setPassword(rs.getString("password"));
                usu.setNivel(rs.getString("nivel"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return usu;
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Usuarios>();
            while (rs.next()){
                Usuarios usu =  new Usuarios();
                
                usu.setIdu(rs.getInt("idu"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setCI(rs.getInt("CI"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setCelular(rs.getString("celular"));
                usu.setCorreo(rs.getString("correo"));
                usu.setPassword(rs.getString("password"));
                usu.setNivel(rs.getString("nivel"));
                
                lista.add(usu);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Usuarios Admin(String Correo, String Password) throws Exception {
        Usuarios usu = new Usuarios();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT nivel, idu FROM usuarios WHERE correo = ? and password = ?");
            ps.setString(1,Correo);
            ps.setString(2,Password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                usu.setNivel(rs.getString("nivel"));
                usu.setIdu(rs.getInt("idu"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return usu;
    }

    @Override
    public List<Usuarios> getOne(int id) throws Exception {
        List<Usuarios> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE idu = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Usuarios>();
            while (rs.next()){
                Usuarios usu =  new Usuarios();
                
                usu.setIdu(rs.getInt("idu"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setCI(rs.getInt("CI"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setCelular(rs.getString("celular"));
                usu.setCorreo(rs.getString("correo"));
                usu.setPassword(rs.getString("password"));
                usu.setNivel(rs.getString("nivel"));
                
                lista.add(usu);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
