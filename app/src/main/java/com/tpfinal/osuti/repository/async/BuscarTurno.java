package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.TurnoDao;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.repository.callback.OnTurnoResultCallback;

import java.util.List;

public class BuscarTurno extends AsyncTask<Void, Void, List<Turno>> {
    private TurnoDao mTurnoDao;
    private OnTurnoResultCallback mCallback;

    public BuscarTurno(TurnoDao turnoDao, OnTurnoResultCallback callback) {
        mTurnoDao = turnoDao;
        mCallback = callback;
    }

    @Override
    protected List<Turno> doInBackground(Void... voids) {
        return mTurnoDao.searchAll();
    }

    @Override
    protected void onPostExecute(List<Turno> turnos) {
        super.onPostExecute(turnos);
        mCallback.onResultSearch(turnos);
    }
}
