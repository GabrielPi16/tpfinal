package com.tpfinal.osuti.ui.turnos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnosAdapter extends RecyclerView.Adapter<TurnosAdapter.ViewHolder> {
    public List<Turno> mListTurnos;
    private final TurnosFragment.OnListFragmentInteractionListener mListener;

    public TurnosAdapter(TurnosFragment.OnListFragmentInteractionListener listener) {
        this.mListener = listener;
    }

    public void setListTurnos(List<Turno> listTurnos) {
        if (mListTurnos == null) {
            mListTurnos = new ArrayList<>();
        }
        mListTurnos.clear();
        mListTurnos.addAll(listTurnos);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_turnos, parent, false);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Turno turno = mListTurnos.get(position);
        holder.mTurno = turno;
        holder.getCardView().setTransitionName(String.valueOf(turno.getId()));
        holder.getMedico().setText(turno.getNombrePrestador());
        holder.getConsultorio().setText(turno.getClinica());
        holder.getFecha().setText(turno.getFecha());
        holder.getHora().setText(turno.getHora());
        holder.getFCreacion().setText(turno.getCreated());
        holder.getNumTurno().setText(String.format("%d", turno.getId()));

        holder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListClickItem(holder.mTurno);
                }
            }
        });

        final long itemId = holder.mTurno.getId();
        holder.mDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.onListFragmentDeleteItemById(itemId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (mListTurnos != null) ? mListTurnos.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final CardView mCardView;
        private final TextView mMedico;
        private final TextView mConsultorio;
        private final TextView mFecha;
        private final TextView mHora;
        private final TextView mFCreacion;
        private final TextView mNumTurno;
        private final Button mDelete;

        private Turno mTurno;

        public ViewHolder(@NonNull View view) {
            super(view);
            mView = view;
            mCardView = view.findViewById(R.id.turno_cardView);
            mMedico = view.findViewById(R.id.turno_medico);
            mConsultorio = view.findViewById(R.id.turno_lugar);
            mFecha = view.findViewById(R.id.turno_fecha);
            mHora = view.findViewById(R.id.turno_hora);
            mFCreacion = view.findViewById(R.id.turno_fechaCreacion);
            mNumTurno = view.findViewById(R.id.turno_tvInformId);
            mDelete = view.findViewById(R.id.turno_btnDelete);
        }

        public CardView getCardView() { return mCardView; }
        public TextView getMedico() { return mMedico; }
        public TextView getConsultorio() { return mConsultorio; }
        public TextView getFecha() { return mFecha; }
        public TextView getHora() { return mHora; }
        public TextView getFCreacion() { return mFCreacion; }
        public TextView getNumTurno() { return mNumTurno; }
        public Button getDelete() { return mDelete; }

        @Override
        public String toString() {
            return super.toString() + " '" + mMedico.getText() + "'";
        }
    }
}
