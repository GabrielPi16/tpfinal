package com.tpfinal.osuti.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

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

    @Ignore
    public Usuario(Long id, String nombre, String apellido, String obraSocial, Integer nroAfiliado, String mail, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.obraSocial = obraSocial;
        this.nroAfiliado = nroAfiliado;
        this.mail = mail;
        this.password = password;
    }

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

    /* Lista de prestadores de servicios para crear la base de datos */
    public static List<Usuario> getListaUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        usuarios.add(new Usuario((long) 1, "Gabriel", "Piedrabuena", "OSUTI", 754125, "gabriel@gmail.com", "123456789"  ));
        usuarios.add(new Usuario((long) 2, "Lucia", "Leites", "OSUTI", 154830, "lula.leites@gmail.com", "123456789"  ));
        usuarios.add(new Usuario((long) 3, "Federico", "Gauchat", "OSUTI", 458211, "fede@gmail.com", "123456789"  ));
        usuarios.add(new Usuario((long) 4, "Rodrigo", "Castillo", "OSUTI", 484111, "castillo@gmail.com", "123456789"  ));

        return usuarios;
    }
}
