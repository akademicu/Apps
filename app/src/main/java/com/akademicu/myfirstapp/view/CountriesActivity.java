package com.akademicu.myfirstapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.akademicu.myfirstapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class CountriesActivity extends AppCompatActivity {

    private HashMap<String, String> countryNameToCodeMap;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteCountry);
        TextView countryCodeTextView = findViewById(R.id.countryCode);


        String[] countryNames = getCountryNames();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,countryNames);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener((parent, view, position, id)->{
            String selectedCountry = (String) parent.getItemAtPosition(position);
            String countryCode = countryNameToCodeMap.get(selectedCountry);
            countryCodeTextView.setText("Country code: "+countryCode);
        });

    }

    private String[] getCountryNames() {
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countryNames = new ArrayList<>();
        countryNameToCodeMap = new HashMap<>();


        for (Locale locale : locales){
            String country = locale.getDisplayCountry();
            String countryCode = locale.getCountry();
            if (!country.trim().isEmpty() && !countryNames.contains(country)){
                countryNames.add(country);
                countryNameToCodeMap.put(country, countryCode);
            }
        }
        Collections.sort(countryNames);
        return countryNames.toArray(new String[0]);
    }

}