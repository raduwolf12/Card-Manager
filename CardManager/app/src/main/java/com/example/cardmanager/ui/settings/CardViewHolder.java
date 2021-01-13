package com.example.cardmanager.ui.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public TextView tableNmb;
    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        tableNmb = itemView.findViewById(R.id.table_number);
    }
}
