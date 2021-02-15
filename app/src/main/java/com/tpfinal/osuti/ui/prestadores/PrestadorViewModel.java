package com.tpfinal.osuti.ui.prestadores;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;

public class PrestadorViewModel extends RecyclerView.ViewHolder {
    private CardView mCardView;

    public PrestadorViewModel(@NonNull View itemView) {
        super(itemView);
        mCardView = itemView.findViewById(R.id.prestador_cardView);
    }

    public CardView getCardView() { return mCardView; }
}
