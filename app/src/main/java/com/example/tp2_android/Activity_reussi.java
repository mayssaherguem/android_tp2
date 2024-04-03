package com.example.tp2_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_reussi extends AppCompatActivity {

    TextView textMoy;
    Button buttonSMS, buttonRetour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussi);

        textMoy = findViewById(R.id.textMoy);
        buttonSMS = findViewById(R.id.buttonSMS);
        buttonRetour = findViewById(R.id.buttonRetour);

        double moy = getIntent().getDoubleExtra("Moyenne", 0.0);
        textMoy.setText(String.format("Moyenne : %.2f", moy));

        buttonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = String.format("Ma moyenne est %.2f", moy);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"));
                intent.putExtra("sms_body", message);
                startActivity(intent);
            }
        });

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_reussi.this, "Retour à l'écran principal.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
