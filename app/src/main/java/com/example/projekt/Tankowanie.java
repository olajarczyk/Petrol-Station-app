package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Tankowanie extends AppCompatActivity {

Button bwybierz;
String ID;
ImageButton bcofnij;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tankowanie);

        bwybierz=(Button) findViewById(R.id.bWybierz);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);
        ID = getIntent().getStringExtra("id");

        bwybierz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tankowanie.this, Tankowanie_Wybierz.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });


        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tankowanie.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });
    }
}
