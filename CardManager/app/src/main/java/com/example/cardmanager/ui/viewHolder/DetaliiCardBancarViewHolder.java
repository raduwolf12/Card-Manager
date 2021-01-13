package com.example.cardmanager.ui.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;

public class DetaliiCardBancarViewHolder extends RecyclerView.ViewHolder {
        public TextView bank;
        public TextView holder;
        public TextView cardNo;
        public TextView expirDate;
        public TextView cvv;

        public DetaliiCardBancarViewHolder(@NonNull View itemView) {
            super(itemView);
            bank = itemView.findViewById(R.id.bana_denum_det);
            holder = itemView.findViewById(R.id.titular_denum_det2);
            cardNo = itemView.findViewById(R.id.card_no_det);
            expirDate = itemView.findViewById(R.id.expire_date_det);
            cvv = itemView.findViewById(R.id.cvv_det);
        }
}
