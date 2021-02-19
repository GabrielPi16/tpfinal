package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.ConsultorioDao;
import com.tpfinal.osuti.models.Consultorio;
import com.tpfinal.osuti.repository.callback.OnConsultorioResultCallback;

public class BuscarConsultorio extends AsyncTask<Long, Void, Consultorio> {
    private ConsultorioDao mConsultorioDao;
    private OnConsultorioResultCallback mCallback;

    public BuscarConsultorio(ConsultorioDao consultorioDao, OnConsultorioResultCallback callback) {
        mConsultorioDao = consultorioDao;
        mCallback = callback;
    }

    @Override
    protected Consultorio doInBackground(Long... longs) {
        return mConsultorioDao.search(longs[0]);
    }

    @Override
    protected void onPostExecute(Consultorio consultorio) {
        super.onPostExecute(consultorio);
        mCallback.onResultSearchConsultorio(consultorio);
    }
}
