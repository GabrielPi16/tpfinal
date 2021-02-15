package com.tpfinal.osuti.ui.prestadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;

public class PrestadorAdapter extends RecyclerView.Adapter<PrestadorViewModel> {
    private String[] mDataSet;

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public PrestadorAdapter(String[] myDataSet) {
        mDataSet = myDataSet;
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
        holder.getCardView().setTransitionName(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
