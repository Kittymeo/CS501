package com.example.hw2checkemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        email = (EditText) findViewById(R.id.email);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = email.getText().toString();
                if (input.contains("@") && input.indexOf("@") != 0 && input.indexOf("@") != input.length()-1) {
                    tv.setText("Valid");
                }else{
                    tv.setText("Invalid");
                }
            }
        });
    }
}