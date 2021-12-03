package com.emergentes.dao;

import com.emergentes.modelo.Ingresos;
import java.util.List;

public interface IngresosDAO {
    public void insert(Ingresos ingresos) throws Exception;
    public void update(Ingresos ingresos) throws Exception;
    public void delete(int id) throws Exception;
    public Ingresos getById(int id) throws Exception;
    public List<Ingresos> getByIdu(int idu) throws Exception;
    public List<Ingresos> getAll() throws Exception;
    public Ingresos IngresosTotales() throws Exception;
}
