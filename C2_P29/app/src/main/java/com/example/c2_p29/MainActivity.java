package com.example.c2_p29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText egg;
    private EditText banana;
    private EditText grape;
    private EditText hamburger ;
    private Button btn;
    private TextView totalCalories;

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        egg = (EditText) findViewById(R.id.num_egg);
        banana = (EditText) findViewById(R.id.num_banana);
        grape = (EditText) findViewById(R.id.num_grape);
        hamburger = (EditText) findViewById(R.id.num_hamburger);
        btn = (Button) findViewById(R.id.button);
        totalCalories = (TextView) findViewById(R.id.total);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0.0;
                //get all the count
                String strEgg = egg.getText().toString();
                String strBanana = banana.getText().toString();
                String strGrape = grape.getText().toString();
                String strHamburger = hamburger.getText().toString();
                if (isNumeric(strEgg)){
                    total += Double.parseDouble(strEgg) *72;
                }
                if (isNumeric(strBanana)){
                    total += Double.parseDouble(strBanana) *105;
                }
                if (isNumeric(strGrape)){
                    total += Double.parseDouble(strGrape) *52;
                }
                if (isNumeric(strHamburger)){
                    total += Double.parseDouble(strHamburger) *510;
                }

                totalCalories.setText(String.valueOf(total));





            }
        });


    }
}