package com.example.anshukumar.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String item;
    Button bn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        bn=(Button)findViewById(R.id.button);
        img=(ImageView)findViewById(R.id.imageView);
        img.setVisibility(View.GONE);
        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this,R.array.cricketers,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item=adapterView.getItemAtPosition(i).toString();
                bn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img.setVisibility(View.VISIBLE);
                        switch (item) {
                            case "Ms Dhoni":
                                img.setImageResource(R.drawable.msd);
                                break;
                            case "Sachin Tendulkar":
                                img.setImageResource(R.drawable.tendulkar);
                                break;
                            case "Zaheer Khan":
                                img.setImageResource(R.drawable.khan);
                        }
                     }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
