package com.dmd.martin.distribuidosapp.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dmd.martin.distribuidosapp.R;

/**
 * Created by martin on 29/11/17.
 */

public class RVHClient extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView textViewIdClient;
    public TextView textViewNameClient;
    public RVHClient(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        textViewIdClient = itemView.findViewById(R.id.textViewIdClient);
        textViewNameClient = itemView.findViewById(R.id.textViewNameClient);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
    }
}
