package com.shuchenysh.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shuchenysh.contacts.databinding.ActivityAddContactBinding;

public class AddContactActivity extends AppCompatActivity {
    private ImageView imageViewPhoto;
    private TextView editTextName;
    private TextView editTextNumber;
    private Button buttonSaveContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        initViews();

        buttonSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });


    }

    private void initViews() {
        imageViewPhoto = findViewById(R.id.imageViewPhoto);
        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        buttonSaveContact = findViewById(R.id.buttonSaveContact);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, AddContactActivity.class);
    }

    private void saveContact() {
        String name = editTextName.getText().toString();
        String number = editTextNumber.getText().toString();

        Contact contact = new Contact(name, number);

        finish();
    }
}