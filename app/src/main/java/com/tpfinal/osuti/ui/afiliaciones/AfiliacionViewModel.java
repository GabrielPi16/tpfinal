package com.tpfinal.osuti.ui.afiliaciones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AfiliacionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AfiliacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}