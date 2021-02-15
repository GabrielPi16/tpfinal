package com.tpfinal.osuti.ui.turnos;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.ui.prestadores.PrestadorAdapter;

public class TurnosFragment extends Fragment {

    private RecyclerView recyclerView;
    private static final String[] myDataSet = {
            "PHP",
            "Javascript",
            "Go",
            "Python"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_turnos, container, false);

        // Add the following lines to create RecyclerView
        recyclerView = root.findViewById(R.id.turno_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new TurnosAdapter(myDataSet));

        return root;
    }
}