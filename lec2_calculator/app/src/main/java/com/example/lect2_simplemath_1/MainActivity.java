package com.example.lect2_simplemath_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtOp1;
    private EditText edtOp2;
    private Button btnCalculate;
    private TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  tvAnswer = new TextView(null);

       tvAnswer = (TextView) findViewById(R.id.tvAnswer);
       edtOp1 = (EditText) findViewById(R.id.edtOp1);
       edtOp2 = (EditText) findViewById(R.id.edtOp2);
       btnCalculate = (Button) findViewById(R.id.btnCalculate);

btnCalculate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Double result;
        result = Double.parseDouble(edtOp1.getText().toString()) +
                 Double.parseDouble(edtOp2.getText().toString());
        tvAnswer.setText(result.toString());
    }
});


btnCalculate.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        Double result;
        result = Double.parseDouble(edtOp1.getText().toString()) -
                Double.parseDouble(edtOp2.getText().toString());
        tvAnswer.setText(result.toString());

        return true;
    }
});


    }

    public void onClick(View view){
        Double result;
        result = Double.parseDouble(edtOp1.getText().toString()) +
                 Double.parseDouble(edtOp2.getText().toString());
        tvAnswer.setText(result.toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}