package com.example.projekt;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HistoriaMyjni extends AppCompatActivity {

    String ID;
    TextView tpole;
    Database2_Klienci db;
    ImageButton bcofnij;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hist_myjni);

        ID = getIntent().getStringExtra("id");
        tpole=(TextView) findViewById(R.id.tPole2);
        db=new Database2_Klienci(this);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        SQLiteCursor kursor = db.myjniaKlient(ID);
        if(kursor.getCount()>0){
            StringBuffer buff =new StringBuffer();
            while(kursor.moveToNext()){
                buff.append("Data: "+ kursor.getString(1)+"\n");
                buff.append("Godzina: "+ kursor.getString(2)+"\n");
                buff.append("Czas: "+ kursor.getString(3)+"\n\n");

            }
            tpole.setText(buff);
        }
        else{
            tpole.setText("pusto");
        }

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriaMyjni.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
