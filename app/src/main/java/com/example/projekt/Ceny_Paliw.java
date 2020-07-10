package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class Ceny_Paliw extends AppCompatActivity {

    EditText ebenzyna,edisel,egaz;
    Button bustawbenzyna,bustawdisel,bustawgaz;
    TextView tcenabenzyny,tcenadisel,tcenagaz;
    public static double cenaBenzyny=4.23;
    public static double cenaDisel=4.12;
    public static double cenaGaz=1.80;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ceny_paliw);

        ebenzyna=(EditText) findViewById(R.id.eBenzyna);
        edisel=(EditText) findViewById(R.id.eDisel);
        egaz=(EditText) findViewById(R.id.eGaz);
        bustawbenzyna=(Button) findViewById(R.id.bUstawBenzyna);
        bustawdisel=(Button) findViewById(R.id.bUstawDisel);
        bustawgaz=(Button) findViewById(R.id.bUstawGaz);
        tcenabenzyny=(TextView) findViewById(R.id.tCenaBenzyny);
        tcenadisel=(TextView) findViewById(R.id.tCenaDisel);
        tcenagaz=(TextView) findViewById(R.id.tCenaGaz);
        tcenabenzyny.setText("Cena benzyny: " + cenaBenzyny);
        tcenadisel.setText("Cena disel: " + cenaDisel);
        tcenagaz.setText("Cena gazu: " + cenaGaz);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        bustawbenzyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cenaBenzyny= Double.parseDouble(ebenzyna.getText().toString());
                tcenabenzyny.setText("Cena benzyny: " + cenaBenzyny);
            }
        });

        bustawdisel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cenaDisel= Double.parseDouble(edisel.getText().toString());
                tcenadisel.setText("Cena disel: " + cenaDisel);
            }
        });

        bustawgaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cenaGaz= Double.parseDouble(egaz.getText().toString());
                tcenagaz.setText("Cena gazu: " + cenaGaz);
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ceny_Paliw.this, OpcjeWlasciciel.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}
