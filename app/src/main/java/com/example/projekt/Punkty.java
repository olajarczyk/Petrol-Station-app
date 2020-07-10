package com.example.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Punkty extends AppCompatActivity {

    Button bwymien;
    TextView tliczbapkt;
    Database2_Klienci db;
    double d;
    String ID;
    ImageButton bcofnij;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punkty);

        bwymien=(Button) findViewById(R.id.bWymien);
        tliczbapkt=(TextView) findViewById(R.id.tLiczbaPkt);
        db=new Database2_Klienci(this);
        ID = getIntent().getStringExtra("id");
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        bwymien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Punkty.this, Nagrody.class);
                startActivityForResult(intent, 1);
            }
        });


        SQLiteCursor kursor = db.tankowanieKlient(ID);
        if(kursor.getCount()>0){
            StringBuffer buff =new StringBuffer();
            while(kursor.moveToNext()){
                d= d+ Double.parseDouble(kursor.getString(1));
            }
            tliczbapkt.setText(String.valueOf(d));
        }

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Punkty.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
