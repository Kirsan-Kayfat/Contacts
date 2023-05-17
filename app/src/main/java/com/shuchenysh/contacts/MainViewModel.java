package com.shuchenysh.contacts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private Dao dao;

    public MainViewModel(@NonNull Application application) {
        super(application);
        dao = Database.getInstance(application).dao();
    }

    public LiveData<List<Contact>> getContacts() {
        return dao.getContacts();
    }
    public void remove(Contact contact) {
        dao.remove(contact.getId());
    }
}
