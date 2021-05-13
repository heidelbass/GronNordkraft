package com.example.test2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";
    ListView listView;
    private ArrayList<WasteItem> wasteItems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView)findViewById(R.id.listview);

        EditText searchfunction = findViewById(R.id.search);

        ArrayList<String> wastenames = new ArrayList<>();



        wasteItems.add(new WasteItem("pizzabakker", "restaffald"));
        wasteItems.add(new WasteItem("pizza", "madaffald"));
        wasteItems.add(new WasteItem("Banan", "madaffald"));
        wasteItems.add(new WasteItem("Bananskrald", "madaffald"));
        wasteItems.add(new WasteItem("håndsprit", "farligt affald"));
        wasteItems.add(new WasteItem("mundbind", "restaffald"));
        wasteItems.add(new WasteItem("æble", "madaffald"));
        wasteItems.add(new WasteItem("papir", "papir"));
        wasteItems.add(new WasteItem("glasflaske", "glas"));
        wasteItems.add(new WasteItem("juicekarton", "kartoner"));
        wasteItems.add(new WasteItem("Appelsin", "madaffald"));
        wasteItems.add(new WasteItem("madrester", "madaffald"));
        wasteItems.add(new WasteItem("magnet", "metal"));
        wasteItems.add(new WasteItem("kaffepose", "restaffald"));
        wasteItems.add(new WasteItem("serviet", "restaffald"));
        wasteItems.add(new WasteItem("plastik bestik", "plast"));
        wasteItems.add(new WasteItem("æggebakke i pap", "pap"));


                searchfunction.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d(TAG, "onTextChanged: "+ s);
                wastenames.clear();
                for (int counter = 0; counter < wasteItems.size(); counter++)
                {
                    if (wasteItems.get(counter).getName().contains(s)) {
                        wastenames.add(wasteItems.get(counter).getName())    ;
//                        Log.d(TAG, "onTextChanged:" + wasteItems.get(counter).getCategory());
                    }
                }
                UpdateSearch(wastenames);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,wastenames);

        listView.setAdapter(arrayAdapter);
    }

    private void UpdateSearch(ArrayList<String> wastenames){
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,wastenames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: ");
                Toast.makeText(SearchActivity.this, wastenames.get(position), Toast.LENGTH_SHORT).show();

                for (int counter = 0; counter < wasteItems.size(); counter++)
                {
                    if (wasteItems.get(counter).getName()== wastenames.get(position)){
                        Log.d(TAG, "onTextChanged:" + wasteItems.get(counter).getCategory());

                        change(wasteItems.get(counter).getCategory());
                    }
                }


            }
        });

    }

    private void change (String category){
        Intent i;

        switch (category) {
            case "madaffald":
                i = new Intent(this, MadAffald.class);
                startActivity(i);
                break;

            case "papir":
                i = new Intent(this, Papir.class);
                startActivity(i);
                break;

            case "pap":
                i = new Intent(this, Pap.class);
                startActivity(i);
                break;

            case "metal":
                i = new Intent(this, Metal.class);
                startActivity(i);
                break;

            case "glas":
                i = new Intent(this, Glas.class);
                startActivity(i);
                break;

            case "plast":
                i = new Intent(this, Plast.class);
                startActivity(i);
                break;

            case "tekstiler":
                i = new Intent(this, Tekstiler.class);
                startActivity(i);
                break;

            case "kartoner":
                i = new Intent(this, Kartoner.class);
                startActivity(i);
                break;

            case "restaffald":
                i = new Intent(this, Restaffald.class);
                startActivity(i);
                break;

            case "farligt affald":
                i = new Intent(this, FarligtAffald.class);
                startActivity(i);
                break;
        }
    }
}
