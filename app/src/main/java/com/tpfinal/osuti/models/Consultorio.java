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

        consultorios.add(new Consultorio((long) 1,"Sanatorio Santa Fe", "Belgrano 3021", "Santa Fe", "Santa Fe", "-31.64149917120655, -60.700372162917716"));
        consultorios.add(new Consultorio((long) 2,"Sanatorio Garay", "Rivadavia 3130", "Santa Fe", "Santa Fe", "-31.640291200644462, -60.70225612064143"));
        consultorios.add(new Consultorio((long) 3,"Hospital Jose Maria Cuyen", "Av. Gdor. Freyre 2138", "Santa Fe", "Santa Fe", "-31.648314702376766, -60.71884893690456"));
        consultorios.add(new Consultorio((long) 4,"Sanatorio San Geronimo", "Santiago del Estero 2750", "Santa Fe", "Santa Fe", "-31.63729916044289, -60.70589865778238"));
        consultorios.add(new Consultorio((long) 5,"Sanatorio Diagnostico", "25 de Mayo 3240", "Santa Fe", "Santa Fe", "-31.6387357750325, -60.70341425107057"));
        consultorios.add(new Consultorio((long) 6,"Sanatorio Mayo", "Suipacha 2453", "Santa Fe", "Santa Fe", "-31.640474500471992, -60.70326593297864"));

        return consultorios;
    }
}
