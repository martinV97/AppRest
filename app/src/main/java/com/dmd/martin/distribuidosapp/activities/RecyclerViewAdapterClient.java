package com.dmd.martin.distribuidosapp.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmd.martin.distribuidosapp.R;

/**
 * Created by martin on 29/11/17.
 */

public class RecyclerViewAdapterClient extends RecyclerView.Adapter<RVHClient> {
    @Override
    public RVHClient onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_client, null);
        RVHClient rvhClient = new RVHClient(layoutView);
        return rvhClient;
    }

    @Override
    public void onBindViewHolder(RVHClient holder, int position) {
        holder.textViewIdClient.setText(Constants.clientList.getClients().get(position).getId());
        holder.textViewNameClient.setText(Constants.clientList.getClients().get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
