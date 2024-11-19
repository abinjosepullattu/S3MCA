package com.example.ajay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
TextView showbook;
EditText bookname;
Button btn,nextbtn;
String b;
Spinner spinner1;
int image_pos;
ImageView image;
String[] ar = {"Ajay","Anu"};
int[] im ={R.drawable.sherlock,R.drawable.dracula};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bookname = findViewById(R.id.bookname);
        showbook = findViewById(R.id.showbook);
        btn = findViewById(R.id.btn);
        nextbtn = findViewById(R.id.nextbtn);
        spinner1 = findViewById(R.id.spinner1);
        image =findViewById(R.id.image1);


        btn.setOnClickListener(this);
        nextbtn.setOnClickListener(this);
        spinner1.setOnItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();
        if (item_id == R.id.settings){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item_id == R.id.about)
        {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        } else if (item_id == R.id.warn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("This is a Warning").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showbook.setText("OOPs");
                }
            }).setNegativeButton("Cancel",null);
            AlertDialog alert = builder.create();
            alert.show();
            return true;

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn.getId())
        {

            b = bookname.getText().toString();
            showbook.setText("Bookname : "+ b);
            Toast.makeText(this,"showing the book name",Toast.LENGTH_LONG).show();

        }
        if(v.getId() == nextbtn.getId())
        {
            Intent i =  new Intent(this, MainActivity2.class);
            i.putExtra("book",b);
            i.putExtra("image_pos",image_pos);
            startActivity(i);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        showbook.setText(ar[position]);
        image_pos = position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}