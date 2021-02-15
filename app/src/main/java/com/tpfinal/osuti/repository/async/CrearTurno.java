package com.tpfinal.osuti.repository.async;

import android.os.AsyncTask;

import com.tpfinal.osuti.dao.TurnoDao;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.repository.callback.OnTurnoResultCallback;

public class CrearTurno extends AsyncTask<Turno, Void, Long> {
    private TurnoDao mTurnoDao;
    private OnTurnoResultCallback mCallback;

    public CrearTurno(TurnoDao turnoDao, OnTurnoResultCallback callback) {
        this.mTurnoDao = turnoDao;
        this.mCallback = callback;
    }

    @Override
    protected Long doInBackground(Turno... turnos) {
        return mTurnoDao.insert(turnos[0]);
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        mCallback.onResultInsert(aLong);
    }
}
