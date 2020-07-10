package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RezerwacjaMyjniNumer extends AppCompatActivity {

    ImageButton bdalej;
    TextView data2, godzina2, ile2;
    Button bokej;
    Database2_Klienci db;
    String ID, data, godzina, ile;
    int IDKlienta;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myjnia_rezerwacja);

        bcofnij=(ImageButton) findViewById(R.id.bCofnij);
        ID = getIntent().getStringExtra("id");

        data = getIntent().getStringExtra("data");
        data2= (TextView) findViewById(R.id.Data);
        data2.setText(data);

        godzina = getIntent().getStringExtra("godzina");
        godzina2= (TextView) findViewById(R.id.Godzina);
        godzina2.setText(godzina);

        ile = getIntent().getStringExtra("ile");
        ile2= (TextView) findViewById(R.id.Ile);
        ile2.setText(ile);

        db=new Database2_Klienci(this);
        bokej=(Button) findViewById(R.id.Okej);

        bokej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean czySieUdalo;
                IDKlienta= Integer.parseInt(ID);

                czySieUdalo=db.wstaw_myjnia(IDKlienta,data, godzina, ile);

                if(czySieUdalo){
                    Toast.makeText(RezerwacjaMyjniNumer.this,"Udało się",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(RezerwacjaMyjniNumer.this,"Nie udało się",Toast.LENGTH_LONG).show();
                }
            }
        });

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezerwacjaMyjniNumer.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });
    }
}
