package com.example.labguide5;

import java.util.ArrayList;

public class CountrySys {
    private static ArrayList<Country> arrRecyclerCountry = new ArrayList<Country>();

    public static void prepareData() {
        arrRecyclerCountry.add(new Country(R.drawable.turkey, "Turkey", "Money is TL"));
        arrRecyclerCountry.add(new Country(R.drawable.america, "America", "Money is Dollar"));
        arrRecyclerCountry.add(new Country(R.drawable.italy, "Italy", "Money is Euro"));
        arrRecyclerCountry.add(new Country(R.drawable.france, "France", "Money is Euro"));
        arrRecyclerCountry.add(new Country(R.drawable.germany, "Germany", "Money is Euro"));
        arrRecyclerCountry.add(new Country(R.drawable.india, "India", "Money is Rupi"));

    }

    public static ArrayList<Country> getArrRecyclerCountry() {
        return arrRecyclerCountry;
    }
}
