package com.tpfinal.osuti.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Consultorio {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String coordenadas;

    /* Contruct */
    public Consultorio() {}

    @Ignore
    public Consultorio(Long id, String nombre, String direccion, String ciudad, String provincia, String coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.coordenadas = coordenadas;
    }

    /* Getters */
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public String getProvincia() { return provincia; }
    public String getCoordenadas() { return coordenadas; }

    /* Setters */
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public void setCoordenadas(String coordenadas) { this.coordenadas = coordenadas; }

    /* Lista de prestadores de servicios para crear la base de datos */
    public static List<Consultorio> getListaConsltorios() {
        List<Consultorio> consultorios = new ArrayList<Consultorio>();

        consultorios.add(new Consultorio((long) 1,"Sanatorio Santa Fe", "Belgrano 3021", "Santa Fe", "Santa Fe", ""));
        consultorios.add(new Consultorio((long) 2,"Sanatorio Garay", "Rivadavia 3154", "Santa Fe", "Santa Fe", ""));
        consultorios.add(new Consultorio((long) 3,"Hospital Jose Maria Cuyen", "Av. Freyre 2012", "Santa Fe", "Santa Fe", ""));
        consultorios.add(new Consultorio((long) 4,"Sanatorio San Geronimo", "San Jeronimo 3571", "Santa Fe", "Santa Fe", ""));
        consultorios.add(new Consultorio((long) 5,"Sanatorio Diagnostico", "San Luis 2845", "Santa Fe", "Santa Fe", ""));
        consultorios.add(new Consultorio((long) 6,"Sanatorio Mayo", "Suipacha 2234", "Santa Fe", "Santa Fe", ""));

        return consultorios;
    }
}
