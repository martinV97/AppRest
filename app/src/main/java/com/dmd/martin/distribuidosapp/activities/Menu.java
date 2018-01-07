package com.dmd.martin.distribuidosapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.dmd.martin.distribuidosapp.R;

import rest.clients.RestClient;

public class Menu extends AppCompatActivity {
    private RestClient restClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void showClients(View view){
        restClient = new RestClient(this);
        restClient.execute();
    }
}
