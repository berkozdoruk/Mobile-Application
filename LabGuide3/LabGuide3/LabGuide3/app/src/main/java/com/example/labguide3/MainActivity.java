package com.example.labguide3;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button, btnClean;
    LinearLayout linearLayout;
    ImageView imageView;
    int image = 0;  //pic of hogwarts
    int i = 0; //background
    TextView textView1, textView2;
    Spinner spinner;
    boolean isDefaultSelection = true;
    EditText etName;
    CheckBox check;


    ValueAnimator colorAnim;
    static final int RED = 0xffFF0000;
    static final int BLUE = 0xff0000FF;

    int background[] = {R.drawable.vit1, R.drawable.vit2, R.drawable.vitamins1};
    int vitamins[] = {R.drawable.milk, R.drawable.egg, R.drawable.fish, R.drawable.sun};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title bar using code
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //get Views id
        textView1 = (TextView) findViewById(R.id.tvAnimation1);  //coloranimation
        textView2 = (TextView) findViewById(R.id.tvAnimation2);  //bink
        imageView = (ImageView) findViewById(R.id.imageView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        etName = (EditText) findViewById(R.id.etName);
        btnClean = (Button) findViewById(R.id.btnClean);

        //blink animation
        blink();

        // Code for TextView text color animation
        // colorAnim = ObjectAnimator.ofInt(tv, "backgroundColor",RED, BLUE);
        colorAnim = ObjectAnimator.ofInt(textView1, "textColor", RED, BLUE);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

        //change background button event handling
        button = findViewById(R.id.btnChangeBackg);
        button = (Button) findViewById(R.id.btnChangeBackg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout.setBackground(getResources().getDrawable(R.drawable.image, getTheme());
                linearLayout.setBackground(getResources().getDrawable(background[i]));
                displayToast("Background is changed");
                i++;
                if (i == 3)
                    i = 0;
            }
        });

        //Typing handling
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean flagCleanButtonPressed = btnClean.isPressed();
                if (flagCleanButtonPressed)
                    flagCleanButtonPressed = false;
                else
                    displayToast("Your just typed\n" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //CheckBox Handling
        check = (CheckBox) findViewById(R.id.checkBox);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked())
                    displayToast("You click checkbox!");
                else
                    displayToast("You are not clicked checkbox");
            }
        });

        /* */

        //Spinner handling
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String res = "";
                if (isDefaultSelection)
                    isDefaultSelection = false;
                else {
                    res = spinner.getSelectedItem().toString() + " is selected";
                    if (position == 0)
                        makeAndShowDialogBox("You should choose a vitamin.");
                    else {
                        makeAndShowDialogBox(res);
                        imageView.setImageResource(vitamins[position - 1]);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }   //onCreate

    //for animation
    private void blink() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in milliseconds
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //TextView textView2 = (TextView) findViewById(R.id.tvAnimation2);
                        if (textView2.getVisibility() == View.VISIBLE)
                            textView2.setVisibility(View.INVISIBLE);
                        else
                            textView2.setVisibility(View.VISIBLE);
                        blink();
                    }
                });
            }
        }).start();
    }

    // Method to display Toast message
    private void displayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    // Method to display an AlertDialog
    private void makeAndShowDialogBox(String message) {
        AlertDialog.Builder mDialogBox = new AlertDialog.Builder(this);
        // set message, title, and icon
        mDialogBox.setTitle("CTIS487-LG3");
        mDialogBox.setMessage(message);
        mDialogBox.setIcon(R.drawable.vitamind);

        // Set three option buttons
        mDialogBox.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "YES" goes
                        // here
                    }
                });
        mDialogBox.create();
        mDialogBox.show();
    }

    //onClick
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                if (image == 1) {
                    image = 0;
                    imageView.setImageResource(R.drawable.vitamins2);
                    textView2.setText("VITAMIN C");
                    spinner.setVisibility(View.INVISIBLE);
                } else {
                    image++;
                    imageView.setImageResource(R.drawable.vitamins1);
                    textView2.setText("VITAMIN D");
                    spinner.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.btnClean:  //Save button
                etName.setText("");
                break;
        }//switch for view.getid
    }
}
