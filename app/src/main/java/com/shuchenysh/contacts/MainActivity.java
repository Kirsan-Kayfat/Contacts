package com.shuchenysh.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMain;
    private FloatingActionButton buttonAddContact;
    private ContactAdapter contactAdapter = new ContactAdapter();
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initViews();
        recyclerViewMain.setAdapter(contactAdapter);
        mainViewModel.getContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                contactAdapter.setContacts(contacts);
            }
        });

        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddContactActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
        contactAdapter.setOnClickListener(new ContactAdapter.OnClickListener() {
            @Override
            public void onClick(Contact contact) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mainViewModel.remove(contact);
                    }
                });
                thread.start();


            }
        });

    }

    private void initViews() {
        recyclerViewMain = findViewById(R.id.recyclerViewMain);
        buttonAddContact = findViewById(R.id.buttonAddContact);
    }

}