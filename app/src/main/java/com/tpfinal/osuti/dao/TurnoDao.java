package com.tpfinal.osuti.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tpfinal.osuti.models.Turno;

import java.util.List;

@Dao
public interface TurnoDao {
    @Insert
    Long insert(Turno turno);

    @Delete
    void delete(Turno turno);

    @Update
    void update(Turno turno);

    @Query("SELECT * FROM turno WHERE id = :id LIMIT 1")
    Turno search(Long id);

    @Query("SELECT * FROM turno")
    List<Turno> searchAll();

    //Get all items
    @Query("SELECT * FROM turno")
    LiveData<List<Turno>> getAllTurnos();
}
