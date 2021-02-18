package com.tpfinal.osuti.models;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity (
    foreignKeys = {
        @ForeignKey (
            entity = Consultorio.class,
            parentColumns = "id",
            childColumns = "consultorio_id"
        )
    }
)
public class Prestador {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String razon_social;
    private String matricula;
    private String especialidad;

    @ColumnInfo(index = true)
    @NonNull
    private Long consultorio_id;

    /* Contructor */
    public Prestador() {}

    @Ignore
    public Prestador(Long id, String razon_social, String matricula, String especialidad, @NonNull Long consultorio_id) {
        this.id = id;
        this.razon_social = razon_social;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.consultorio_id = consultorio_id;
    }

    /* Getters */

    public Long getId() { return id; }
    public String getRazon_social() { return razon_social; }
    public String getMatricula() { return matricula; }
    public String getEspecialidad() { return especialidad; }
    @NonNull
    public Long getConsultorio_id() { return consultorio_id; }

    /* Setters */
    public void setId(Long id) { this.id = id; }
    public void setRazon_social(String razon_social) { this.razon_social = razon_social; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setConsultorio_id(@NonNull Long consultorio_id) { this.consultorio_id = consultorio_id; }

    /* Lista de prestadores de servicios para crear la base de datos */
    public static List<Prestador> getListaProfecionales() {
        List<Prestador> profecionales = new ArrayList<Prestador>();

        profecionales.add(new Prestador((long) 1,"Juan Bautista", "123412", "Clinico/Generalista", (long) 1));
        profecionales.add(new Prestador((long) 2,"Marcos Esqueche", "231242", "Clinico/Generalista", (long)2));
        profecionales.add(new Prestador((long) 3,"Andrea Sanchez", "234335", "Clinico/Generalista", (long) 5));
        profecionales.add(new Prestador((long) 4,"Mauricio Loen", "315435", "Odontologia", (long) 2));
        profecionales.add(new Prestador((long) 5,"Carmen Mercos", "238131", "Traumatologia", (long) 1));
        profecionales.add(new Prestador((long) 6,"Maria Luciana Kim", "123567", "Traumatologia", (long) 4));
        profecionales.add(new Prestador((long) 7,"Miguel Alverez", "457377", "Urologia", (long) 4));
        profecionales.add(new Prestador((long) 8,"Antonia Gon", "457832", "Ginecologia", (long) 6));
        profecionales.add(new Prestador((long) 9,"Micaela Nerto", "884323", "Neurologia", (long) 6));
        profecionales.add(new Prestador((long) 10,"Lorna Nuria", "234623", "Bioquimica", (long) 6));
        profecionales.add(new Prestador((long) 11,"Diego Velez", "876442", "Bioquimica", (long) 1));
        profecionales.add(new Prestador((long) 12,"Juan Carlos Villa", "558894", "Cirugía General", (long) 2));
        profecionales.add(new Prestador((long) 13,"Mariana Lupus", "446245", "Gastroenterologia", (long) 3));
        profecionales.add(new Prestador((long) 14,"Amadeo Diex", "886434", "Odontologia", (long) 3));
        profecionales.add(new Prestador((long) 15,"Amanda Liniez", "408774", "Cardiologia", (long) 5));

        return profecionales;
    }

}
