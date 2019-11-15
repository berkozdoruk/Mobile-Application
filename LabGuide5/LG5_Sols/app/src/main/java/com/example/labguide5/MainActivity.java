package com.example.labguide5;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    Spinner spCities;
    Intent intent;
    MySpinnerAdapter spinnerAdapter;

    boolean isDefaultSelected = true;

    RecyclerView recyclerCountries;
    LinearLayoutManager layoutManager;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.txtSpinner);
        spCities = findViewById(R.id.spCity);
        tv2 = findViewById(R.id.txtRecycler);
        recyclerCountries = findViewById(R.id.recyclerCountry);

        CitySys.prepareData();
        CountrySys.prepareData();

        spinnerAdapter = new MySpinnerAdapter(getBaseContext(), R.layout.cityspinner_layout);
        spCities.setAdapter(spinnerAdapter);
    }

    public void clickSP(View view) {

        spCities.setVisibility(View.VISIBLE);
        recyclerCountries.setVisibility(View.INVISIBLE);

        spCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (isDefaultSelected) {
                    isDefaultSelected = false;
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    int selectedItem = spCities.getSelectedItemPosition();
                    Bundle b = new Bundle();
                    b.putInt("City", selectedItem);

                    Toast.makeText(getBaseContext(), " " + selectedItem, Toast.LENGTH_LONG).show();
                    intent.putExtras(b);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void clickTxt(View view) {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerCountries.setLayoutManager(layoutManager);
        recyclerCountries.hasFixedSize();

        adapter = new MyRecyclerViewAdapter(this, CountrySys.getArrRecyclerCountry());
        recyclerCountries.setAdapter(adapter);

        recyclerCountries.setVisibility(View.VISIBLE);
        spCities.setVisibility(View.INVISIBLE);
    }
}
