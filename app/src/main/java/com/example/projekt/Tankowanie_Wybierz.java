package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Tankowanie_Wybierz extends AppCompatActivity {

    ImageButton bbenzyna, bgaz, bdisel;
    String ID;
    ImageButton bcofnij;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benzyna_gaz_disel);

        bbenzyna=(ImageButton) findViewById(R.id.bBenzyna);
        bdisel=(ImageButton) findViewById(R.id.bDisel);
        bgaz=(ImageButton) findViewById(R.id.bUstawGaz);
        ID = getIntent().getStringExtra("id");
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        bbenzyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BlokowanieDystrybutorow.b==1){
                    Toast.makeText(Tankowanie_Wybierz.this,"Ten dystrybutor jest aktalnie zabokowany",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Tankowanie_Wybierz.this, Benzyna.class);
                    intent.putExtra("id", ID);
                    startActivityForResult(intent, 1);
                }
            }
        });

        bdisel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BlokowanieDystrybutorow.d==1){
                    Toast.makeText(Tankowanie_Wybierz.this,"Ten dystrybutor jest aktalnie zabokowany",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Tankowanie_Wybierz.this, Disel.class);
                    intent.putExtra("id", ID);
                    startActivityForResult(intent, 1);
                }
            }
        });

        bgaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BlokowanieDystrybutorow.g==1){
                    Toast.makeText(Tankowanie_Wybierz.this,"Ten dystrybutor jest aktalnie zabokowany",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Tankowanie_Wybierz.this, Gaz.class);
                    intent.putExtra("id", ID);
                    startActivityForResult(intent, 1);
                }
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tankowanie_Wybierz.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
