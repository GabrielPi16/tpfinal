package com.tpfinal.osuti.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;

@Entity (
    foreignKeys ={
        @ForeignKey(
            entity = Prestador.class,
            parentColumns = "id",
            childColumns = "prestador_id"
        )
    }
)
public class Turno {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name="prestador_id", index = true)
    @NonNull
    private Long prestador_id;

    private String fecha;
    private String hora;
    private String clinica;
    private String created;

    /* Construct */
    public Turno() {}

    @Ignore
    public Turno(@NonNull Long prestador_id, String fecha, String hora, String clinica, String created) {
        this.prestador_id = prestador_id;
        this.fecha = fecha;
        this.hora = hora;
        this.clinica = clinica;
        this.created = created;
    }

    /* Getters */

    public Long getId() { return id; }
    @NonNull
    public Long getPrestador_id() { return prestador_id; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getClinica() { return clinica; }
    public String getCreated() { return created; }

    /* Setters */
    public void setId(Long id) { this.id = id; }
    public void setPrestador_id(@NonNull Long prestador_id) { this.prestador_id = prestador_id; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHora(String hora) { this.hora = hora; }
    public void setClinica(String clinica) { this.clinica = clinica; }
    public void setCreated(String created) { this.created = created; }
}
