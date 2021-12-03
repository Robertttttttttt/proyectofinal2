package com.emergentes.modelo;
 
public class Ingresos
{
    private int idi;
    private int idu;
    private String fecha;
    private String hora;
    private String descripcion;
    private float monto_ingreso;

    public int getIdi() {
        return idi;
    }

    public void setIdi(int idi) {
        this.idi = idi;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getMonto_ingreso() {
        return monto_ingreso;
    }

    public void setMonto_ingreso(float monto_ingreso) {
        this.monto_ingreso = monto_ingreso;
    }

    public Ingresos() {
    }

    @Override
    public String toString() {
        return "Ingresos{" + "idi=" + idi + ", idu=" + idu + ", fecha=" + fecha + ", hora=" + hora + ", descripcion=" + descripcion + ", monto_ingreso=" + monto_ingreso + '}';
    }
      
}
