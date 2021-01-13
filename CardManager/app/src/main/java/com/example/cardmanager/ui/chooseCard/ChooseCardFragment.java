package com.example.cardmanager.ui.chooseCard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardmanager.R;
import com.example.cardmanager.ui.model.CardNames;
import com.example.cardmanager.ui.model.Item;
import com.example.cardmanager.ui.settings.CardItemAdapter;

import java.util.ArrayList;

public class ChooseCardFragment extends Activity {

private ArrayList<Item> cardModelList = new ArrayList<>();
private ArrayList<Item> mostUsedCardList = new ArrayList<>();

    Button addNew;
    CardItemAdapter cardItemAdapter;
    CardItemAdapter cardItemAdapterMostUsed;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager layoutManagerMostUsed;
    RecyclerView receivedCommandsRecycler;
    RecyclerView receivedCommandsRecyclerMostUsed;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_choose_card);

    cardModelList = initializareCards();
    mostUsedCardList = initializareMostUsedCardrs();

    receivedCommandsRecycler = findViewById(R.id.all_cards_recycler);
    receivedCommandsRecyclerMostUsed = findViewById(R.id.most_used_cards_recycler);


    cardItemAdapter = new CardItemAdapter(this.getBaseContext(),cardModelList);
    cardItemAdapterMostUsed= new CardItemAdapter(this.getBaseContext(),mostUsedCardList);

    layoutManager = new LinearLayoutManager(this.getBaseContext());
    receivedCommandsRecycler.setAdapter(cardItemAdapter);
    receivedCommandsRecycler.setLayoutManager(layoutManager);


    layoutManagerMostUsed = new LinearLayoutManager(this.getBaseContext());
    receivedCommandsRecyclerMostUsed.setAdapter(cardItemAdapterMostUsed);
    receivedCommandsRecyclerMostUsed.setLayoutManager(layoutManagerMostUsed);

    addNew = findViewById(R.id.addNewButton);
    addNew.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Toast.makeText(getBaseContext(),"New button!",Toast.LENGTH_SHORT).show();
                                  }
                              }
    );
}

private ArrayList<Item> initializareCards()
{
    ArrayList<Item> vals = new ArrayList<>();
    for(CardNames val:CardNames.values())
        vals.add(new Item(val.getVal()));
    return  vals;
}

private ArrayList<Item> initializareMostUsedCardrs()
{
   int counter = 0;
   ArrayList<Item> vals = new ArrayList<>();
   for(CardNames val:CardNames.values()) {
       if(counter<5)
       {
           vals.add(new Item(val.getVal()));
           counter++;
       }
   }
   return  vals;
}

}