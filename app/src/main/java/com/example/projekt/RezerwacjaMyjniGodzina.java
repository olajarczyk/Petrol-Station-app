package com.example.projekt;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;


import java.util.Calendar;

public class RezerwacjaMyjniGodzina extends AppCompatActivity {

    ImageButton bdalej;
    Button chooseTime;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String godzina;
    TextView data;
    EditText dlugosc;
    String jakDlugo;
    String name, ID;
    ImageButton bcofnij;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myjnia_godzina);

        ID = getIntent().getStringExtra("id");

        name = getIntent().getStringExtra("name");
        data=findViewById(R.id.Data);
        data.setText(name);


        chooseTime = findViewById(R.id.godzina);
        dlugosc=(EditText) findViewById(R.id.Dlugosc);
        bdalej=(ImageButton) findViewById(R.id.imageButton);
        bcofnij=(ImageButton) findViewById(R.id.bCofnij);

        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(RezerwacjaMyjniGodzina.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                        chooseTime.setText(String.format("%02d:%02d", hourOfDay, minutes) );
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        bdalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezerwacjaMyjniGodzina.this, RezerwacjaMyjniNumer.class);
                jakDlugo=dlugosc.getText().toString();
                godzina=chooseTime.getText().toString();
                intent.putExtra("data", name);
                intent.putExtra("godzina", godzina);
                intent.putExtra("ile", jakDlugo);
                intent.putExtra("id",ID);
                startActivityForResult(intent, 1);

            }
        });
        bcofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezerwacjaMyjniGodzina.this, OpcjeKlient.class);
                intent.putExtra("id", ID);
                startActivityForResult(intent, 1);
            }
        });

    }
}
