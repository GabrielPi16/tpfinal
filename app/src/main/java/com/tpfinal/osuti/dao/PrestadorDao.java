package com.tpfinal.osuti.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;

import java.util.List;

@Dao
public interface PrestadorDao {
    @Insert
    Long insert(Prestador prestador);

    @Delete
    void delete(Prestador prestador);

    @Update
    void update(Prestador prestador);

    @Query("SELECT * FROM prestador WHERE id = :id LIMIT 1")
    Prestador search(Long id);

    @Query("SELECT * FROM prestador")
    List<Prestador> searchAll();

    @Query("SELECT * FROM prestador WHERE razon_social = :name LIMIT 1")
    Prestador searchForName(String name);

    @Query("SELECT * FROM prestador WHERE especialidad = :especialidad")
    List<Prestador> searchForEspecialidad(String especialidad);

    //Get all items
    @Query("SELECT * FROM prestador")
    LiveData<List<Prestador>> getAllPrestadores();
}
