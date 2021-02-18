package com.tpfinal.osuti.ui.prestadores;

import android.app.Application;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.repository.AppRepository;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;

import java.util.List;

public class PrestadorAdapter extends RecyclerView.Adapter<PrestadorViewModel> {
    private List<Prestador> mDataSet;

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public PrestadorAdapter(Application application) {
        AppRepository appRepository = new AppRepository(application);
        OnPrestadorResultCallback callback = new OnPrestadorResultCallback() {
            @Override
            public void onResultInsert(Long prestador_id) {}

            @Override
            public List<Prestador> onResultSearch(List<Prestador> prestadores) {
                mDataSet = prestadores;
                return prestadores;
            }

            @Override
            public Prestador onResultSearchId(Prestador prestador) {
                return null;
            }
        };
        appRepository.buscarTodosPrestadores(callback);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_prestadores;
    }

    @NonNull
    @Override
    public PrestadorViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new PrestadorViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrestadorViewModel holder, int position) {
        Prestador prestador = mDataSet.get(position);
        holder.getCardView().setTransitionName(prestador.getRazon_social());
        holder.getEspecialidad().setText(prestador.getEspecialidad());
        holder.getRazonSocial().setText(prestador.getRazon_social());
        holder.getMatricula().setText(prestador.getMatricula());
        holder.getConsultorio().setText(String.format("%d", prestador.getConsultorio_id()));


        Log.d("LISTADO DE PRESTADORES", String.format("%d %s", position, prestador.getRazon_social()));
    }

    @Override
    public int getItemCount() {
        return (mDataSet == null) ? 0 : mDataSet.size();
    }
}
