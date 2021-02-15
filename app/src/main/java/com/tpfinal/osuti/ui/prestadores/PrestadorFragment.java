package com.tpfinal.osuti.ui.prestadores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;

public class PrestadorFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView mRecyclerView;
    private static final String[] myDataSet = {
            "PHP",
            "Javascript",
            "Go",
            "Python"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_prestadores, container, false);

        // Add the following lines to create RecyclerView
        mRecyclerView = root.findViewById(R.id.prestador_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        mRecyclerView.setAdapter(new PrestadorAdapter(myDataSet));

        return root;
    }
}
