package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OpcjeKlient extends AppCompatActivity {

    ImageButton bpunkty, bmyjnia, bhistoria, bwyloguj;
    Button bzatankuj;
    String ID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcje_klient);

        ID = getIntent().getStringExtra("id");

        bpunkty=(ImageButton) findViewById(R.id.bPunkty);
        bmyjnia=(ImageButton) findViewById(R.id.bMyjnia);
        bhistoria=(ImageButton) findViewById(R.id.bHistoria);
        bzatankuj=(Button) findViewById(R.id.bZatankuj);
        bwyloguj=(ImageButton) findViewById(R.id.bWyloguj2);


        bmyjnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeKlient.this, RezerwacjaMyjni.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

        bhistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeKlient.this, HistoriaKlasa.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

        bpunkty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeKlient.this, Punkty.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });
        bzatankuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeKlient.this, Tankowanie.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

        bwyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeKlient.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }


}
