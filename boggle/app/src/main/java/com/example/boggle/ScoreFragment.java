package com.example.boggle;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ScoreFragment extends Fragment {

    public ScoreFragment.ScoreListener listener;
//    public int scoreF =999;
    public Button new_game;
//    public TextView scoreTv;


    public interface ScoreListener{
        void onInputScoreSent(int scoreF);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_score, container, false);
//        new_game = v.findViewById(R.id.new_game_btn);
//        new_game.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
////                listener.onInputScoreSent(scoreF);
//            }
//        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ScoreFragment.ScoreListener){
            listener = (ScoreFragment.ScoreListener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement ScoreListenerFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}