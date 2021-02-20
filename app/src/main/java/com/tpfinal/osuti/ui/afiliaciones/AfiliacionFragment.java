package com.tpfinal.osuti.ui.afiliaciones;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tpfinal.osuti.MainActivity;
import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Afiliado;

public class AfiliacionFragment extends Fragment {

    private AfiliacionViewModel afiliacionViewModel;
    private EditText nombre,apellido,email,dni,fechanac;
    private Button botonAfiliar;
    public Afiliado afiliado;
    private ProgressBar progressBar;
    private Notificacion notificacion;


    public final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        afiliacionViewModel = new ViewModelProvider(this).get(AfiliacionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_afiliaciones, container, false);

        nombre=(EditText)root.findViewById(R.id.etNombreaf);
        apellido=(EditText)root.findViewById(R.id.etApellidoaf);
        email=(EditText)root.findViewById(R.id.etEmailaf);
        dni=(EditText)root.findViewById(R.id.etDNIaf);
        fechanac=(EditText)root.findViewById(R.id.etFehanacaf);
        botonAfiliar=(Button)root.findViewById(R.id.buttonAfiliacion);
        progressBar=(ProgressBar)root.findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);

        Context ctx = getActivity();

        botonAfiliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afiliado.setNombre(nombre.toString());
                afiliado.setApellido(apellido.toString());
                afiliado.setDNI(Integer.parseInt(dni.toString()));
                afiliado.setFechaNac(fechanac.toString());


                SystemClock.sleep(7000);
                progressBar.setVisibility(View.VISIBLE);

                //no se como llamarla
                Notification notification = new NotificationCompat.Builder(ctx, CHANNEL_ID)
                        .setSmallIcon(R.drawable.logo_app)
                        .setContentTitle("Usted es nuevo afiliado")
                        .setContentText("Felicitaciones se le enviara un email con su numero de socio")
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigLargeIcon(null))
                        .build();

                //startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });

        return root;
    }


}