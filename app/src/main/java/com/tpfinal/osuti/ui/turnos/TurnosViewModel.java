package com.tpfinal.osuti.ui.turnos;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.tpfinal.osuti.R;
import com.tpfinal.osuti.models.Turno;
import com.tpfinal.osuti.repository.AppRepository;

import org.w3c.dom.Text;

import java.util.List;

public class TurnosViewModel extends AndroidViewModel {
    private AppRepository mAppRepository;
    private LiveData<List<Turno>> mListTurnos;

    public TurnosViewModel(@NonNull Application application){
        super(application);
        mAppRepository = new AppRepository(application);
        mListTurnos = mAppRepository.getAllTurnos();
    }

    public LiveData<List<Turno>> getAllTurnos() {
        return mListTurnos;
    }

    public void deleteItem(Turno turno) {
        mAppRepository.deleteTurno(turno);
    }

    public void deleteItemById(long turnoi_id) {
        //mAppRepository.deleteTurno();
    }
}
