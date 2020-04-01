package com.example.eudcatetoelevate.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModelStudent extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModelStudent() {
        mText = new MutableLiveData<>();
        mText.setValue("This is student home_admin fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}