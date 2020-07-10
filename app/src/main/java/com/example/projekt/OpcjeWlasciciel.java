package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OpcjeWlasciciel extends AppCompatActivity {

    Button bdystrybutory, bmonitoring, bfaktury, braporty;
    ImageButton bceny, bklienci, bwyloguj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcje_wlasciciel);

        bdystrybutory=(Button) findViewById(R.id.bDytrybutory2);
        bmonitoring=(Button) findViewById(R.id.bMonitoring2);
        bfaktury=(Button) findViewById(R.id.bFaktury2);
        braporty=(Button) findViewById(R.id.bRaporty2);
        bceny=(ImageButton) findViewById(R.id.bCeny);
        bklienci=(ImageButton) findViewById(R.id.bKlienci);
        bwyloguj=(ImageButton) findViewById(R.id.bWyloguj);


        bdystrybutory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, Dystrybutory.class);
                startActivityForResult(intent, 1);
            }
        });

        bmonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, Monitoring.class);
                startActivityForResult(intent, 1);
            }
        });

        bfaktury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, Faktury.class);
                startActivityForResult(intent, 1);
            }
        });

        braporty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, Raporty.class);
                startActivityForResult(intent, 1);
            }
        });

        bceny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, Ceny_Paliw.class);
                startActivityForResult(intent, 1);
            }
        });

        bklienci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, Klienci.class);
                startActivityForResult(intent, 1);
            }
        });
        bwyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjeWlasciciel.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}
