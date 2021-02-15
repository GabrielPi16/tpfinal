package com.tpfinal.osuti.ui.turnos;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Consultorio;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.repository.AppRepository;
import com.tpfinal.osuti.repository.callback.OnTurnoResultCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TurnoDialog extends DialogFragment {

    public static final String TAG = "turno_dialog";

    private Toolbar toolbar;
    private String especialidad;
    private String profesional;
    private String fecha;
    private String horario;

    public static TurnoDialog display(FragmentManager fragmentManager) {
        TurnoDialog mTurnoDialog = new TurnoDialog();
        mTurnoDialog.show(fragmentManager, TAG);
        return mTurnoDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_Dialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setWindowAnimations(R.style.AppTheme_Slide);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.turno_dialog, container, false);

        toolbar = view.findViewById(R.id.turno_toolbar);

        /* SETEO DE CAMPO DE ESPECIALIDADES */
        String[] especialidades = {"Clinico/Generalista", "Traumatologia", "Ginecologia", "Urologia", "Neurologia",
                "Alergia e Inmunologia", "Bioquimica", "Cardiologia", "Cirugía General", "Gastroenterologia",
                "Infectologia", "Odontologia" };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, especialidades);

        AutoCompleteTextView autoEspecialidad = (AutoCompleteTextView) view.findViewById(R.id.especialidad_autocomplete);
        autoEspecialidad.setThreshold(1);
        autoEspecialidad.setAdapter(adapter1);

        //Aqui se toma el item seleccionado en el combo
        autoEspecialidad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                especialidad = String.format("%s", parent.getItemAtPosition(position));
                Log.d("ESPECIALIDAD: ", especialidad);
            }
        });

        /* SETEO DE CAMPO DE PROFESIONALES */
        String[] profecionales = {"Juan Bautista", "Marcos Esqueche", "Mauricio Loen", "Carmen Mercos", "Maria Luciana Kim",
                "Miguel Alverez", "Antonia Gon", "Cristofer Mateus", "Micaela Nerto", "Lorna Nuria",
                "Diego Velez", "Juan Carlos Villa", "Mariana Lupus", "Amadeo Diex", "Amanda Liniez"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, profecionales);

        AutoCompleteTextView autoProfecional = (AutoCompleteTextView) view.findViewById(R.id.profesional_autocomplete);
        autoProfecional.setThreshold(1);
        autoProfecional.setAdapter(adapter2);

        autoProfecional.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                profesional = String.format("%s", parent.getItemAtPosition(position));
                Log.d("PROFESIONAL: ", profesional);
            }
        });

        /* SETEO DE CAMPO DE HORARIOS */
        String[] horarios = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "13:30", "14:00", "14:30"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, horarios);
        AutoCompleteTextView autoHorario = (AutoCompleteTextView) view.findViewById(R.id.horario_autocomplete);
        autoHorario.setThreshold(1);
        autoHorario.setAdapter(adapter3);

        autoHorario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                horario = String.format("%s", parent.getItemAtPosition(position));
                Log.d("HORARIO: ", horario);
            }
        });

        /* SETEO DE CAMPO DE FECHA */
        CalendarView calendarView = view.findViewById(R.id.turno_fecha);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                fecha = String.format("%d-%d-%d", year, month, dayOfMonth);
                Log.d("FECHA: ", fecha);
            }
        });

        /* GUARDAR */
        Button btnGuardar = view.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onValidateFormTurnos()) {
                    /*AppRepository repository = new AppRepository(new Application());

                    Prestador prestador = repository.buscarPrestadorName(profesional);
                    Consultorio consultorio = repository.buscarConsultorio(prestador.getConsultorio_id());

                    String creacion = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    String lugar = String.format("%s - %s. %s", consultorio.getNombre(), consultorio.getCiudad(), consultorio.getDireccion());

                    Turno turno = new Turno(prestador.getId(), fecha, horario, lugar, creacion);
                    repository.insertTurno(turno, (OnTurnoResultCallback) TurnoDialog.this);*/

                    Toast.makeText(view.getContext(),"EL turno fue correctamente creado.",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(view.getContext(),"Faltan ingresar campos.",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> dismiss());
        toolbar.setTitle("Turnos");
        toolbar.setOnMenuItemClickListener(item -> {
            dismiss();
            return true;
        });
    }

    /* Valida que todos los campos en el formulario fueron ingresados */
    private boolean onValidateFormTurnos() {
        return true;
    }

}
