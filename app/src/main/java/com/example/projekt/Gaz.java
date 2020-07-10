package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Gaz extends AppCompatActivity {

    Button btankuj, bstop, bzaplac;
    TextView tdozaplaty, tzatankowano;
    int czas=0;
    double cena;
    String cenaS;
    Thread t;
    boolean continueThread=true;
    String ID,pkt;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gaz);

        btankuj=(Button) findViewById(R.id.bTankuj);
        bstop=(Button) findViewById(R.id.bStop);
        bzaplac=(Button) findViewById(R.id.bZaplac);
        tzatankowano=(TextView) findViewById(R.id.tZatankowano);
        tdozaplaty=(TextView) findViewById(R.id.tDoZaplaty);
        ID = getIntent().getStringExtra("id");
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        t=new Thread(){
            @Override
            public void run(){
                while(continueThread){
                    try {
                        Thread.sleep(1000);  //1000ms = 1 sec
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                czas++;
                                double a=Ceny_Paliw.cenaGaz;
                                cena=czas*a;
                                cenaS=String.valueOf(cena);
                                tzatankowano.setText("Zatankowano: "+ String.valueOf(czas)+" l");
                                tdozaplaty.setText("Do zapłaty: "+ String.format(" %.2f",cena)+" zł");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        btankuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(continueThread==true) {
                    t.start();
                }
            }
        });

        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                continueThread=false;

            }
        });

        bzaplac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pkt=Integer.toString(czas);
                Intent intent = new Intent(Gaz.this, Portfel.class);
                intent.putExtra("id", ID);
                intent.putExtra("punkty", pkt);
                intent.putExtra("cena", cenaS);
                intent.putExtra("rodzaj", "g");
                startActivityForResult(intent, 1);
            }
        });
        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gaz.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
