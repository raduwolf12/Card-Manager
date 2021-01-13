package com.example.cardmanager.ui.chooseCard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.adapter.DetaliiCardAdapter;
import com.example.cardmanager.ui.adapter.DetaliiCardBancarAdapter;
import com.example.cardmanager.ui.model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.Map;

public class DetaliiCardActivity extends Activity {
    private Item item ;
    private FloatingActionButton floatingActionButton;
    private TextView textView;
    private DetaliiCardAdapter detaliiCardAdapter;
    private DetaliiCardBancarAdapter cardBancarAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView receivedCommandsRecycler;
    private FirebaseDatabase database;
    private DatabaseReference myRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_details);
        Intent intent = getIntent();
        item = (Item)intent.getSerializableExtra("item");

        floatingActionButton = findViewById(R.id.deleteCard);
        textView = findViewById(R.id.cardNameDetails);
        receivedCommandsRecycler = findViewById(R.id.codBareRecycler);
        layoutManager = new LinearLayoutManager(this.getBaseContext());

        if(item.getIsCredit()==true)
        {
            cardBancarAdapter = new DetaliiCardBancarAdapter(this.getBaseContext(),item);
            receivedCommandsRecycler.setAdapter(cardBancarAdapter);
            receivedCommandsRecycler.setLayoutManager(layoutManager);

        }else
        {
            detaliiCardAdapter = new DetaliiCardAdapter(this.getBaseContext(),item);
            receivedCommandsRecycler.setAdapter(detaliiCardAdapter);
            receivedCommandsRecycler.setLayoutManager(layoutManager);
        }





        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Deleted!",Toast.LENGTH_SHORT).show();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if( item.getIsCredit()==true) {
                            dataSnapshot.child("User").child("Carduri").child("Credit").child(item.getPozition()).getRef().removeValue();

                        }
                        else
                        {
                            dataSnapshot.child("User").child("Carduri").child("Fidelitate").child(item.getPozition()).getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}
