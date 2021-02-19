package com.tpfinal.osuti.ui.turnos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnosFragment extends Fragment {

    private TurnosViewModel mTurnosViewModel;
    private List<Turno> mListTurnos;
    private TurnosAdapter mListAdapter;
    private OnListFragmentInteractionListener mListener;

    public void setListData(List<Turno> dataItemList) {
        //if data changed, set new list to adapter of recyclerview

        if (mListTurnos == null) {
            mListTurnos = new ArrayList<>();
        }
        mListTurnos.clear();
        mListTurnos.addAll(dataItemList);

        if (mListAdapter != null) {
            mListAdapter.setListTurnos(dataItemList);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turnos, container, false);
        Context context = view.getContext();
        //set recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.turno_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mListAdapter = new TurnosAdapter(mListener);

        if (mListTurnos != null) {
            mListAdapter.setListTurnos(mListTurnos);
        }

        recyclerView.setAdapter(mListAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //get viewmodel
        mTurnosViewModel = ViewModelProviders.of(this).get(TurnosViewModel.class);
        //bind to Livedata
        mTurnosViewModel.getAllTurnos().observe(getViewLifecycleOwner(), new Observer<List<Turno>>() {
            @Override
            public void onChanged(@Nullable List<Turno> dataItems) {
                if (dataItems != null) {
                    setListData(dataItems);
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        //onClick items of list
        void onListClickItem(Turno turno);

        //onClick delete item from list
        void onListFragmentDeleteItemById(long idItem);
    }
}