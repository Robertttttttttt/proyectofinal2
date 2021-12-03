package com.emergentes.dao;

import com.emergentes.modelo.Gastos;
import com.emergentes.modelo.Ingresos;
import com.emergentes.modelo.Montos_Totales;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TotalesDAOImpl extends ConexionDB implements TotalesDAO{

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

    @Override
    public Ingresos IngresosTotalesById(int id) throws Exception {        
        Ingresos ing = new Ingresos();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT TRUNCATE(SUM(monto_ingreso), 2) as monto_ingreso FROM ingresos WHERE idu = ?");
            ps.setInt(1,id);
            
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

    @Override
    public Gastos GastosTotalesById(int id) throws Exception {
        Gastos gas = new Gastos();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT TRUNCATE(SUM(monto_gastado), 2) as monto_gastado FROM gastos WHERE idu = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();            

            if (rs.next()){
                gas.setMonto_gastado(rs.getFloat("monto_gastado"));           
            }            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return gas;
    }   

    @Override
    public Montos_Totales MontosTotalesByIdu(int idu) throws Exception {
        Montos_Totales mon = new Montos_Totales();
        PreparedStatement ps;
        ResultSet rs;
        try {
            this.conectar();
/*
            PreparedStatement ps = this.conn.prepareStatement("SELECT truncate(sum(gastos.monto_gastado),2) as suma_gasto ,truncate(sum(ingresos.monto_ingreso),2) as suma_ingreso " +
                                    "FROM usuarios INNER JOIN gastos ON usuarios.idu = gastos.idu INNER JOIN ingresos ON usuarios.idu = ingresos.idu where usuarios.idu = ?");
            */

            ps = this.conn.prepareStatement("SELECT TRUNCATE(SUM(monto_gastado), 2) as monto_gastado FROM gastos WHERE idu = ?; SELECT TRUNCATE(SUM(monto_ingreso), 2) as monto_ingreso FROM ingresos WHERE idu = ?;");            
            ps.setInt(1,idu);
            ps.setInt(2,idu);
            
            rs = ps.executeQuery();            

            if (rs.next()){
                mon.setMonto_gastado(rs.getFloat("monto_gastado"));
                mon.setMonto_ingreso(rs.getFloat("monto_ingreso"));
            }        
            
            //ps = this.conn.prepareStatement("SELECT TRUNCATE(SUM(monto_ingreso), 2) as monto_ingreso FROM ingresos WHERE idu = ?;");            
            /*
            ps.setInt(1,idu);
            
            rs = ps.executeQuery();            

            if (rs.next()){
                mon.setMonto_ingreso(rs.getFloat("monto_ingreso"));
            }   */                                             
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return mon;
    }
}
