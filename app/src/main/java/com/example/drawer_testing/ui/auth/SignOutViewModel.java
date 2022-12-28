package com.example.drawer_testing.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignOutViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SignOutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is sign out fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}