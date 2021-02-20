package com.tpfinal.osuti.models;

public class Afiliado {
    private String nombre;
    private String apellido;
    private Integer DNI;
    private String fechaNac;
    private String email;

    public Afiliado() {
    }

    public Afiliado(String nombre, String apellido, Integer DNI, String fechaNac, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaNac = fechaNac;
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }
    public Integer getDNI() {
        return DNI;
    }
    public String getFechaNac() {
        return fechaNac;
    }
    public String getEmail() {
        return email;
    }
    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
