package com.tpfinal.osuti.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tpfinal.osuti.models.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Insert
    Long insert(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Query("SELECT * FROM usuario WHERE id = :id LIMIT 1")
    Usuario search(Long id);

    @Query("SELECT * FROM usuario")
    List<Usuario> searchAll();

    @Query("SELECT * FROM usuario WHERE mail = :mail AND password = :pass")
    Usuario searchUser(String mail, String pass);
}
