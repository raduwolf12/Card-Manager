package com.example.cardmanager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.model.Item;
import com.example.cardmanager.ui.viewHolder.DetaliiCardBancarViewHolder;
import com.example.cardmanager.ui.viewHolder.DetaliiCardViewHolder;

public class DetaliiCardBancarAdapter extends RecyclerView.Adapter<DetaliiCardBancarViewHolder> {
    private Item orderModels = new Item();
    private Context mContext;

    public DetaliiCardBancarAdapter(Context context, Item orderModels) {
        this.orderModels = orderModels;
        this.mContext = context;
    }

    @NonNull
    @Override
    public DetaliiCardBancarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.credit_details_main,parent,false);
        DetaliiCardBancarViewHolder holder = new DetaliiCardBancarViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DetaliiCardBancarViewHolder holder, int position) {
        Item curentModel = orderModels;

        holder.bank.setText(curentModel.getDenumireCard());
        holder.cardNo.setText(curentModel.getNumarCard());
        holder.cvv.setText(curentModel.getCvv());
        holder.holder.setText(curentModel.getTitular());
        holder.expirDate.setText(curentModel.getData());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),"DA",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
