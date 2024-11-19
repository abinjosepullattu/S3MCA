package com.example.frame_layout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView im;
    LinearLayout ll1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Comment out EdgeToEdge if not necessary
        // EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        im = findViewById(R.id.bdhome);
        ll1 = findViewById(R.id.ll1);
        t1 = findViewById(R.id.text1);

        im.setOnClickListener(this);
        ll1.setOnClickListener(this);

        // Check font path and load the font

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bdhome) {
            im.setVisibility(View.GONE);
            ll1.setVisibility(View.VISIBLE);
        } else {
            im.setVisibility(View.VISIBLE);
            ll1.setVisibility(View.GONE);
        }
    }
}
