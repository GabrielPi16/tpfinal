package com.tpfinal.osuti.ui.afiliaciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tpfinal.osuti.R;

public class AfiliacionFragment extends Fragment {

    private AfiliacionViewModel afiliacionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        afiliacionViewModel = new ViewModelProvider(this).get(AfiliacionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_afiliaciones, container, false);
        final TextView textView = root.findViewById(R.id.text_afiliacion);
        afiliacionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}