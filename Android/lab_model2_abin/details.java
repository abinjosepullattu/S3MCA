package com.example.labmodel2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class details extends AppCompatActivity{
TextView name,phn,gender,interest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        name=(TextView)findViewById(R.id.name);
        gender=(TextView)findViewById(R.id.gender);
        phn=(TextView)findViewById(R.id.phn);
        interest=(TextView)findViewById(R.id.interest);
        SharedPreferences sp=getSharedPreferences("my_pref",MODE_PRIVATE);
        if(sp.contains("name"))
            name.setText(sp.getString("name",""));
        if(sp.contains("phn"))
            phn.setText(sp.getString("phn",""));
        if(sp.contains("gender"))
            gender.setText(sp.getString("gender",""));
        if(sp.contains("interest"))
            interest.setText(sp.getString("interest",""));


    }

}