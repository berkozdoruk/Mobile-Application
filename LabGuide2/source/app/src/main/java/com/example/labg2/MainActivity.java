package com.example.labg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioButton rd1,rd2,rd3,radioButton;
    ImageView img;
    RadioGroup radioGroup;
    TextView textView;
    Button btnApply;
    SeekBar seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rdbtngrp1);
        rd1 = findViewById(R.id.rdbtnFirst);
        rd2 = findViewById(R.id.rdbtnSecond);
        rd3 = findViewById(R.id.rdbtnThird);
        textView = findViewById(R.id.txtSelected);
        img = findViewById(R.id.imgMovie);

        btnApply = findViewById(R.id.btnApply);


        seek = findViewById(R.id.sbChange);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                textView.setText("Seekbar :"+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

    }

    public void checkedRadio(View view)
    {
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        if(radioButton == rd1)
            img.setImageDrawable(getResources().getDrawable(R.drawable.dora));
        else if(radioButton == rd2)
            img.setImageDrawable(getResources().getDrawable(R.drawable.spiderman));
        else
            img.setImageDrawable(getResources().getDrawable(R.drawable.kid_king));
        Toast.makeText(this,"Selected Movie :"+radioButton.getText(),Toast.LENGTH_LONG).show();

    }

    public void display(View view)
    {
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        textView.setText("Your choice is:"+radioButton.getText());
    }

}
