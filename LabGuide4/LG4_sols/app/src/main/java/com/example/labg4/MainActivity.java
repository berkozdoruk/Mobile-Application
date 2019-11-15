package com.example.labg4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2, etNum3,etStr1,etStr2;
    ImageView img;
    Spinner spBook;
    int requestCode1 = 100;
    int requestCode2 = 200;
    int curentRequestcode;
    int num;

    Book book;

    int ImgIds[ ] = { R.drawable.art,R.drawable.science,R.drawable.music};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        etNum1 = findViewById(R.id.editNum1);
        etNum2 = findViewById(R.id.editNum2);
        etNum3 = findViewById(R.id.editNum3);
        etStr1 = findViewById(R.id.editSTR1);
        etStr2 = findViewById(R.id.editSTR2);
        //btn_third = findViewById(R.id.btnThird);

        spBook = findViewById(R.id.spImage);
        img = findViewById(R.id.imageView);


        spBook.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (i == 0) {
                    book = new Book("ART", 1, 2500,ImgIds[0]);
                    img.setImageResource(R.drawable.art);
                } else if (i == 1) {
                    img.setImageResource(R.drawable.science);
                    book = new Book("SCIENCE", 2, 300,ImgIds[1]);

                } else {

                    img.setImageResource(R.drawable.music);
                    book = new Book("MUSIC", 3, 3500,ImgIds[2]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onClick(View view) {
        Intent intent = null;
        if (view.getId() == R.id.btnSecond) {

            intent = new Intent(this, SecondActivity.class);
            curentRequestcode = requestCode1;
            int num1 = Integer.parseInt(etNum1.getText().toString());
            int num2 = Integer.parseInt(etNum2.getText().toString());
            int num3 = Integer.parseInt(etNum3.getText().toString());
            String str1 = etStr1.getText().toString();
            String str2 = etStr2.getText().toString();

            Bundle b = new Bundle();
            b.putInt("num1", num1);
            b.putInt("num2", num2);
            b.putInt("num3", num3);
            b.putString("str1",str1);
            b.putString("str2",str2);

            intent.putExtras(b);

        } else if (view.getId() == R.id.btnThird) {
            intent = new Intent(this, ThirdActivity.class);
            curentRequestcode = requestCode2;
        } else if (view.getId() == R.id.btnCreate) {
            intent = new Intent(this, ThirdActivity.class);
            curentRequestcode = requestCode2;
            Bundle b = new Bundle();
            b.putParcelable("book", book);
            intent.putExtras(b);
        }

        startActivityForResult(intent, curentRequestcode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            String msg = data.getStringExtra("res");

            if (requestCode == requestCode1) {
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            } else {
                makeAndShowDialog("Comes from ThirdActivity");
            }
        }

    }

    private void makeAndShowDialog(String message) {

        AlertDialog.Builder box = new AlertDialog.Builder(this);
        box.setTitle("LG4");
        box.setMessage(message);

        box.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        box.create();
        box.show();

    }
}
