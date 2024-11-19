package com.example.lab_model1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    EditText e1;
    Button b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        e1 = findViewById(R.id.text1);
        b2 = findViewById(R.id.back);
        b3 = findViewById(R.id.sub);

        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ll2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        if (view.getId() == R.id.sub) {
            String string1 = e1.getText().toString(); // Retrieve the text here
            Intent i = new Intent(this, MainActivity3.class);
            i.putExtra("text", string1);
            startActivity(i);
        }
    }
}
