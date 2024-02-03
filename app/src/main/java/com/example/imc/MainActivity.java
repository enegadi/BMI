package com.example.imc;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
                    changePic(weight, height/100);
                    Toast.makeText(getApplicationContext(), "your BMI is " + calculateBMI(weight, height/100), Toast.LENGTH_LONG).show();


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

    private void changePic(float weight, float height){
        ImageView resultImage = findViewById(R.id.resultImage);
        float result = calculateBMI(weight, height);
        if(result != 0){
            resultImage.setVisibility(View.VISIBLE);
            if (result < 18.5) {
                resultImage.setImageDrawable(getResources().getDrawable(R.drawable.image1));
            } else if (result >= 18.5 & result < 22.9 ) {
                resultImage.setImageDrawable(getResources().getDrawable(R.drawable.image2));
            }
            else if (result >= 23 & result < 24.9 ) {
                resultImage.setImageDrawable(getResources().getDrawable(R.drawable.image3));
            }
            else if (result >= 25 & result < 29.9 ) {
                resultImage.setImageDrawable(getResources().getDrawable(R.drawable.image4));
            }
        }

    }


}