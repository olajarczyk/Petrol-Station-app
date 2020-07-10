package com.example.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button brejestracja;
    Button blogowanie;
    Database2_Klienci db;
    Database1_Zatrudnieni db2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db2=new Database1_Zatrudnieni(this);
        db2.wstaw_dane_pracownika("Aaa","Bbb","1234","aaa","n");
        db2.wstaw_dane_pracownika("Xxx","Zzz","4321","aaa","t");

        brejestracja=(Button) findViewById(R.id.bRejestracja);
        blogowanie=(Button) findViewById(R.id.bLogowanie);
        db=new Database2_Klienci(this);


        brejestracja.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Rejestracja.class);
                startActivityForResult(intent, 1);

            }
        });

        blogowanie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Logowanie.class);
                startActivityForResult(intent, 1);

            }
        });

    }

}
