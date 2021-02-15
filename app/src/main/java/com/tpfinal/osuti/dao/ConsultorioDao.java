package com.tpfinal.osuti.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tpfinal.osuti.models.Consultorio;

import java.util.List;

@Dao
public interface ConsultorioDao {
    @Insert
    Long insert(Consultorio consultorio);

    @Delete
    void delete(Consultorio consultorio);

    @Update
    void update(Consultorio consultorio);

    @Query("SELECT * FROM consultorio WHERE id = :id LIMIT 1")
    Consultorio search(Long id);

    @Query("SELECT * FROM consultorio")
    List<Consultorio> searchAll();

}
