package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Dystrybutory extends AppCompatActivity {

    Button bblokowanie,bodcztytaj;
    ImageButton bcofnij;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dystrybutory);

        bblokowanie=(Button) findViewById(R.id.bBlokowane);
        bodcztytaj=(Button) findViewById(R.id.bOdczytaj);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        bblokowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dystrybutory.this,BlokowanieDystrybutorow.class);
                startActivityForResult(intent, 1);
            }
        });

        bodcztytaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dystrybutory.this,DystrybutorDane.class);
                startActivityForResult(intent, 1);
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Logowanie.rodzaj.equals("p")) {
                    Intent intent = new Intent(Dystrybutory.this, OpcjePracownik.class);
                    startActivityForResult(intent, 1);
                }
                else{
                    Intent intent = new Intent(Dystrybutory.this, OpcjeWlasciciel.class);
                    startActivityForResult(intent, 1);
                }
            }
        });

    }
}
