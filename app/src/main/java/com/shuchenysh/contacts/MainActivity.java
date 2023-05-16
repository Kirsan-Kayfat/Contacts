package com.shuchenysh.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMain;
    private FloatingActionButton buttonAddContact;

    private ContactAdapter contactAdapter = new ContactAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        recyclerViewMain.setAdapter(contactAdapter);

        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddContactActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

    }

    private void initViews(){
        recyclerViewMain = findViewById(R.id.recyclerViewMain);
        buttonAddContact = findViewById(R.id.buttonAddContact);

    }
}