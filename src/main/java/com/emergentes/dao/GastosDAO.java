package com.emergentes.dao;

import com.emergentes.modelo.Gastos;
import java.util.List;

public interface GastosDAO {
    public void insert(Gastos gastos) throws Exception; 
    public void update(Gastos gastos) throws Exception;
    public void delete(int id) throws Exception;
    public Gastos getById(int id) throws Exception;
    public List<Gastos> getByIdu(int idu) throws Exception;
    public List<Gastos> getAll() throws Exception;
    public Gastos GastosTotales() throws Exception;
}
