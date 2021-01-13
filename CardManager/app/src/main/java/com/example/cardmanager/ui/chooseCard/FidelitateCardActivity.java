package com.example.cardmanager.ui.chooseCard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.model.CardFidelitate;
import com.example.cardmanager.ui.model.Item;
import com.example.cardmanager.ui.settings.CardItemAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FidelitateCardActivity extends Activity {

    private Button cancelBtn;
    private Button acceptBtn;
    private EditText numeMagazin;
    private EditText numaCard;
    private FirebaseDatabase database;
    private DatabaseReference myRef ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_fidelitate_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User").child("Carduri").child("Fidelitate");

        cancelBtn= findViewById(R.id.cancel_btn2);
        acceptBtn= findViewById(R.id.accept_btn2);
        numeMagazin= findViewById(R.id.card_fidelitate_nume_magazin);
        numaCard= findViewById(R.id.card_number_fidelitate);



        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"cancel!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"accept!",Toast.LENGTH_SHORT).show();

                final Integer random = new Random().nextInt(8026) + 75;

                CardFidelitate item = new CardFidelitate();
                String cod =numaCard.getText().toString();
                String denumire =numeMagazin.getText().toString();
                item.setDenumire(denumire);
                item.setCod(cod);


                myRef.child(random.toString()).setValue(item);

                finish();
            }
        });


    }
}