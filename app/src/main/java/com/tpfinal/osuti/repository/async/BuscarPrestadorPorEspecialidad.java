package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.PrestadorDao;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;

import java.util.List;

public class BuscarPrestadorPorEspecialidad extends AsyncTask<String, Void, List<Prestador>> {
    private PrestadorDao mPrestadorDao;
    private OnPrestadorResultCallback mCallback;

    public BuscarPrestadorPorEspecialidad(PrestadorDao prestadorDao, OnPrestadorResultCallback callback) {
        mPrestadorDao = prestadorDao;
        mCallback = callback;
    }

    @Override
    protected List<Prestador> doInBackground(String... strings) {
        return mPrestadorDao.searchForEspecialidad(strings[0]);
    }

    @Override
    protected void onPostExecute(List<Prestador> prestadors) {
        super.onPostExecute(prestadors);
        mCallback.onResultSearch(prestadors);
    }
}
