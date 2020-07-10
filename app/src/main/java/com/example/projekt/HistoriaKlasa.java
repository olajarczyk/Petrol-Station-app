package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HistoriaKlasa extends AppCompatActivity {

    Button bhistankowan,bhismyjni,bfaktury;
    String ID;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historia);


        bhistankowan=(Button) findViewById(R.id.bHisTankowan);
        bhismyjni=(Button) findViewById(R.id.bHisMyjni);
        bfaktury=(Button) findViewById(R.id.bFaktury);
        ID = getIntent().getStringExtra("id");
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        bhistankowan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriaKlasa.this, HistoriaTankowan.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

        bhismyjni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriaKlasa.this, HistoriaMyjni.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

        bfaktury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriaKlasa.this, Faktury.class);
               // intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriaKlasa.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
