package ctis487.labguide7;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //Custom RecyclerView
    private RecyclerView recyclerHouses;
    LinearLayoutManager layoutManager;
    MyRecyclerViewAdapter adapter;
    private ArrayList<House> recyclervalues = new ArrayList<>();




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

        prepareData();

        recyclerHouses = findViewById(R.id.recyclerGot);

        layoutManager = new LinearLayoutManager(this);

        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerHouses.setLayoutManager(layoutManager);

        /*
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerSocial.setLayoutManager(gridLayoutManager);
        */

        /*
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerSocial.setLayoutManager(staggeredGridLayoutManager);
        */

        recyclerHouses.hasFixedSize();

        adapter = new MyRecyclerViewAdapter(this, recyclervalues);

        recyclerHouses.setAdapter(adapter);
    }

    public void prepareData() {
        Collections.addAll(recyclervalues, new House(R.drawable.baratheon, "Baretheaon", "Ours is the Fury"),
                new House(R.drawable.lannister, "Lannister", "Hear Me Roar"),
                new House(R.drawable.martell, "Martell", "Unbowed,Unbent,Unbroken"),
                new House(R.drawable.stark, "Stark", "Winter is Coming"),
                new House(R.drawable.targeryan, "Targeryan", "Fire and Blood"),
                new House(R.drawable.tyrell, "Tyrell", "Growing Strong"));
        /**********or ************/
        /*
        recyclervalues.add(new House(R.drawable.lannister, "Lannister", "Hear Me Roar"));
        ...
        //This data can be taken from file, database or network.*/
    }


}
