package com.tpfinal.osuti.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tpfinal.osuti.R;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        final EditText mTextNombre = root.findViewById(R.id.perfil_nombre);
        final EditText mTextApellido = root.findViewById(R.id.perfil_apellido);
        final EditText mTextNro = root.findViewById(R.id.perfil_nro);
        final EditText mTextMail = root.findViewById(R.id.perfil_mail);
        final EditText mTextPassw = root.findViewById(R.id.perfil_pass);

        perfilViewModel.getNombre().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { mTextNombre.setText(s); }
        });

        perfilViewModel.getApellido().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextApellido.setText(s);
            }
        });

        perfilViewModel.getNroAfiliado().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextNro.setText(s);
            }
        });

        perfilViewModel.getEmail().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextMail.setText(s);
            }
        });

        perfilViewModel.getPassword().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextPassw.setText(s);
            }
        });

        return root;
    }
}