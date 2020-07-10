package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DystrybutorDane extends AppCompatActivity {


    ImageButton bbenzyna,bdisel,bgaz;
    TextView tzatankowano,tdozaplaty;
    double litry=0;
    double cenaD=0;
    String rodzaj;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dane_z_dystrybutorow);

        bbenzyna=(ImageButton) findViewById(R.id.bBenzyna);
        bdisel=(ImageButton) findViewById(R.id.bDisel);
        bgaz=(ImageButton) findViewById(R.id.bUstawGaz);
        tdozaplaty=(TextView) findViewById(R.id.tDoZaplaty);
        tzatankowano=(TextView) findViewById(R.id.tZatankowano);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);
        rodzaj=Portfel.rodzaj;

        bbenzyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(Portfel.cena!=null) {
                  if(rodzaj.equals("b")) {
                      cenaD = Double.parseDouble(Portfel.cena);
                      litry = Double.parseDouble(Portfel.Punkty);
                  }
              }
                tzatankowano.setText("Zatankowano: " + litry + " l");
                tdozaplaty.setText("Do zapłaty: " + cenaD+ " zł");
                litry=0;
                cenaD=0;

            }
        });

        bdisel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Portfel.cena!=null) {
                    if(rodzaj.equals("d")) {
                        cenaD = Double.parseDouble(Portfel.cena);
                        litry = Double.parseDouble(Portfel.Punkty);
                    }
                }
                tzatankowano.setText("Zatankowano: " + litry + " l");
                tdozaplaty.setText("Do zapłaty: " + cenaD+ " zł");
                litry=0;
                cenaD=0;


            }
        });


        bgaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Portfel.cena!=null) {
                    if(rodzaj.equals("g")) {
                        cenaD = Double.parseDouble(Portfel.cena);
                        litry = Double.parseDouble(Portfel.Punkty);
                    }
                }
                tzatankowano.setText("Zatankowano: " + litry + " l");
                tdozaplaty.setText("Do zapłaty: " + cenaD+ " zł");
                litry=0;
                cenaD=0;


            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Logowanie.rodzaj.equals("p")) {
                    Intent intent = new Intent(DystrybutorDane.this, OpcjePracownik.class);
                    startActivityForResult(intent, 1);
                }
                else{
                    Intent intent = new Intent(DystrybutorDane.this, OpcjeWlasciciel.class);
                    startActivityForResult(intent, 1);
                }
            }
        });

    }
}