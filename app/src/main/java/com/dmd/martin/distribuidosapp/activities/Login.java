package com.dmd.martin.distribuidosapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dmd.martin.distribuidosapp.R;

import rest.users.RestUser;

public class Login extends AppCompatActivity {
    private RestUser restUser;
    private EditText editTextLoginUser;
    private EditText editTextLoginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextLoginUser = (EditText) findViewById(R.id.editTextLoginUser);
        editTextLoginPassword = (EditText) findViewById(R.id.editTextLoginPassword);


    }

    public void sendUser(View view){
        restUser =  new RestUser(this, editTextLoginUser.getText().toString(), editTextLoginPassword.getText().toString());
        restUser.execute();
    }
}
