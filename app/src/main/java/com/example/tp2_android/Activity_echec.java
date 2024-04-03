package com.example.tp2_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_echec extends AppCompatActivity {

    TextView textMoy;
    Button buttonSMS, buttonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echec);

        textMoy = findViewById(R.id.textMoy);
        buttonSMS = findViewById(R.id.buttonSMS);
        buttonRetour = findViewById(R.id.buttonRetour);

        double moy = getIntent().getDoubleExtra("Moyenne", 0.0);
        textMoy.setText(String.format("Moyenne : %.2f", moy));

        buttonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_echec.this, "Impossible d'envoyer un SMS avec une moyenne insuffisante.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_echec.this, "Retour à l'écran principal.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
