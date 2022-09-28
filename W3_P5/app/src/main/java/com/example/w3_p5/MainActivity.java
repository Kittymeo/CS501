package com.example.w3_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private SeekBar seekbar;
    private TextView percentage;
    private TextView tip;
    private TextView total;


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        percentage = (TextView) findViewById(R.id.tv_percent);
        tip = (TextView) findViewById(R.id.tv_tip);
        total = (TextView) findViewById(R.id.tv_total);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                percentage.setText(String.valueOf(progress)+"%");
                String input_str = editText.getText().toString();
                if (input_str == null || isNumeric(input_str) == false){

                }else{
                    double input = Double.parseDouble(input_str);
                    double local_tip = input * progress * 0.01;
                    //display tip
                    tip.setText(String.valueOf(local_tip));
                    //display total
                    double local_total = local_tip + input;
                    total.setText(String.valueOf(local_total));
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }


}