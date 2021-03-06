package com.tpfinal.osuti.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tpfinal.osuti.dao.ConsultorioDao;
import com.tpfinal.osuti.dao.PrestadorDao;
import com.tpfinal.osuti.dao.TurnoDao;
import com.tpfinal.osuti.dao.UsuarioDao;
import com.tpfinal.osuti.models.Consultorio;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.models.Usuario;
import com.tpfinal.osuti.repository.async.BuscarConsultorio;
import com.tpfinal.osuti.repository.async.BuscarPrestador;
import com.tpfinal.osuti.repository.async.BuscarPrestadorId;
import com.tpfinal.osuti.repository.async.BuscarPrestadorPorEspecialidad;
import com.tpfinal.osuti.repository.async.BuscarTurno;
import com.tpfinal.osuti.repository.async.CrearConsultorio;
import com.tpfinal.osuti.repository.callback.OnConsultorioResultCallback;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;
import com.tpfinal.osuti.repository.callback.OnTurnoResultCallback;
import com.tpfinal.osuti.repository.callback.OnUsuarioResultCallback;
import com.tpfinal.osuti.repository.async.CrearPrestador;
import com.tpfinal.osuti.repository.async.CrearTurno;
import com.tpfinal.osuti.repository.async.CrearUsuario;

import java.util.List;

public class AppRepository {
    private UsuarioDao mUsuarioDao;
    private PrestadorDao mPrestadorDao;
    private TurnoDao mTurnoDao;
    private ConsultorioDao mConsultorioDao;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        mUsuarioDao = db.usuarioDao();
        mPrestadorDao = db.prestadorDao();
        mTurnoDao = db.turnoDao();
        mConsultorioDao = db.consultorioDao();
    }

    /* Inserts */
    public void insertPrestador(final Prestador prestador, OnPrestadorResultCallback callback) {
        new CrearPrestador(mPrestadorDao, callback).execute(prestador);
    }

    public void insertarConsultorio(final Consultorio consultorio, OnConsultorioResultCallback callback) {
        new CrearConsultorio(mConsultorioDao, callback).execute(consultorio);
    }

    public void insertTurno(final Turno turno, OnTurnoResultCallback callback) {
        new CrearTurno(mTurnoDao, callback).execute(turno);
    }

    public void insertarUsuario(final Usuario usuario, OnUsuarioResultCallback callback){
        new CrearUsuario(mUsuarioDao,callback).execute(usuario);
    }

    /* Updates */
    public void updateUsuario(final Usuario usuario) {
        AppDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mUsuarioDao.update(usuario);
            }
        });
    }

    public void updatePrestador(final Prestador prestador) {
        AppDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mPrestadorDao.update(prestador);
            }
        });
    }

    /* Deletes */
    public void deleteTurno(final Turno turno) {
        AppDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTurnoDao.delete(turno);
            }
        });
    }

    public void deleteTurnoById(Long turno_id) {
        AppDatabase.dataBaseWriteExecutor.execute(new Runnable() {
              @Override
              public void run() {
                  mTurnoDao.deleteById(turno_id);
              }
        });
    }

    /* Search's */
    public void buscarPrestador(Long prestador_id, OnPrestadorResultCallback callback) {
        new BuscarPrestadorId(mPrestadorDao, callback).execute(prestador_id);
    }

    public Prestador buscarPrestadorName(String name) {
        AppDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mPrestadorDao.searchForName(name);
            }
        });
        return null;
    }

    public void buscarConsultorio(Long consultorio_id, OnConsultorioResultCallback callback) {
        new BuscarConsultorio(mConsultorioDao, callback).execute(consultorio_id);
    }

    public void buscarTodosPrestadores(OnPrestadorResultCallback callback) {
        new BuscarPrestador(mPrestadorDao, callback).execute();
    }

    public void buscarPrestadoresPorEspecialidad(String especialidad, OnPrestadorResultCallback callback) {
        new BuscarPrestadorPorEspecialidad(mPrestadorDao, callback).execute(especialidad);
    }

    public void buscarTurno(Long turno_id){
        AppDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTurnoDao.search(turno_id);
            }
        });
    }

    public void buscarTodosTurnos(OnTurnoResultCallback callback) {
        new BuscarTurno(mTurnoDao, callback).execute();
    }

    public Usuario buscarUsuario(String user, String password ) {
        return mUsuarioDao.searchUser(user, password);
    }

    public LiveData<List<Turno>> getAllTurnos() {
        return mTurnoDao.getAllTurnos();
    }
    public LiveData<List<Prestador>> getAllPrestadores() {
        return mPrestadorDao.getAllPrestadores();
    }
}
