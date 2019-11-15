package com.example.labg4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {

    Intent intent;
    TextView txtBook;
    ImageView img;

    String msg = "Object book receieved.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtBook = findViewById(R.id.txtBook);
        img = findViewById(R.id.imgBook);

        intent = getIntent();
        Bundle b = intent.getExtras();

        Book book = (Book) b.getParcelable("book");
        txtBook.setText(book.toString());
        img.setImageResource(book.getImgId());
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("res", msg);
        setResult(RESULT_OK, intent);
        finish();
    }
}
