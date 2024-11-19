package com.example.labmodel2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, phn;
    RadioGroup rg;
    RadioButton m, f;
    CheckBox dance, sing, play, read;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Corrected method name here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phn = findViewById(R.id.phn);
        rg = findViewById(R.id.gender);
        dance = findViewById(R.id.dance);
        sing = findViewById(R.id.sing);
        play = findViewById(R.id.play);
        read = findViewById(R.id.read);
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);
        m=findViewById(R.id.male);
        m.setChecked(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sub) {
            String n = name.getText().toString();
            String p = phn.getText().toString();  // Changed to String to handle phone number as text
            RadioButton genderSelected = findViewById(rg.getCheckedRadioButtonId());
            String gen = genderSelected.getText().toString();
            StringBuilder interest = new StringBuilder();

            if (sing.isChecked()) {
                interest.append("Singing\n\n");
            }
            if (dance.isChecked()) {
                interest.append("Dancing\n\n");
            }
            if (play.isChecked()) {
                interest.append("Playing\n\n");
            }
            if (read.isChecked()) {
                interest.append("Reading\n\n");
            }

            String in = interest.toString();
            SharedPreferences sp = getSharedPreferences("my_pref", MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("name", n);
            ed.putString("phn", p);  // Fixed saving the phone as a string
            ed.putString("gender", gen);
            ed.putString("interest", in);
            ed.apply();

            Intent i = new Intent(this, details.class);
            startActivity(i);
        }
    }
}
