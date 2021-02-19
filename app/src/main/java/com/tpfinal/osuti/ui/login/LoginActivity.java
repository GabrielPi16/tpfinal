package com.tpfinal.osuti.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tpfinal.osuti.MainActivity;
import com.tpfinal.osuti.R;
import com.tpfinal.osuti.firebase.GoogleSignInActivity;
import com.tpfinal.osuti.models.Consultorio;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Usuario;
import com.tpfinal.osuti.repository.AppRepository;
import com.tpfinal.osuti.repository.callback.OnConsultorioResultCallback;
import com.tpfinal.osuti.repository.callback.OnPrestadorResultCallback;
import com.tpfinal.osuti.repository.callback.OnUsuarioResultCallback;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button loginGoogle = findViewById(R.id.loginWithGoogle);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {

                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
                //Crea 5 usuarios al azar

                Usuario usuario1 = new Usuario();
                usuario1.setNroAfiliado(1111);

                Usuario usuario2 = new Usuario();
                usuario2.setNroAfiliado(2222);

                AppRepository appRepository = new AppRepository(getApplication());
                appRepository.insertarUsuario(usuario1);
                appRepository.insertarUsuario(usuario2);

                OnUsuarioResultCallback onCallbackUsuario = new OnUsuarioResultCallback() {
                    @Override
                    public void onResultInsert(Long prestador_id) {
                        Log.d("CREACION PRESTADORES: ", String.format("prestador id: %d", prestador_id));
                    }

                    @Override
                    public List<Prestador> onResultSearch(List<Prestador> prestadores) { return null; }


            }
        });

        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithGoogle();
            }
        });
    }

    private void loginWithGoogle() {
        Intent intent = new Intent(this, GoogleSignInActivity.class);
        startActivity(intent);
    }

    private void updateUiWithUser(LoggedInUserView model) {
        // TODO : initiate successful logged in experience
        try {
            /* Instanciamos el Repositorio para poder realizar las consultas necesarias */
            AppRepository appRepository = new AppRepository(getApplication());

            /* Declaramos un callback para recibir los datos retornados por los asyncTask del prestador */
            OnPrestadorResultCallback onCallbackPrestador = new OnPrestadorResultCallback() {
                @Override
                public void onResultInsert(Long prestador_id) {
                    Log.d("CREACION PRESTADORES: ", String.format("prestador id: %d", prestador_id));
                }

                @Override
                public void onResultSearch(List<Prestador> prestadores) { }

                @Override
                public void onResultSearchId(Prestador prestador) {
                    if(prestador == null) {
                        /* Recuperamos la lista de consultorios que vamos a crear para la BD */
                        List<Consultorio> consultorios = Consultorio.getListaConsltorios();
                        OnConsultorioResultCallback onCallbackConsultorio = new OnConsultorioResultCallback() {
                            @Override
                            public void onResultInsert(Long consultorio_id) {
                                Log.d("CREACION CONSULTORIOS: ", String.format("consultorio id: %d", consultorio_id));
                            }

                            @Override
                            public void onResultSearch(List<Consultorio> consultorios) {}

                            @Override
                            public void onResultSearchConsultorio(Consultorio consultorio) { }
                        };
                        //Se crearan los consultorios
                        for (Consultorio consultorio: consultorios) {
                            appRepository.insertarConsultorio(consultorio, onCallbackConsultorio);
                        }

                        //Se crearan los prestadores
                        List<Prestador> prestadores = Prestador.getListaProfecionales();
                        for (Prestador medico: prestadores) {
                            appRepository.insertPrestador(medico, this);
                        }
                    }
                    else {
                        Log.d("BUSCAR ID PRESTADOR: ", String.format("prestador id: %d y %s", prestador.getId(), prestador.getRazon_social()));
                    }
                }
            };

            /* Ejecutamos una consulta de prueba para saber si la BD fue instanciada con anterioridad */
            appRepository.buscarPrestador((long) 1, onCallbackPrestador);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), getString(R.string.welcome), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}