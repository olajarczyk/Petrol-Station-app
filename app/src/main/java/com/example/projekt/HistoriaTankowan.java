package com.example.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HistoriaTankowan extends AppCompatActivity {

    String ID;
    TextView tpole;
    Database2_Klienci db;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historia_tankowan);


        ID = getIntent().getStringExtra("id");
        tpole=(TextView) findViewById(R.id.tPole);
        db=new Database2_Klienci(this);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);



        SQLiteCursor kursor = db.tankowanieKlient(ID);
        if(kursor.getCount()>0){
            StringBuffer buff =new StringBuffer();
            while(kursor.moveToNext()){
                double d= Double.parseDouble(kursor.getString(1));
                double a=d*Ceny_Paliw.cenaBenzyny;
                buff.append("Zatankowano:  "+ kursor.getString(1)+" l \n");
                buff.append("Zapłacono:  "+ String.format(" %.2f",a) +" zł \n\n");

            }
            tpole.setText(buff);
        }
        else{
            tpole.setText("pusto");
        }

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriaTankowan.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });


    }
}
