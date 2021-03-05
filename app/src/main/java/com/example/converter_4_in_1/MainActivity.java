package com.example.converter_4_in_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView IvLength, IvVolume, IvWeight,IvTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IvLength = findViewById(R.id.ivLength);
        IvTemperature = findViewById(R.id.ivTemperature);
        IvVolume = findViewById(R.id.ivVolume);
        IvWeight = findViewById(R.id.ivWeight);

        /*tvLength = findViewById(R.id.tvLength);
        tvTemperature = findViewById(R.id.tvTemperature);
        tvVolume = findViewById(R.id.tvVolume);
        tvWeight = findViewById(R.id.tvWeight);*/


        IvLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.converter_4_in_1.Calculations.class);
                intent.putExtra("image","length");
                startActivity(intent);
            }


        });

        IvVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.converter_4_in_1.Calculations.class);
                intent.putExtra("image","volume");
                startActivity(intent);

            }
        });

        IvTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.converter_4_in_1.Calculations.class);
                intent.putExtra("image","temperature");
                startActivity(intent);

            }
        });

        IvWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.converter_4_in_1.Calculations.class);
                intent.putExtra("image","weight");
                startActivity(intent);

            }
        });
    }
}