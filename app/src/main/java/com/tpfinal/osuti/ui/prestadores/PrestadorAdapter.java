package com.tpfinal.osuti.ui.prestadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.ui.turnos.TurnosAdapter;
import com.tpfinal.osuti.ui.turnos.TurnosFragment;

import java.util.ArrayList;
import java.util.List;

public class PrestadorAdapter extends RecyclerView.Adapter<PrestadorAdapter.ViewHolder> {
    public List<Prestador> mListPrestadores;

    public PrestadorAdapter() {}

    public void setListPrestadores(List<Prestador> listPretadores) {
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
        holder.getConsultorio().setText("Atiende en: " + prestador.getConsultorio_id());
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
