package com.tpfinal.osuti.repository.callback;

import com.tpfinal.osuti.models.Turno;

import java.util.List;

public interface OnTurnoResultCallback {
    void onResultInsert(Long turnos);
    List<Turno> onResultSearch(List<Turno> turnos);
}
