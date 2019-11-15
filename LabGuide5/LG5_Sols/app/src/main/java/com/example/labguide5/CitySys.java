package com.example.labguide5;

import android.util.Log;

import java.util.ArrayList;

public class CitySys {
    public static ArrayList<City> spinnerValues = new ArrayList<City>();

    public static void prepareData(){

        /*Collections.addAll(spinnerValues, new City("Ankara",R.drawable.ankara),new City("Istanbul",R.drawable.istanbul),
                new City("Izmir",R.drawable.izmir),new City("Konya",R.drawable.konya));*/
        /**********or ************/

        spinnerValues.add(new City("cities",R.drawable.turkey));
        spinnerValues.add(new City("Ankara",R.drawable.ankara));
        spinnerValues.add(new City("Istanbul",R.drawable.istanbul));
        spinnerValues.add(new City("Izmir",R.drawable.izmir));
        spinnerValues.add(new City("Konya",R.drawable.konya));
        Log.d("SPINNERARRAY", spinnerValues.size()+" "+spinnerValues.toString());

    }

    public static ArrayList<City> getSpinnerValues() {
        return spinnerValues;
    }

    public static City getItem(int selectedPos) {
        return spinnerValues.get(selectedPos);
    }
}
