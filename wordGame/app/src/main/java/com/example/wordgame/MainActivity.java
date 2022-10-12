package com.example.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public game gameFragment;
    public score scoreFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameFragment = new game();
        scoreFragment = new score();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a,gameFragment)
                .replace(R.id.container_b,scoreFragment)
                .commit();
    }


}