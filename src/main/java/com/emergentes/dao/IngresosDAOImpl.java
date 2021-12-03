package com.emergentes.dao;

import com.emergentes.modelo.Ingresos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngresosDAOImpl extends ConexionDB implements IngresosDAO{

    @Override
    public void insert(Ingresos ingresos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ingresos (fecha, hora, idu, monto_ingreso, descripcion) values (CURDATE(), curTime(), ?, ?, ?)");
            ps.setInt(1, ingresos.getIdu());
            ps.setFloat(2, ingresos.getMonto_ingreso());
            ps.setString(3, ingresos.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Ingresos ingresos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE ingresos SET fecha = CURDATE(), hora = curTime(), monto_ingreso = ?, descripcion = ? where idi = ? and idu = ?");            
            ps.setFloat(1, ingresos.getMonto_ingreso());
            ps.setString(2, ingresos.getDescripcion());
            ps.setInt(3, ingresos.getIdi());
            ps.setInt(4, ingresos.getIdu());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM ingresos WHERE idi = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Ingresos getById(int id) throws Exception {
        Ingresos ing = new Ingresos();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ingresos WHERE idi = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                ing.setIdi(rs.getInt("idi"));
                ing.setIdu(rs.getInt("idu"));
                ing.setFecha(rs.getString("fecha"));
                ing.setHora(rs.getString("hora"));
                ing.setMonto_ingreso(rs.getFloat("monto_ingreso"));
                ing.setDescripcion(rs.getString("descripcion"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ing;
    }

    @Override
    public List<Ingresos> getAll() throws Exception {
        List<Ingresos> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ingresos");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Ingresos>();
            while (rs.next()){
                Ingresos ing =  new Ingresos();
                
                ing.setIdi(rs.getInt("idi"));
                ing.setIdu(rs.getInt("idu"));
                ing.setFecha(rs.getString("fecha"));
                ing.setHora(rs.getString("hora"));
                ing.setMonto_ingreso(rs.getFloat("monto_ingreso"));
                ing.setDescripcion(rs.getString("descripcion"));
                
                lista.add(ing);
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
    public List<Ingresos> getByIdu(int idu) throws Exception {
        List<Ingresos> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ingresos WHERE idu = ?");
            ps.setInt(1,idu);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Ingresos>();
            while (rs.next()){
                Ingresos ing =  new Ingresos();
                
                ing.setIdi(rs.getInt("idi"));
                ing.setIdu(rs.getInt("idu"));
                ing.setFecha(rs.getString("fecha"));
                ing.setHora(rs.getString("hora"));
                ing.setMonto_ingreso(rs.getFloat("monto_ingreso"));
                ing.setDescripcion(rs.getString("descripcion"));
                
                lista.add(ing);
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
    public Ingresos IngresosTotales() throws Exception {
        Ingresos ing = new Ingresos();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT TRUNCATE(SUM(monto_ingreso), 2) as monto_ingreso FROM ingresos");

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                ing.setMonto_ingreso(rs.getFloat("monto_ingreso"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ing;
    }   
}
