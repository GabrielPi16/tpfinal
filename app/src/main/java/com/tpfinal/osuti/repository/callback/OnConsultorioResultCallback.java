package com.tpfinal.osuti.repository.callback;

import com.tpfinal.osuti.models.Consultorio;

import java.util.List;

public interface OnConsultorioResultCallback {
    void onResultInsert(Long consultorio_id);
    void onResultSearch(List<Consultorio> consultorios);
    void onResultSearchConsultorio(Consultorio consultorio);

}
