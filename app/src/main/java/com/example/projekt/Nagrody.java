package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Nagrody extends AppCompatActivity {

    ImageButton bcofnij;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nagrody);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);


        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nagrody.this, OpcjeKlient.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}
