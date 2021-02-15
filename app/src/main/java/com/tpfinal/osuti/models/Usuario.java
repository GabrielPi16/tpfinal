package com.tpfinal.osuti.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String nombre;
    private String apellido;
    private String obraSocial;
    private Integer nroAfiliado;
    private String mail;
    private String password;

    /* Construct */
    public Usuario() {}

    /* Getters */

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getObraSocial() { return obraSocial; }
    public Integer getNroAfiliado() { return nroAfiliado; }
    public String getMail() { return mail; }
    public String getPassword() { return password; }

    /* Setters */
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setObraSocial(String obraSocial) { this.obraSocial = obraSocial; }
    public void setNroAfiliado(Integer nroAfiliado) { this.nroAfiliado = nroAfiliado; }
    public void setMail(String mail) { this.mail = mail; }
    public void setPassword(String password) { this.password = password; }
}
