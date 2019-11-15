package com.example.labg4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    Intent intent;

    TextView tvRes;
    String msg = "";
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        tvRes = findViewById(R.id.txtRes);
        intent = getIntent();

        Bundle b = intent.getExtras();
        int num1 = b.getInt("num1");
        int num2 = b.getInt("num2");
        int num3 = b.getInt("num3");
        String str1 = b.getString("str1");
        String str2 = b.getString("str2");
        double res = (num1+num2+num3) / 3;
        String str = str1.concat(str2);

        tvRes.setText("New String: "+str);
        tvRes.append("\nAverage is " + res  );

        msg = "New String and Average: " + res + " " + str;
    }

    public void onClick(View view) {

        Intent intent = new Intent();

        intent.putExtra("res", msg);

        setResult(RESULT_OK, intent);

        finish();

    }
}
