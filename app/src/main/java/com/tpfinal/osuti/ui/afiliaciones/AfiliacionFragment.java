package com.tpfinal.osuti.ui.afiliaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.tpfinal.osuti.MainActivity;
import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Afiliado;
import com.tpfinal.osuti.models.Usuario;
import com.tpfinal.osuti.repository.AppRepository;
import com.tpfinal.osuti.repository.callback.OnUsuarioResultCallback;

public class AfiliacionFragment extends Fragment {

    private AfiliacionViewModel mViewModel;
    public Afiliado mAfiliado;
    private Context mContext;

    private final static String CHANNEL_ID = "NOTIFICATION";
    public final static int NOTIFICACION_ID = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_afiliaciones, container, false);
        mViewModel = new AfiliacionViewModel(root);
        mContext  = getActivity().getApplication();

        mViewModel.getBtnAfiliar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onValidateFormAfiliacion()) {
                    mViewModel.getContenedor().setVisibility(View.GONE);
                    mViewModel.getProgressBar().setVisibility(View.VISIBLE);

                    AppRepository appRepository = new AppRepository(getActivity().getApplication());
                    OnUsuarioResultCallback callback = new OnUsuarioResultCallback() {
                        @Override
                        public void onResultInsertUser(Long idUsuario) {
                            Toast.makeText(mContext, "EXITO: Usuario Creado", Toast.LENGTH_LONG).show();
                            SystemClock.sleep(2000);
                            mViewModel.getProgressBar().setVisibility(View.GONE);
                            mViewModel.getContenedor().setVisibility(View.VISIBLE);

                            createNotificationChannel();
                            createNotification();

                            startActivity(new Intent(getActivity().getApplication(), MainActivity.class));
                        }
                    };

                    Usuario usuario = new Usuario();
                    usuario.setNombre(mAfiliado.getNombre());
                    usuario.setApellido(mAfiliado.getApellido());
                    usuario.setNroAfiliado(mAfiliado.getDNI());
                    usuario.setObraSocial("OSUTI");
                    usuario.setMail(mAfiliado.getEmail());
                    usuario.setPassword(mViewModel.getDNI().getText().toString());

                    appRepository.insertarUsuario(usuario, callback);
                }
                else{
                    Toast.makeText(mContext,"Faltan ingresar campos. Verifique que todo este correctamente ingresado.",Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }

    /* Valida que todos los campos en el formulario fueron ingresados */
    private boolean onValidateFormAfiliacion() {

        if (mViewModel.getDNI().getText().toString().isEmpty()) return false;
        if (mViewModel.getNombre().getText().toString().isEmpty()) return false;
        if (mViewModel.getApellido().getText().toString().isEmpty()) return false;
        if (mViewModel.getEmail().getText().toString().isEmpty()) return false;

        mAfiliado = new Afiliado();
        mAfiliado.setNombre(mViewModel.getNombre().getText().toString());
        mAfiliado.setApellido(mViewModel.getApellido().getText().toString());
        mAfiliado.setDNI(Integer.valueOf(mViewModel.getDNI().getText().toString()));
        mAfiliado.setFechaNac(mViewModel.getFecha().getText().toString());
        mAfiliado.setEmail(mViewModel.getEmail().getText().toString());

        return true;
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notification";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification(){
        Context context = getActivity().getApplicationContext();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.logo_app);
        builder.setContentTitle("Usted es nuevo afiliado");
        builder.setContentText("Felicitaciones se le enviara un email con su numero de socio");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }

}