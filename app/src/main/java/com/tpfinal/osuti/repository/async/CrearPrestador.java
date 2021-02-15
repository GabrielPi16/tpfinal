package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.PrestadorDao;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;

public class CrearPrestador extends AsyncTask<Prestador, Void, Long> {
    private PrestadorDao mPrestadorDao;
    private OnPrestadorResultCallback mCallback;

    public CrearPrestador(PrestadorDao prestadorDao, OnPrestadorResultCallback callback) {
        mPrestadorDao = prestadorDao;
        mCallback = callback;
    }

    @Override
    protected Long doInBackground(Prestador... prestadores) {
        return mPrestadorDao.insert(prestadores[0]);
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        mCallback.onResultInsert(aLong);
    }
}
