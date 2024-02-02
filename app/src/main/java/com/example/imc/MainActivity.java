package com.example.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    EditText heightEditText = findViewById(R.id.heightEditText);
                    EditText weightEditText = findViewById(R.id.weightEditText);

                    String heightValue = heightEditText.getText().toString();
                    String weightValue = weightEditText.getText().toString();

                    float height = heightValue.isEmpty() ? 0 : Float.parseFloat(heightValue);
                    float weight = weightValue.isEmpty() ? 0 : Float.parseFloat(weightValue);



                    Log.d("MainActivity", "result: " + calculateBMI(weight, height/100));

                } catch (NumberFormatException e) {
                    e.printStackTrace(); 
                }
            }
        });

    }


    private float calculateBMI(float weight, float height){
        try {
            return weight/(height*height);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        return 0;
    }
}