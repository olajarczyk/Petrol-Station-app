package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Systemy_bezpieczenstwa extends AppCompatActivity {

    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sys_bezp);

        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Logowanie.rodzaj.equals("p")) {
                    Intent intent = new Intent(Systemy_bezpieczenstwa.this, OpcjePracownik.class);
                    startActivityForResult(intent, 1);
                }
                else{
                    Intent intent = new Intent(Systemy_bezpieczenstwa.this, OpcjeWlasciciel.class);
                    startActivityForResult(intent, 1);
                }
            }
        });


    }
}
