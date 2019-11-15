package com.example.labguide5;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Intent intent;
    ImageView img;
    TextView txt1;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        img = findViewById(R.id.imCity);
        txt1 = findViewById(R.id.txtCityInfo);

        intent = getIntent();
        Bundle b = intent.getExtras();
        int city = b.getInt("City");

        img.setImageResource(CitySys.getItem(city).getImgId());
        txt1.setText(CitySys.getItem(city).getName());
    }

    public void onclick(View view) {
        finish();
    }


}
