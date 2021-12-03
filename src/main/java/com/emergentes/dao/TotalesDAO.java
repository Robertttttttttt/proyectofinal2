package com.emergentes.dao;

import com.emergentes.modelo.Gastos;
import com.emergentes.modelo.Ingresos;
import com.emergentes.modelo.Montos_Totales;

public interface TotalesDAO {    
    public Ingresos IngresosTotales() throws Exception;
    public Ingresos IngresosTotalesById(int id) throws Exception;
    public Gastos GastosTotales() throws Exception;
    public Gastos GastosTotalesById(int id) throws Exception;
    public Montos_Totales MontosTotalesByIdu(int idu) throws Exception;
}
