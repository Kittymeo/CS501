package com.example.wordgame;

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
import java.lang.Math;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link game#newInstance} factory method to
 * create an instance of this fragment.
 */
public class game extends Fragment {

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
        void onInputSent(int score);
    }

    public void populateBtns(){
        Random rn = new Random();
        for (int i = 0; i<4;i++){
            for (int j = 0; j<4;j++){
                btn_list[i][j].setText(alphabet.get(rn.nextInt(27)));
            }
        }
    }
    public boolean is_valid_move(Button lastBtn, Button currentBtn){
        int lr=99,lc=99,cr=99,cc =99;
        for (int i = 0; i<4;i++){
            for (int j = 0; j<4;j++){
                if (btn_list[i][j] == lastBtn){
                    lr = i;
                    lc = j;
                }
                else if (btn_list[i][j] == currentBtn){
                    cr = i;
                    cc = j;
                }
            }
        }
        if (Math.abs(lr-cr)<=1 && Math.abs(lc-cc)<=1){
            return true;
        }else{
            return false;
        }
    }


    public boolean is_valid_word(String str){
        int vol_num = 0;
        for (int i = 0; i < str.length(); i++) {
            if(vowels.contains(str.charAt(i))){
                vol_num+=1;
            }
        }
        if (str.length()>=4 && dictionary.contains(str) && vol_num>=2 && !used_words.contains(str)){
            return true;
        }else{
            return false;
        }
    }


    public void onClick (View v){
        switch (v.getId()){
            case R.id.r1c1:
                r1c1.setEnabled(false);
                current_word += r1c1.getText();
                currentWordTv.setText(current_word);
                last_Btn = current_Btn;
                current_Btn = r1c1;
        }
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public game() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment game.
     */
    // TODO: Rename and change types and number of parameters
    public static game newInstance(String param1, String param2) {
        game fragment = new game();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        current_word="";

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
        populateBtns();

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onInputSent(score);
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