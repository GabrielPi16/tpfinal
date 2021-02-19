package com.tpfinal.osuti;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.ui.fragments.AlertDialogFragment;
import com.tpfinal.osuti.ui.login.LoginActivity;
import com.tpfinal.osuti.ui.turnos.TurnoDialog;
import com.tpfinal.osuti.ui.turnos.TurnosFragment;
import com.tpfinal.osuti.ui.turnos.TurnosViewModel;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.tpfinal.osuti.ui.fragments.AlertDialogFragment.ID_LONG;

public class MainActivity extends AppCompatActivity implements TurnosFragment.OnListFragmentInteractionListener,
        AlertDialogFragment.AlertDialogListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnoDialog.display(getSupportFragmentManager());
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Pasar cada ID de menú como un conjunto de ID para que cada menú deba considerarse como destinos de nivel superior.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_turno, R.id.nav_afiliacion, R.id.nav_prestador, R.id.nav_perfil, R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       Intent i;
        //Toast.makeText(getApplicationContext(), item.getItemId(), Toast.LENGTH_LONG).show();
        switch (item.getItemId()) {

            case(R.id.nav_loginOut):
                i=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onListClickItem(Turno turno) {
        Toast.makeText(this, turno.getNombrePrestador(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListFragmentDeleteItemById(long idItem) {
        Bundle bundle = new Bundle();
        bundle.putLong(ID_LONG, idItem);

        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        alertDialogFragment.setArguments(bundle);
        alertDialogFragment.show(getSupportFragmentManager(), "Alert");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, long idItem) {
        TurnosViewModel mTurnoViewModel = ViewModelProviders.of(this).get(TurnosViewModel.class);
        mTurnoViewModel.deleteItemById(idItem);
        Toast.makeText(this, getString(R.string.message_delete), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(this, getString(R.string.message_cancel), Toast.LENGTH_SHORT).show();
    }
}