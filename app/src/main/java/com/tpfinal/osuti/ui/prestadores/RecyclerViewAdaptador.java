package com.tpfinal.osuti.ui.prestadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView prestador, matricula, consultorio, especialidad;

        public ViewHolder(View itemView){
            super(itemView);
            prestador=(TextView)itemView.findViewById(R.id.item_nombrePrestador);
            matricula=(TextView)itemView.findViewById(R.id.item_matricula);
            consultorio=(TextView)itemView.findViewById(R.id.item_consultorio);
            especialidad=(TextView)itemView.findViewById(R.id.item_especialidad);
        }

    }

    public List<Prestador> prestadorLista;

    public RecyclerViewAdaptador(List<Prestador> prestadorLista) {
        this.prestadorLista = prestadorLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prestadores,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.prestador.setText(prestadorLista.get(position).getRazon_social());
        holder.especialidad.setText(prestadorLista.get(position).getEspecialidad());
       // holder.consultorio.setText(prestadorLista.get(position).getConsultorio_id());falta lo de consultorio ver queo nda
        holder.matricula.setText(prestadorLista.get(position).getMatricula());
    }

    @Override
    public int getItemCount() {
        return prestadorLista.size();
    }
}
