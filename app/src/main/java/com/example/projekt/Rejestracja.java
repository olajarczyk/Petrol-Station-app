package com.example.projekt;

import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class Rejestracja extends AppCompatActivity {

    EditText eimie, enazwisko, eemail, ehaslo, epowtorzhaslo;
    ImageButton bdalej;
    Database2_Klienci db;
    String a,b;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rejestracja);

        db=new Database2_Klienci(this);

        eimie=(EditText) findViewById(R.id.eImie);
        enazwisko=(EditText) findViewById(R.id.eNazwisko);
        eemail=(EditText) findViewById(R.id.eEmail);
        ehaslo=(EditText) findViewById(R.id.eHaslo);
        epowtorzhaslo=(EditText) findViewById(R.id.ePowtorzHaslo);
        bdalej=(ImageButton) findViewById(R.id.bdalej);


        bdalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean czySieUdalo;
                a=ehaslo.getText().toString();
                b=epowtorzhaslo.getText().toString();
                if(a.equals(b)){
                    czySieUdalo=db.wstaw_klient_zarejestrowany(eimie.getText().toString(),enazwisko.getText().toString(),eemail.getText().toString(),ehaslo.getText().toString());

                    if(czySieUdalo){
                        Toast.makeText(Rejestracja.this,"Udało się",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Rejestracja.this,"Nie udało się",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Rejestracja.this,"Hasło złe",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
