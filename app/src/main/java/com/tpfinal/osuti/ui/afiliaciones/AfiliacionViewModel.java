package com.tpfinal.osuti.ui.afiliaciones;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tpfinal.osuti.R;

public class AfiliacionViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private EditText mNombre;
    private EditText mApellido;
    private EditText mFecha;
    private EditText mDNI;
    private EditText mEmail;
    private Button mBtnAfiliar;
    private ProgressBar mProgressBar;
    private LinearLayout mContenedor;

    public AfiliacionViewModel(@NonNull View view) {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el fragmento de Afiliaciones");

        mNombre = view.findViewById(R.id.etNombreaf);
        mApellido = view.findViewById(R.id.etApellidoaf);
        mEmail = view.findViewById(R.id.etEmailaf);
        mDNI = view.findViewById(R.id.etDNIaf);
        mFecha = view.findViewById(R.id.etFehanacaf);
        mBtnAfiliar = view.findViewById(R.id.buttonAfiliacion);
        mProgressBar = view.findViewById(R.id.progressBar3);
        mContenedor = view.findViewById(R.id.afiliacion_layout);
    }

    public EditText getNombre() { return mNombre; }
    public EditText getApellido() { return mApellido; }
    public EditText getFecha() { return mFecha; }
    public EditText getDNI() { return mDNI; }
    public EditText getEmail() { return mEmail; }
    public Button getBtnAfiliar() { return mBtnAfiliar; }
    public ProgressBar getProgressBar() { return mProgressBar; }
    public LinearLayout getContenedor() { return mContenedor; }

    public LiveData<String> getText() {
        return mText;
    }
}