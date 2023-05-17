package com.shuchenysh.contacts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AddContactViewModel extends AndroidViewModel {
    private Dao dao;
    public MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();

    public AddContactViewModel(@NonNull Application application) {
        super(application);
        dao = Database.getInstance(application).dao();
    }
    public void add(Contact contact) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dao.add(contact);
                shouldCloseScreen.postValue(true);
            }
        });
        thread.start();

    }
}
