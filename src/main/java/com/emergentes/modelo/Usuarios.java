package com.emergentes.modelo;

public class Usuarios 
{
    private int idu;
    private String nombre;
    private String apellido;
    private int CI;    
    private String telefono;
    private String celular;
    private String correo;
    private String password;
    private String nivel;

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Usuarios() {
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idu=" + idu + ", nombre=" + nombre + ", apellido=" + apellido + ", CI=" + CI + ", telefono=" + telefono + ", celular=" + celular + ", correo=" + correo + ", password=" + password + ", nivel=" + nivel + '}';
    }
 
}
