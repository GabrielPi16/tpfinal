package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.PrestadorDao;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;

public class BuscarPrestadorId extends AsyncTask<Long, Prestador, Prestador> {
    PrestadorDao mPrestadorDao;
    OnPrestadorResultCallback mCallback;

    public BuscarPrestadorId(PrestadorDao prestadorDao, OnPrestadorResultCallback callback) {
        mPrestadorDao = prestadorDao;
        mCallback = callback;
    }

    @Override
    protected Prestador doInBackground(Long... longs) {
        return mPrestadorDao.search(longs[0]);
    }

    @Override
    protected void onPostExecute(Prestador prestador) {
        super.onPostExecute(prestador);
        mCallback.onResultSearchId(prestador);
    }
}
