package com.emergentes.modelo;


public class Gastos {
    private int idg;
    private int idu;
    private String fecha;
    private String hora;
    private String descripcion;
    private float monto_gastado;

    public int getIdg() {
        return idg;
    }

    public void setIdg(int idg) {
        this.idg = idg;
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

    public float getMonto_gastado() {
        return monto_gastado;
    }

    public void setMonto_gastado(float monto_gastado) {
        this.monto_gastado = monto_gastado;
    }

    public Gastos() {
    }

    @Override
    public String toString() {
        return "Gastos{" + "idg=" + idg + ", idu=" + idu + ", fecha=" + fecha + ", hora=" + hora + ", descripcion=" + descripcion + ", monto_gastado=" + monto_gastado + '}';
    }
  
}
