package com.tpfinal.osuti.ui.prestadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.model.LatLng;
import com.tpfinal.osuti.MapsActivity;
import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.*;
import static androidx.core.content.ContextCompat.startActivity;

public class PrestadorAdapter extends RecyclerView.Adapter<PrestadorAdapter.ViewHolder> {
    public List<Prestador> mListPrestadores;
    private Context context;

    public PrestadorAdapter() {}

    public void setListPrestadores(List<Prestador> listPretadores, Context context1) {
        context = context1;
        if (mListPrestadores == null) {
            mListPrestadores = new ArrayList<>();
        }
        mListPrestadores.clear();
        mListPrestadores.addAll(listPretadores);
        notifyDataSetChanged();
    }

    @Override
    public PrestadorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prestadores, parent, false);
        PrestadorAdapter.ViewHolder mViewHolder = new PrestadorAdapter.ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PrestadorAdapter.ViewHolder holder, int position) {
        Prestador prestador = mListPrestadores.get(position);
        holder.mPrestador = prestador;
        holder.getCardView().setTransitionName(String.valueOf(prestador.getId()));
        holder.getEspecialidad().setText(prestador.getEspecialidad());
        holder.getMatricula().setText(prestador.getMatricula());
        holder.getRazonSocial().setText(prestador.getRazon_social());

        String consultorio = "";
        if (prestador.getConsultorio_id() == 1) {
            consultorio = "Sanatorio Santa Fe";
        }
        else if (prestador.getConsultorio_id() == 2) {
            consultorio = "Sanatorio Garay";
        }
        else if (prestador.getConsultorio_id() == 3) {
            consultorio = "Hospital Jose Maria Cuyen";
        }
        else if (prestador.getConsultorio_id() == 4) {
            consultorio = "Sanatorio San Geronimo";
        }
        else if (prestador.getConsultorio_id() == 5) {
            consultorio = "Sanatorio Diagnostico";
        }
        else if (prestador.getConsultorio_id() == 6) {
            consultorio = "Sanatorio Mayo";
        }

        holder.getConsultorio().setText("Atiende en: " + consultorio);

        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapsActivity.mConsultorio = prestador.getConsultorio_id();
                Intent mapIntent = new Intent(context, MapsActivity.class);
                mapIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (mListPrestadores != null) ? mListPrestadores.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private CardView mCardView;
        private TextView mRazonSocial;
        private TextView mEspecialidad;
        private TextView mConsultorio;
        private TextView mMatricula;

        private Prestador mPrestador;

        public ViewHolder(@NonNull View view) {
            super(view);
            mView = view;
            mCardView = view.findViewById(R.id.prestador_cardView);
            mRazonSocial = view.findViewById(R.id.item_nombrePrestador);
            mEspecialidad = view.findViewById(R.id.item_especialidad);
            mConsultorio = view.findViewById(R.id.item_consultorio);
            mMatricula = view.findViewById(R.id.item_matricula);
        }

        public CardView getCardView() { return mCardView; }
        public TextView getRazonSocial() { return mRazonSocial; }
        public TextView getEspecialidad() { return mEspecialidad; }
        public TextView getConsultorio() { return mConsultorio; }
        public TextView getMatricula() { return mMatricula; }

        @Override
        public String toString() {
            return super.toString() + " '" + mRazonSocial.getText() + "'";
        }
    }
}
