package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.ConsultorioDao;
import com.tpfinal.osuti.models.Consultorio;
import com.tpfinal.osuti.repository.callback.OnConsultorioResultCallback;

public class CrearConsultorio extends AsyncTask<Consultorio, Void, Long> {
    private ConsultorioDao mConsultorioDao;
    private OnConsultorioResultCallback mCallback;

    public CrearConsultorio(ConsultorioDao consultorioDao, OnConsultorioResultCallback callback) {
        mConsultorioDao = consultorioDao;
        mCallback = callback;
    }

    @Override
    protected Long doInBackground(Consultorio... consultorios) {
        return mConsultorioDao.insert(consultorios[0]);
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        mCallback.onResultInsert(aLong);
    }
}
