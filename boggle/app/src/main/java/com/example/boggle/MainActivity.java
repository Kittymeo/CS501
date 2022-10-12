package com.example.boggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements GameFragment.GameListener, ScoreFragment.ScoreListener{

    public GameFragment gameFragment;
    public ScoreFragment scoreFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameFragment = new GameFragment();
        scoreFragment = new ScoreFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a,gameFragment)
                .replace(R.id.container_b,scoreFragment)
                .commit();
    }


    @Override
    public void onInputGameSent(int score) {
//        scoreFragment.scoreF += score;
//        scoreFragment.scoreTv.setText(String.valueOf(scoreFragment.scoreF));
    }

    @Override
    public void onInputScoreSent(int score) {

    }
}