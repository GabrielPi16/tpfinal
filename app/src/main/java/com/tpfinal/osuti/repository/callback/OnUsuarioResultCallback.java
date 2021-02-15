package com.tpfinal.osuti.repository.callback;

import com.tpfinal.osuti.models.Usuario;

import java.util.List;

public interface OnUsuarioResultCallback {
    void onResultInsert(Long usuarios);
    List<Usuario> onResultSearch(List<Usuario> usuarios);

}
