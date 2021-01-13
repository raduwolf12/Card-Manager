package com.example.cardmanager.ui.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;

public class DetaliiCardViewHolder  extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public DetaliiCardViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.codbare_text);
            imageView = itemView.findViewById(R.id.codbare_imagine);
        }
}
