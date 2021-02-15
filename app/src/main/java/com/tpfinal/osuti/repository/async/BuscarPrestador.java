package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.PrestadorDao;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;

import java.util.List;

public class BuscarPrestador extends AsyncTask<Void, Void, List<Prestador>> {
    private PrestadorDao mPrestadorDao;
    private OnPrestadorResultCallback mCallback;

    public BuscarPrestador (PrestadorDao prestadorDao, OnPrestadorResultCallback callback) {
        mPrestadorDao = prestadorDao;
        mCallback = callback;
    }

    @Override
    protected List<Prestador> doInBackground(Void... voids) {
        return mPrestadorDao.searchAll();
    }

    @Override
    protected void onPostExecute(List<Prestador> prestadors) {
        super.onPostExecute(prestadors);
        mCallback.onResultSearch(prestadors);
    }
}
