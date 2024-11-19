package com.example.lab_model1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText name,pass;
    Button b;
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.uname);
        pass=(EditText)findViewById(R.id.pass);
        b=(Button)findViewById(R.id.btn);
        b.setOnClickListener(this);
    }
    public void onClick(View view){
        if(view.getId()==R.id.btn){
            if(name.getText().toString().equals("abin") && pass.getText().toString().equals("123") ){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this,MainActivity2.class);
                startActivity(i);
            }
            else {
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
            }
        }


    }

        }