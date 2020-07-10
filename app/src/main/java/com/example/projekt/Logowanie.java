package com.example.projekt;


import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class Logowanie extends AppCompatActivity {

    ImageButton bdalej;
    Database2_Klienci db;
    Database1_Zatrudnieni db2;
    EditText login, haslo;
    String ID;
    static String rodzaj="";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logowanie);

        bdalej=(ImageButton) findViewById(R.id.imageButton);
        db=new Database2_Klienci(this);
        db2=new Database1_Zatrudnieni(this);
        login=(EditText) findViewById(R.id.eLogin);
        haslo=(EditText) findViewById(R.id.eHaslo);


        bdalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean czySieUdalo;
                SQLiteCursor kursor =db.sprawdzLogin(login.getText().toString(),haslo.getText().toString());

               if(kursor.getCount()>0){
                    Toast.makeText(Logowanie.this,"Zalogowano pomyślnie",Toast.LENGTH_LONG).show();
                    StringBuffer buff =new StringBuffer();
                   while(kursor.moveToNext()){
                        buff.append(kursor.getString(0));
                   }
                    ID=buff.toString();
                    Intent intent = new Intent(Logowanie.this, OpcjeKlient.class);
                    intent.putExtra("id", ID);
                    startActivityForResult(intent, 1);

                }
                else{
                   SQLiteCursor kursor2 =db2.sprawdzLoginPracownik(login.getText().toString(),haslo.getText().toString());
                   if(kursor2.getCount()>0){
                         Toast.makeText(Logowanie.this, "Zalogowano pomyślnie jako pracownik", Toast.LENGTH_LONG).show();
                         rodzaj="p";
                         Intent intent = new Intent(Logowanie.this, OpcjePracownik.class);
                         startActivityForResult(intent, 1);
                   }
                   else {
                       SQLiteCursor kursor3 =db2.sprawdzLoginWlasciciel(login.getText().toString(),haslo.getText().toString());
                       if(kursor3.getCount()>0){
                           Toast.makeText(Logowanie.this, "Zalogowano pomyślnie jako właściciel", Toast.LENGTH_LONG).show();
                           rodzaj="w";
                           Intent intent = new Intent(Logowanie.this, OpcjeWlasciciel.class);
                           startActivityForResult(intent, 1);
                       }
                       else {
                           Toast.makeText(Logowanie.this, "Błędny login lub hasło", Toast.LENGTH_LONG).show();
                       }
                   }
                }
            }
        });
    }
}
