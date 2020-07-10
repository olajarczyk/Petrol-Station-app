package com.example.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;

public class RezerwacjaMyjni extends AppCompatActivity {

    ImageButton bdalej;
    CalendarView calendarView;
    String data, ID;
    Database2_Klienci db;
    Button brezerwacje;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myjnia);

        ID = getIntent().getStringExtra("id");

        bdalej=(ImageButton) findViewById(R.id.imageButton);
        calendarView=(CalendarView) findViewById(R.id.kalendarz);
        brezerwacje=(Button) findViewById(R.id.bRezerwacje);
        db=new Database2_Klienci(this);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month++;
                data=dayOfMonth+"/"+ month +"/"+year;
            }
        });

        bdalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezerwacjaMyjni.this, RezerwacjaMyjniGodzina.class);
                intent.putExtra("name", data);
                intent.putExtra("id",ID);
                startActivityForResult(intent, 1);

            }
        });

        brezerwacje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteCursor kursor = db.myjniaKlient(ID);
                if(kursor.getCount()>0){
                    StringBuffer buff =new StringBuffer();
                    while(kursor.moveToNext()){
                        buff.append("ID: "+ kursor.getString(0)+"\n");
                        buff.append("Data: "+ kursor.getString(1)+"\n");
                        buff.append("Godzina: "+ kursor.getString(2)+"\n");
                        buff.append("Czas: "+ kursor.getString(3)+"\n\n");
                    }
                    PokazBaze("Rezerwacje",buff.toString());
                }
                else{
                    PokazBaze("Brak","Nie masz żadnych rezerwacji. Dodaj rezerwację.");
                }
            }
        });
        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezerwacjaMyjni.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });
    }
    public void PokazBaze(String tytul, String wiadomosc){
        AlertDialog.Builder budowniczy= new AlertDialog.Builder(this);
        budowniczy.setCancelable(true);
        budowniczy.setMessage(wiadomosc);
        budowniczy.setTitle(tytul);
        budowniczy.show();
    }
}
