package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.UsuarioDao;
import com.tpfinal.osuti.models.Usuario;
import com.tpfinal.osuti.repository.callback.OnUsuarioResultCallback;

public class CrearUsuario extends AsyncTask<Usuario, Void, Long> {

    private UsuarioDao mUsuarioDao;
    private OnUsuarioResultCallback mCallback;

    public CrearUsuario(UsuarioDao usuarioDao, OnUsuarioResultCallback callback) {
        this.mUsuarioDao = usuarioDao;
        this.mCallback = callback;
    }

    @Override
    protected Long doInBackground(Usuario... usuarios) {
        Long id = mUsuarioDao.insert(usuarios[0]);
        return id;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        mCallback.onResultInsert(aLong);
    }
}
