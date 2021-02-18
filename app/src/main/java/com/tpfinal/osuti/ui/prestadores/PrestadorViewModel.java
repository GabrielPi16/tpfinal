package com.tpfinal.osuti.ui.prestadores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;

public class PrestadorViewModel extends RecyclerView.ViewHolder {
    private CardView mCardView;
    private TextView mRazonSocial;
    private TextView mEspecialidad;
    private TextView mConsultorio;
    private TextView mMatricula;

    public PrestadorViewModel(@NonNull View itemView) {
        super(itemView);
        mCardView = itemView.findViewById(R.id.prestador_cardView);
        mRazonSocial = itemView.findViewById(R.id.item_nombrePrestador);
        mEspecialidad = itemView.findViewById(R.id.item_especialidad);
        mConsultorio = itemView.findViewById(R.id.item_consultorio);
        mMatricula = itemView.findViewById(R.id.item_matricula);
    }

    public CardView getCardView() { return mCardView; }
    public TextView getRazonSocial() { return mRazonSocial; }
    public TextView getEspecialidad() { return mEspecialidad; }
    public TextView getConsultorio() { return mConsultorio; }
    public TextView getMatricula() { return mMatricula; }
}
