package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class Portfel extends AppCompatActivity {

    Button bzaplac;
    TextView tdozaplaty;
    Database2_Klienci db;
    String ID;
    static String Punkty;
    static String rodzaj;
    static String cena;
    int IDKlienta;
    int pkt;
    double cenaD;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfel);

        bzaplac=(Button) findViewById(R.id.bZaplac);
        tdozaplaty=(TextView) findViewById(R.id.tDoZaplaty);
        db=new Database2_Klienci(this);
        ID = getIntent().getStringExtra("id");
        Punkty = getIntent().getStringExtra("punkty");
        cena = getIntent().getStringExtra("cena");
        rodzaj = getIntent().getStringExtra("rodzaj");
        cenaD=parseDouble(cena);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);


        tdozaplaty.setText("Do zapłaty: "+ String.format(" %.2f",cenaD)+" zł");



        bzaplac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean czySieUdalo;
                IDKlienta= Integer.parseInt(ID);
                pkt= Integer.parseInt(Punkty);

                czySieUdalo=db.wstaw_karta_lojalnosciowa(IDKlienta,pkt);

                if(czySieUdalo){
                    Toast.makeText(Portfel.this,"Udało się",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Portfel.this,"Nie udało się",Toast.LENGTH_LONG).show();
                }
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Portfel.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
