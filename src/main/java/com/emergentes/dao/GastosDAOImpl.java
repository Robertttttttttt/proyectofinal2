package com.emergentes.dao;

import com.emergentes.modelo.Gastos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GastosDAOImpl extends ConexionDB implements GastosDAO{

    @Override
    public void insert(Gastos gastos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO gastos (fecha, hora, idu, monto_gastado, descripcion) values (CURDATE(), curTime(), ?, ?, ?)");
            ps.setInt(1, gastos.getIdu());
            ps.setFloat(2, gastos.getMonto_gastado());
            ps.setString(3, gastos.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Gastos gastos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE gastos SET fecha = CURDATE(), hora = curTime(), monto_gastado = ?, descripcion = ? where idg = ? and idu = ?");            
            ps.setFloat(1, gastos.getMonto_gastado());
            ps.setString(2, gastos.getDescripcion());
            ps.setInt(3, gastos.getIdg());
            ps.setInt(4, gastos.getIdu());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM gastos WHERE idg = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Gastos getById(int id) throws Exception {
        Gastos gas = new Gastos();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM gastos WHERE idg = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                gas.setIdg(rs.getInt("idg"));
                gas.setIdu(rs.getInt("idu"));
                gas.setFecha(rs.getString("fecha"));
                gas.setHora(rs.getString("hora"));
                gas.setMonto_gastado(rs.getFloat("monto_gastado"));
                gas.setDescripcion(rs.getString("descripcion"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return gas;
    }

    @Override
    public List<Gastos> getAll() throws Exception {
        List<Gastos> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM gastos");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Gastos>();
            while (rs.next()){
                Gastos gas =  new Gastos();
                
                gas.setIdg(rs.getInt("idg"));
                gas.setIdu(rs.getInt("idu"));
                gas.setFecha(rs.getString("fecha"));
                gas.setHora(rs.getString("hora"));
                gas.setMonto_gastado(rs.getFloat("monto_gastado"));
                gas.setDescripcion(rs.getString("descripcion"));
                
                lista.add(gas);
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
    public List<Gastos> getByIdu(int idu) throws Exception {
        List<Gastos> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM gastos WHERE idu = ?");
            ps.setInt(1,idu);
            
            ResultSet rs = ps.executeQuery();            
            lista = new ArrayList<Gastos>();
            while (rs.next()){
                Gastos gas =  new Gastos();
                
                gas.setIdg(rs.getInt("idg"));
                gas.setIdu(rs.getInt("idu"));
                gas.setFecha(rs.getString("fecha"));
                gas.setHora(rs.getString("hora"));
                gas.setMonto_gastado(rs.getFloat("monto_gastado"));
                gas.setDescripcion(rs.getString("descripcion"));
                
                lista.add(gas);
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
    public Gastos GastosTotales() throws Exception {
        Gastos gas = new Gastos();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT TRUNCATE(SUM(monto_gastado), 2) as monto_gastado FROM gastos");
            
            ResultSet rs = ps.executeQuery();            
            if (rs.next()) {
                gas.setMonto_gastado(rs.getFloat("monto_gastado"));      
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return gas;
    }
}
