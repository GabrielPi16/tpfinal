package com.tpfinal.osuti.ui.turnos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;

public class TurnosAdapter extends RecyclerView.Adapter<TurnosViewModel> {
    private String[] mDataSet;

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public TurnosAdapter(String[] myDataSet) {
        mDataSet = myDataSet;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_turnos;
    }

    @NonNull
    @Override
    public TurnosViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new TurnosViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TurnosViewModel holder, int position) {
        holder.getCardView().setTransitionName(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
