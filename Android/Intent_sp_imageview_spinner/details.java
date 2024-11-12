package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class details extends AppCompatActivity {

    TextView name, phn, gender, interest, Salary;
    Spinner spinner;
    ImageView img;
    String[] jobTitles = {"Software Engineer", "Data Scientist", "Project Manager", "Designer", "QA Engineer"};
    String[] jobSalaries = {"$80,000", "$90,000", "$75,000", "$70,000", "$65,000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize UI elements
        name = findViewById(R.id.name);
        phn = findViewById(R.id.phone);
        gender = findViewById(R.id.gender);
        interest = findViewById(R.id.intrest);
        Salary = findViewById(R.id.salary);
        spinner = findViewById(R.id.dropdown);
        img = findViewById(R.id.img);
        // Set up job titles in Spinner using ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jobTitles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set up listener for Spinner selection
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Salary.setText("Salary: " + jobSalaries[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Salary.setText("Select a job to view salary");
            }
        });

        // Retrieve and display data from SharedPreferences
        SharedPreferences sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        if (sp.contains("Name")) {
            name.setText(sp.getString("Name", ""));
        }
        if (sp.contains("Phone")) {
            phn.setText(sp.getString("Phone", ""));
        }
        if (sp.contains("Interest")) {
            interest.setText(sp.getString("Interest", ""));
        }
        if (sp.contains("Gender")) {
            gender.setText(sp.getString("Gender", ""));
        }
        img.setImageResource(R.drawable.bin);
    }

}
