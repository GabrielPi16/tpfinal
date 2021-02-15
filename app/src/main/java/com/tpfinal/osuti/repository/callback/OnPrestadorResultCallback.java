package com.tpfinal.osuti.repository.callback;

import com.tpfinal.osuti.models.Prestador;

import java.util.List;

public interface OnPrestadorResultCallback {
    void onResultInsert(Long prestador_id);
    List<Prestador> onResultSearch(List<Prestador> prestadores);
}
