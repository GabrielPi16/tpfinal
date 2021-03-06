package com.tpfinal.osuti.repository.callback;

import android.view.View;

import com.tpfinal.osuti.models.Prestador;

import java.util.List;

public interface OnPrestadorResultCallback {
    void onResultInsert(Long prestador_id);
    void onResultSearch(List<Prestador> prestadores);
    void onResultSearchId(Prestador prestador);
}
