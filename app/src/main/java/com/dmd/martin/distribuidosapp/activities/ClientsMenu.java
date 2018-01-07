package com.dmd.martin.distribuidosapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dmd.martin.distribuidosapp.R;

import rest.clients.RestClient;

public class ClientsMenu extends AppCompatActivity {

    private RecyclerView recyclerViewClients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_menu);
        Toast.makeText(this, Constants.clientList.getClients().size(), Toast.LENGTH_SHORT).show();
        recyclerViewClients = (RecyclerView) findViewById(R.id.recyclerViewClients);
        recyclerViewClients.setHasFixedSize(true);
        recyclerViewClients.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewClients.setAdapter(new RecyclerViewAdapterClient());
    }


}
