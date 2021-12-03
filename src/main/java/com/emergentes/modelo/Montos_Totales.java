package com.emergentes.modelo;

public class Montos_Totales {
    private float monto_ingreso;
    private float monto_gastado; 

    public float getMonto_ingreso() {
        return monto_ingreso;
    }

    public void setMonto_ingreso(float monto_ingreso) {
        this.monto_ingreso = monto_ingreso;
    }

    public float getMonto_gastado() {
        return monto_gastado;
    }

    public void setMonto_gastado(float monto_gastado) {
        this.monto_gastado = monto_gastado;
    }

    @Override
    public String toString() {
        return "Montos_Totales{" + "monto_ingreso=" + monto_ingreso + ", monto_gastado=" + monto_gastado + '}';
    }

    public Montos_Totales() {
    }
    
}
