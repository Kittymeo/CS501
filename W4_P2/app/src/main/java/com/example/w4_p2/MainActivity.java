package com.example.w4_p2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.view.GestureDetectorCompat;



public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String DEBUG_TAG = "DEBUG_TAG";
    private GestureDetectorCompat mDetector;
    private TextView tv;
    private EditText input;
    private Double totalDollar;
    private TextView euroDisplay;
    private TextView yenDisplay;
    private TextView wonDisplay;
    private TextView rmbDisplay;

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void displayAllCurrency(){
        Double dollar = this.totalDollar;
        input.setText(String.format("%.02f", dollar));


        euroDisplay.setText(String.format("%.02f", dollar*1.02));
        yenDisplay.setText(String.format("%.02f", dollar*144.74));
        wonDisplay.setText(String.format("%.02f", dollar*1440.23));
        rmbDisplay.setText(String.format("%.02f", dollar*7.12));
    }

    public void displayAllCurrency_exceptDollar(){
        Double dollar = this.totalDollar;
        euroDisplay.setText(String.format("%.02f", dollar*1.02));
        yenDisplay.setText(String.format("%.02f", dollar*144.74));
        wonDisplay.setText(String.format("%.02f", dollar*1440.23));
        rmbDisplay.setText(String.format("%.02f", dollar*7.12));
    }

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        tv = (TextView) findViewById(R.id.tv);
        input = (EditText) findViewById(R.id.dollar_input);
        rmbDisplay = (TextView) findViewById(R.id.rmb_display);
        yenDisplay = (TextView) findViewById(R.id.yen_display);
        wonDisplay = (TextView) findViewById(R.id.won_display);
        euroDisplay = (TextView) findViewById(R.id.euro_display);
        totalDollar = 0.0;


        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String newStr = input.getText().toString().trim();
                tv.setText("Dollar");
                if (isNumeric(newStr)){
//                    tv.setText("isNumeric");
                    totalDollar = Double.parseDouble(newStr);
                    displayAllCurrency_exceptDollar();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
//        tv.setText("onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
//        tv.setText("onFling");
        totalDollar += 1.0;
        displayAllCurrency();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
//        tv.setText("onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        totalDollar += 0.1;
        displayAllCurrency();
//        tv.setText(String.valueOf(totalDollar));

        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
//        tv.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
//        tv.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
//        tv.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
//        tv.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
//        tv.setText("onSingleTapConfirmed");
        return true;
    }
}