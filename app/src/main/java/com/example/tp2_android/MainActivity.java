package com.example.tp2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_Note1, editText_Note2, editText_Note3;
    Button calculateButton;
    TextView cofficient1,cofficient2,cofficient3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_Note1 = findViewById(R.id.editText_Note1);
        editText_Note2 = findViewById(R.id.editText_Note2);
        editText_Note3 = findViewById(R.id.editText_Note3);
        cofficient1 = findViewById(R.id.cofficient1);
        cofficient2 = findViewById(R.id.cofficient2);
        cofficient3 = findViewById(R.id.cofficient3);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateMoy();
            }
        });

    }


    private void calculateMoy() {

        String note1Text = editText_Note1.getText().toString();
        String note2Text = editText_Note2.getText().toString();
        String note3Text = editText_Note3.getText().toString();
        String coff1Text = cofficient1.getText().toString();
        String coff2Text = cofficient2.getText().toString();
        String coff3Text = cofficient3.getText().toString();

        if (isEmpty(note1Text) || isEmpty(note2Text) || isEmpty(note3Text) ||
                isEmpty(coff1Text) || isEmpty(coff2Text) || isEmpty(coff3Text)) {
            Toast.makeText(this, "Please enter all grades and coefficients", Toast.LENGTH_SHORT).show();
            return;
        }

        double note1 = Double.parseDouble(editText_Note1.getText().toString()) ;
        double note2 = Double.parseDouble(editText_Note2.getText().toString());
        double note3 = Double.parseDouble(editText_Note3.getText().toString());
        double coff1 = Double.parseDouble(cofficient1.getText().toString());
        double coff2 = Double.parseDouble(cofficient2.getText().toString());
        double coff3 = Double.parseDouble(cofficient3.getText().toString());

        if (!isValid(note1, note2, note3) ) {
            Toast.makeText(this, "Grades must be between 0 and 20", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calculate Moyenne
        double moy = ((note1 * coff1) + (note2 * coff2) + (note3 * coff3)) / (coff1 + coff2 + coff3);
        //double moy= ((note1 + note2 + note3) / 3);

        // Check GPA and navigate to appropriate activity
        Intent intent;
        if (moy >= 10) {
            intent = new Intent(MainActivity.this, Activity_reussi.class);
        } else {
            intent = new Intent(MainActivity.this, Activity_echec.class);
        }

        // Pass GPA to next activity
        intent.putExtra("Moyenne", moy);
        startActivity(intent);
    }

    private boolean isValid(double... values) {
        for (double value : values) {
            if ((value < 0) || (value > 20)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmpty(String text) {
        if (text.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}