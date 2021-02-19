package com.tpfinal.osuti.ui.prestadores;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Prestador;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.repository.AppRepository;

import java.util.List;

public class PrestadorViewModel extends AndroidViewModel {
    private AppRepository mAppRepository;
    private LiveData<List<Prestador>> mListPretador;

    public PrestadorViewModel(@NonNull Application application){
        super(application);
        mAppRepository = new AppRepository(application);
        mListPretador = mAppRepository.getAllPrestadores();
    }

    public LiveData<List<Prestador>> getAllPrestadores() {
        return mListPretador;
    }

}
