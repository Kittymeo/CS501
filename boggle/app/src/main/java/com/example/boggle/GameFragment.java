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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameFragment extends Fragment {
    public GameListener listener;
    public int score;
    public List<String> dictionary = Arrays.asList("apple", "pear", "banana");
    public ArrayList<String> used_words;
    public List<Character> alphabet= Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
    public List<Character> vowels= Arrays.asList('a','e','i','o','u');
    public String current_word;
    public Button current_Btn;
    public  Button last_Btn;


    public Button r1c1;
    public Button r1c2;
    public Button r1c3;
    public Button r1c4;
    public Button r2c1;
    public Button r2c2;
    public Button r2c3;
    public Button r2c4;
    public Button r3c1;
    public Button r3c2;
    public Button r3c3;
    public Button r3c4;
    public Button r4c1;
    public Button r4c2;
    public Button r4c3;
    public Button r4c4;
    public Button clearBtn;
    public Button submitBtn;
    public TextView currentWordTv;

    public Button[][] btn_list = {{r1c1,r1c2,r1c3,r1c4},{r2c1,r2c2,r2c3,r2c4},{r3c1,r3c2,r3c3,r3c4},{r4c1,r4c2,r4c3,r4c4}};

    public interface GameListener{
        void onInputGameSent(int score);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view_gameFragment =  inflater.inflate(R.layout.fragment_game, container, false);

        r1c1 = view_gameFragment.findViewById(R.id.r1c1);
        r1c2 = view_gameFragment.findViewById(R.id.r1c2);
        r1c3 = view_gameFragment.findViewById(R.id.r1c3);
        r1c4 = view_gameFragment.findViewById(R.id.r1c4);
        r2c1 = view_gameFragment.findViewById(R.id.r2c1);
        r2c2 = view_gameFragment.findViewById(R.id.r2c2);
        r2c3 = view_gameFragment.findViewById(R.id.r2c3);
        r2c4 = view_gameFragment.findViewById(R.id.r2c4);
        r3c1 = view_gameFragment.findViewById(R.id.r3c1);
        r3c2 = view_gameFragment.findViewById(R.id.r3c2);
        r3c3 = view_gameFragment.findViewById(R.id.r3c3);
        r3c4 = view_gameFragment.findViewById(R.id.r3c4);
        r4c1 = view_gameFragment.findViewById(R.id.r4c1);
        r4c2 = view_gameFragment.findViewById(R.id.r4c2);
        r4c3 = view_gameFragment.findViewById(R.id.r4c3);
        r4c4 = view_gameFragment.findViewById(R.id.r4c4);
        clearBtn = view_gameFragment.findViewById(R.id.clear_btn);
        submitBtn = view_gameFragment.findViewById(R.id.submit_btn);
        currentWordTv = view_gameFragment.findViewById(R.id.selected_word);


        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onInputGameSent(score);
            }
        });
        return view_gameFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof GameListener){
            listener = (GameListener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement GameListenerFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}