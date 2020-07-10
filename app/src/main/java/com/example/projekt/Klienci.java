package com.example.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Klienci extends AppCompatActivity {

    TextView tpole;
    Database2_Klienci db;
    String idklienta;
    double d;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.klienci);

        tpole=(TextView) findViewById(R.id.tPole);
        db=new Database2_Klienci(this);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);


        SQLiteCursor kursor = db.pobierz_klient_zarejestrowany();
        if(kursor.getCount()>0){
            StringBuffer buff =new StringBuffer();
            while(kursor.moveToNext()){
                idklienta=kursor.getString(0);
                buff.append("ID: "+ kursor.getString(0)+"\n");
                buff.append("Imie: "+ kursor.getString(1)+"\n");
                buff.append("Nazwisko: "+ kursor.getString(2)+"\n");
                buff.append("Email: "+ kursor.getString(3)+"\n");

                SQLiteCursor kursor2 = db.tankowanieKlient(idklienta);
                if(kursor2.getCount()>0){
                    while(kursor2.moveToNext()){
                        d= d+ Double.parseDouble(kursor2.getString(1));
                    }
                    buff.append("Liczba punktów: " + d+ "\n\n");
                }

            }
            tpole.setText(buff);
        }
        else{
            tpole.setText("pusto");
        }

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klienci.this, OpcjeWlasciciel.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}
