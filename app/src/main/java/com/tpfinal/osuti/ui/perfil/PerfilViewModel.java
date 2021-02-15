package com.tpfinal.osuti.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel  {

    private MutableLiveData<String> mNombre;
    private MutableLiveData<String> mApellido;
    private MutableLiveData<String> mNroAfiliado;
    private MutableLiveData<String> mEmail;
    private MutableLiveData<String> mPassword;

    public PerfilViewModel() {
        mNombre = new MutableLiveData<>();
        mNombre.setValue("Gabriel");

        mApellido = new MutableLiveData<>();
        mApellido.setValue("Piedrabuena");

        mNroAfiliado = new MutableLiveData<>();
        mNroAfiliado.setValue("228521-00");

        mEmail = new MutableLiveData<>();
        mEmail.setValue("gabriel@pi.com");

        mPassword = new MutableLiveData<>();
        mPassword.setValue("1234");
    }

    public LiveData<String> getNombre() { return mNombre; }
    public LiveData<String> getApellido() { return mApellido; }
    public LiveData<String> getEmail() { return mEmail; }
    public LiveData<String> getPassword() { return mPassword; }
    public LiveData<String> getNroAfiliado() { return mNroAfiliado; }
}
