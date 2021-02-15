package com.tpfinal.osuti.ui.turnos;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;

public class TurnosViewModel extends RecyclerView.ViewHolder {
    private CardView mCardView;

    public TurnosViewModel(@NonNull View itemView) {
        super(itemView);
        mCardView = itemView.findViewById(R.id.turno_cardView);
    }

    public CardView getCardView() { return mCardView; }
}