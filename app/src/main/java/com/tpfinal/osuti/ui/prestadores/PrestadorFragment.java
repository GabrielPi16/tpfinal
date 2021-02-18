package com.tpfinal.osuti.ui.prestadores;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.repository.AppRepository;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;

import java.util.List;

public class PrestadorFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView mRecyclerView;
    private View mRoot = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Application application = this.getActivity().getApplication();

        // Inflate the layout for this fragment
        mRoot = inflater.inflate(R.layout.fragment_prestadores, container, false);

        // Add the following lines to create RecyclerView
        mRecyclerView = mRoot.findViewById(R.id.prestador_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRoot.getContext()));
        mRecyclerView.setAdapter(new PrestadorAdapter(application));

        return mRoot;
    }
}
