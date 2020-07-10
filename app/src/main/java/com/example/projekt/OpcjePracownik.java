package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OpcjePracownik extends AppCompatActivity {

    ImageButton bdystrybutory,  bportfel, bsystemy, bmonitoring, bwyloguj;
    Button braporty;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcje_pracownik);

        bdystrybutory=(ImageButton) findViewById(R.id.bDystrybutory);
        braporty=(Button) findViewById(R.id.bRaporty2);
        bportfel=(ImageButton) findViewById(R.id.bPortfel3);
        bmonitoring=(ImageButton) findViewById(R.id.bMonitoring);
        bsystemy=(ImageButton) findViewById(R.id.bSystemy);
        bwyloguj=(ImageButton) findViewById(R.id.bWyloguj);

        bdystrybutory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjePracownik.this, Dystrybutory.class);
                startActivityForResult(intent, 1);
            }
        });

        braporty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjePracownik.this, Raporty.class);
                startActivityForResult(intent, 1);
            }
        });

        bportfel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjePracownik.this, Faktury.class);
                startActivityForResult(intent, 1);
            }
        });

        bmonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjePracownik.this, Monitoring.class);
                startActivityForResult(intent, 1);
            }
        });

        bsystemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjePracownik.this, Systemy_bezpieczenstwa.class);
                startActivityForResult(intent, 1);
            }
        });

        bwyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcjePracownik.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}
