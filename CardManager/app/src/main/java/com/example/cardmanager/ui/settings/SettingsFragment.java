package com.example.cardmanager.ui.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.chooseCard.CreditCardActivity;
import com.example.cardmanager.ui.chooseCard.FidelitateCardActivity;
import com.example.cardmanager.ui.model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsVViewModel;
    private  RecyclerView receivedCommandsRecycler;
    private  ArrayList<Item> orderModelArrayList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private CardItemAdapter cardItemAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FirebaseDatabase database;
    private DatabaseReference myRef ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsVViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User");
        getUserCards();

        receivedCommandsRecycler = root.findViewById(R.id.accepted_commands_recycler);




        floatingActionButton = root.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        showAlertDialog();
                                                    }
                                                }
        );





        return root;
    }

    @Override
    public void onResume() {
        getUserCards();
        super.onResume();
    }

    private void showAlertDialog() {


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.getContext());
        alertDialog.setMessage("Ce fel de card doriti sa adaugati?");


        alertDialog.setPositiveButton("Fidelitate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"Fidelitate",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), FidelitateCardActivity.class);
                startActivity(intent);
            }

        });

        alertDialog.setNegativeButton("Credit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"Credit",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), CreditCardActivity.class);
                startActivity(intent);
            }
        });

        alertDialog.show();

    }

    private void getUserCards()
    {

        DatabaseReference ref = database.getReference();

        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        dataSnapshot.getChildrenCount();
                        dataSnapshot.child("User").child("Carduri").getValue();


                        orderModelArrayList = collectCreditCard((Map<String,Object>) dataSnapshot.child("User").child("Carduri").child("Credit").getValue());
                        ArrayList<Item> orderModelArrayList2 = collectFidelitateCard((Map<String,Object>) dataSnapshot.child("User").child("Carduri").child("Fidelitate").getValue());
                        for(Item item :orderModelArrayList2)
                        {
                            orderModelArrayList.add(item);
                        }

                        cardItemAdapter = new CardItemAdapter(getContext(),orderModelArrayList);
                        layoutManager = new LinearLayoutManager(getContext());
                        receivedCommandsRecycler.setAdapter(cardItemAdapter);
                        receivedCommandsRecycler.setLayoutManager(layoutManager);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }
    private  ArrayList<Item> collectCreditCard(Map<String,Object> carduriCredit) {

        ArrayList<Item> creditCards = new ArrayList<>();

        for (Map.Entry<String, Object> entry : carduriCredit.entrySet()){

            Map val = (Map)entry.getValue();
            String denumire = (String) val.get("denumire");
            String cod = (String) val.get("cod");
            String cvv = (String) val.get("cvv");
            String data = (String) val.get("data");
            String titular = (String) val.get("titular");


            Item item  = new Item();
            item.setPozition(entry.getKey());
            item.setNumarCard(cod);
            item.setDenumireCard(denumire);
            item.setIsCredit(true);
            item.setCvv(cvv);
            item.setData(data);
            item.setTitular(titular);


            creditCards.add(item);
        }
        return creditCards;
    }
    private  ArrayList<Item> collectFidelitateCard(Map<String,Object> carduriCredit) {

        ArrayList<Item> creditCards = new ArrayList<>();

        for (Map.Entry<String, Object> entry : carduriCredit.entrySet()){
//
            Map val = (Map)entry.getValue();
            String denumire = (String) val.get("denumire");
            String cod = (String) val.get("cod");

            Item item  = new Item();
            item.setPozition(entry.getKey());
            item.setNumarCard(cod);
            item.setDenumireCard(denumire);
            creditCards.add(item);
        }
        return creditCards;
    }
}