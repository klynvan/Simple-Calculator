package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextA, editTextB;
    TextView textViewEquals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        textViewEquals = findViewById(R.id.textViewEquals);

        findViewById(R.id.buttonCalc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredA = editTextA.getText().toString();
                String enteredB = editTextB.getText().toString();


                try {
                    if ((enteredA==null) || (enteredB==null)){
                        Toast.makeText(MainActivity.this, "Error: Enter in number!!", Toast.LENGTH_SHORT).show();
                    }

                    double valueA = Double.valueOf(enteredA);

                    double valueB = Double.valueOf(enteredB);
//                    Toast.makeText(MainActivity.this, valueA+""+valueB, Toast.LENGTH_SHORT).show();
                    if (valueB == 0){
                        Toast.makeText(MainActivity.this, "Error: Cannot Divide by Zero", Toast.LENGTH_SHORT).show();
                    }

                    double sum = valueA/valueB;

                    textViewEquals.setText("= "+ String.format("%.2f", sum));
//                    textViewEquals.setText(sum+"");


                } catch (NumberFormatException ex){
                    Toast.makeText(MainActivity.this, "Enter valid number!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.buttonReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextA.setText("");
                editTextB.setText("");
                textViewEquals.setText("= N/A");
            }
        });

    }


}