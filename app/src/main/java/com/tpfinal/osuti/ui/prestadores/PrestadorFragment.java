package com.tpfinal.osuti.ui.prestadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.MapsActivity;
import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.ui.turnos.TurnosAdapter;
import com.tpfinal.osuti.ui.turnos.TurnosViewModel;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class PrestadorFragment extends Fragment {

    private PrestadorViewModel mPrestadorViewModel;
    private List<Prestador> mListPrestadores;
    private PrestadorAdapter mListAdapter;
    private String mEspecialidad = null;

    public void setListData(List<Prestador> dataItemList) {
        //if data changed, set new list to adapter of recyclerview
        if (mListPrestadores == null) {
            mListPrestadores = new ArrayList<>();
        }
        mListPrestadores.clear();
        mListPrestadores.addAll(dataItemList);

        if (mListAdapter != null) {
            mListAdapter.setListPrestadores(dataItemList, getActivity().getApplication());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prestadores, container, false);
        Context context = view.getContext();
        //set recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.prestador_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mListAdapter = new PrestadorAdapter();

        if (mListPrestadores != null) {
            mListAdapter.setListPrestadores(mListPrestadores, context);
        }

        recyclerView.setAdapter(mListAdapter);


        AutoCompleteTextView autoEspecialidad = (AutoCompleteTextView) view.findViewById(R.id.fgPrestador_autocomplete);
        String[] especialidades = {"Clinico/Generalista", "Traumatologia", "Ginecologia", "Urologia", "Neurologia",
                "Alergia e Inmunologia", "Bioquimica", "Cardiologia", "Cirugía General", "Gastroenterologia",
                "Infectologia", "Odontologia" };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, especialidades);

        autoEspecialidad.setThreshold(1);
        autoEspecialidad.setAdapter(adapter1);

        //Aqui se toma el item seleccionado en el combo
        autoEspecialidad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mEspecialidad = String.format("%s", parent.getItemAtPosition(position));
                Log.d("PRESTADOR.ESPECIALIDAD", mEspecialidad);

                /* SETEO DE CAMPO DE PROFESIONALES */
                //mAppRepository.buscarPrestadoresPorEspecialidad(mEspecialidad, callback);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //get viewmodel
        mPrestadorViewModel = ViewModelProviders.of(this).get(PrestadorViewModel.class);
        //bind to Livedata
        mPrestadorViewModel.getAllPrestadores().observe(getViewLifecycleOwner(), new Observer<List<Prestador>>() {
            @Override
            public void onChanged(@Nullable List<Prestador> dataItems) {
                if (dataItems != null) {
                    setListData(dataItems);
                }
            }
        });
    }

    public void startActivityMaps() {
        Context mContext  = getActivity().getApplication();
        startActivity(new Intent(mContext, MapsActivity.class));
    }
}
