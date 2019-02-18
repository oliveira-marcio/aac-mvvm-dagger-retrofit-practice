package com.androidtutz.anushka.lifecycledemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int clickCount=0;
    private MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getInitialCount(){
        countLiveData.setValue(clickCount);
        return countLiveData;
    }

    public  void getCurrentCount(){
        clickCount++;
        countLiveData.setValue(clickCount);
    }
}
