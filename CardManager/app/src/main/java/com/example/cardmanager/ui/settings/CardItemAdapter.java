package com.example.cardmanager.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.chooseCard.DetaliiCardActivity;
import com.example.cardmanager.ui.model.Item;

import java.util.ArrayList;

public class CardItemAdapter extends RecyclerView.Adapter<CardViewHolder>{


    private ArrayList<Item> orderModels = new ArrayList<Item>();
    private Context mContext;

    public CardItemAdapter(Context context, ArrayList<Item> orderModels) {
        this.orderModels = orderModels;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main,parent,false);
        CardViewHolder holder = new CardViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, final int position) {
        final Item curentModel = orderModels.get(position);

        holder.tableNmb.setText(curentModel.getDenumireCard());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(holder.itemView.getContext(),"DA",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext.getApplicationContext(), DetaliiCardActivity.class);
                intent.putExtra("item", curentModel);

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return orderModels.size();
    }

}