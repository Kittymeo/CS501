package com.example.c2_p23;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private TextView color;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        color = (TextView) findViewById(R.id.label);

        final String[] color_text = {"green"};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_text[0].equals("green")){
                    color_text[0] = "yellow";
                    color.setText("yellow");
                    color.setTextColor(Color.parseColor("#Fdff76"));
                }else if(color_text[0].equals("yellow")){
                    color_text[0] = "red";
                    color.setText("red");
                    color.setTextColor(Color.parseColor("#Ff7676"));
                }else if(color_text[0].equals("red")){
                    color_text[0] = "green";
                    color.setText("green");
                    color.setTextColor(Color.parseColor("#84ff76"));
                }else{
                    System.out.println("internal error");
                }
            }
        });



    }
}