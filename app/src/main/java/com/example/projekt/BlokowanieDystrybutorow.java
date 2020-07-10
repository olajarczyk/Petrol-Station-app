package com.example.projekt;

import android.content.Intent;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class BlokowanieDystrybutorow extends AppCompatActivity {


    ImageButton bbenzyna, bdisel, bgaz;
    static int b,d,g;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dystrybutory_blokowanie);


        bbenzyna=(ImageButton) findViewById(R.id.bBenzyna);
        bdisel=(ImageButton) findViewById(R.id.bDisel);
        bgaz=(ImageButton) findViewById(R.id.bUstawGaz);
        bbenzyna.setBackgroundResource(R.drawable.benzyna);
        bdisel.setBackgroundResource(R.drawable.disel);
        bgaz.setBackgroundResource(R.drawable.gaz);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);
        b=0;
        d=0;
        g=0;

        bdisel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d==0) {
                    bdisel.setBackgroundResource(R.drawable.disel_zablokowany);
                    d = 1;
                }
                else{
                    bdisel.setBackgroundResource(R.drawable.disel);
                    d=0;
                }
            }
        });
        bbenzyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==0) {
                    bbenzyna.setBackgroundResource(R.drawable.benzyna_zablokowana);
                    b = 1;
                }
                else{
                    bbenzyna.setBackgroundResource(R.drawable.benzyna);
                    b=0;
                }
            }
        });
        bgaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(g==0) {
                    bgaz.setBackgroundResource(R.drawable.gaz_zablokowane);
                    g = 1;
                }
                else{
                    bgaz.setBackgroundResource(R.drawable.gaz);
                    g=0;
                }
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(Logowanie.rodzaj.equals("p")) {
                   Intent intent = new Intent(BlokowanieDystrybutorow.this, OpcjePracownik.class);
                   startActivityForResult(intent, 1);
               }
               else{
                   Intent intent = new Intent(BlokowanieDystrybutorow.this, OpcjeWlasciciel.class);
                   startActivityForResult(intent, 1);
               }
            }
        });


    }
}
