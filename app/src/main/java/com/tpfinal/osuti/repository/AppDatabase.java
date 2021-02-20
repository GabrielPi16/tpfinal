package com.tpfinal.osuti.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tpfinal.osuti.dao.ConsultorioDao;
import com.tpfinal.osuti.dao.PrestadorDao;
import com.tpfinal.osuti.dao.TurnoDao;
import com.tpfinal.osuti.dao.UsuarioDao;
import com.tpfinal.osuti.models.Consultorio;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.models.Usuario;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, Prestador.class, Turno.class, Consultorio.class}, version = 14, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();
    public abstract PrestadorDao prestadorDao();
    public abstract TurnoDao turnoDao();
    public abstract ConsultorioDao consultorioDao();

    private static volatile AppDatabase INSTANCE;
    static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(1);

    static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class,"db_osuti")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
