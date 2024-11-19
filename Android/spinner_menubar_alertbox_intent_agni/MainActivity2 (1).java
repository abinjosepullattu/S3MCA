package com.example.ajay;
import static com.example.ajay.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
TextView details;
ImageView image1;
int image_pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int[] im ={R.drawable.sherlock,R.drawable.dracula};
        details = findViewById(R.id.details);
        image1 = findViewById(id.image1);

        Intent i = getIntent();
        String name = i.getStringExtra("book");
        image_pos = i.getIntExtra("image_pos",image_pos);

        details.setText("Book Name : "+name);
        image1.setImageResource(im[image_pos]);

    }
}