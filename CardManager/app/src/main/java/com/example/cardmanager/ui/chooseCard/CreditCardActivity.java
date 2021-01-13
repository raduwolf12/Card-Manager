package com.example.cardmanager.ui.chooseCard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.cardmanager.R;
import com.example.cardmanager.ui.model.CardCredit;
import com.example.cardmanager.ui.model.CardFidelitate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class CreditCardActivity extends Activity {

    private Button cancelBtn;
    private Button acceptBtn;
    private EditText card_number;
    private EditText card_holder;
    private EditText expire_date_credit_1;
    private EditText expire_date_credit_2;
    private EditText denumire_banca;

    private EditText cvv_credit;
    private FirebaseDatabase database;
    private DatabaseReference myRef ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_credit_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User").child("Carduri").child("Credit");

         cancelBtn= findViewById(R.id.cancel_btn);
         acceptBtn= findViewById(R.id.acc_btn);
         card_number= findViewById(R.id.card_number_credit);
         card_holder= findViewById(R.id.card_holder_name);
         expire_date_credit_1= findViewById(R.id.expire_date_credit_1);
         expire_date_credit_2= findViewById(R.id.expire_date_credit_2);
         cvv_credit= findViewById(R.id.cvv_credit);
        denumire_banca = findViewById(R.id.denumire_banca);

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

                CardCredit item = new CardCredit();
                String cod =card_number.getText().toString();
                String denumire =denumire_banca.getText().toString();
                String titular =card_holder.getText().toString();
                String cvv = cvv_credit.getText().toString() ;
                String data=expire_date_credit_1.getText().toString()+"/"+expire_date_credit_2.getText().toString();
                item.setDenumire(denumire);
                item.setCod(cod);
                item.setCvv(cvv);
                item.setData(data);
                item.setTitular(titular);


                myRef.child(random.toString()).setValue(item);


                finish();
            }
        });


    }
}