package com.example.cardmanager.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.model.Item;
import com.example.cardmanager.ui.viewHolder.DetaliiCardViewHolder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class DetaliiCardAdapter extends RecyclerView.Adapter<DetaliiCardViewHolder> {
    private Item orderModels = new Item();
    private Context mContext;

    public DetaliiCardAdapter(Context context, Item orderModels) {
        this.orderModels = orderModels;
        this.mContext = context;
    }

    @NonNull
    @Override
    public DetaliiCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.codbare_main,parent,false);
        DetaliiCardViewHolder holder = new DetaliiCardViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DetaliiCardViewHolder holder, int position) {
        Item curentModel = orderModels;

        holder.textView.setText(curentModel.getNumarCard());

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(curentModel.getNumarCard(), BarcodeFormat.CODE_128,500, 250);
            Bitmap bitmap = Bitmap.createBitmap(500, 250, Bitmap.Config.RGB_565);
            for (int i = 0; i<500; i++){
                for (int j = 0; j<250; j++){
                    bitmap.setPixel(i,j,bitMatrix.get(i,j)? Color.BLACK:Color.WHITE);
                }
            }
            holder.imageView.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }

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
