package com.example.boggle;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class GameFragment extends Fragment {
    public GameListener listener;
    public int score;
    public List<String> dictionary = Arrays.asList("apple", "pear", "banana","jeans");
    public ArrayList<String> used_words = new ArrayList<String>(60);
    public ArrayList<Character> alphabet = new ArrayList<Character>(60);
    public List<Character> vowels= Arrays.asList('a','e','i','o','u');
    public String current_word;
    public Button current_Btn;
    public Button last_Btn;
    public ArrayList<Button> buttonList = new ArrayList<Button>(16);
    public ArrayList<Button> gameButtonList = new ArrayList<Button>(0);



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
    public TextView changeBoolean;
    public Button[][] btn_list;

//    public Button[][] btn_list = {{r1c1,r1c2,r1c3,r1c4},{r2c1,r2c2,r2c3,r2c4},{r3c1,r3c2,r3c3,r3c4},{r4c1,r4c2,r4c3,r4c4}};

    public void clearWord(){
        Log.w("textchange","reach clearWord()");
        for (int i=0;i<buttonList.size();i++){
            if (buttonList.get(i)==null){
                break;
            }
            gameButtonList.add(buttonList.get(i));

        }
        buttonList.clear();
        currentWordTv.setText("");
        current_word="";
        current_Btn = null;
        last_Btn = null;

    }
    public void newGame(){
        for (int i=0;i<gameButtonList.size();i++){
            if (gameButtonList.get(i)==null){
                break;
            }
            gameButtonList.get(i).setEnabled(true);

        }
        clearWord();
        Log.w("textchange","reach newGame()");
        clearWord();
        used_words = new ArrayList<String>(60);
        score =0;


//        changeBoolean.setText("false");

    }
    public interface GameListener{
        void onInputGameSent(int score);
    }

    public void loadDictionary(){
        File file = new File("../../assets/words.txt");
        if (file.exists()){
            Log.w("file", "file exist");
        }else{
            Log.w("file", "file not exist");
        }


    }

    public void changeAlphabet(){
//        alphabet.add('a');
//        alphabet.add('e');
//        alphabet.add('i');
//        alphabet.add('o');
//        alphabet.add('u');

        Random rn = new Random();
        String a = dictionary.get(rn.nextInt(dictionary.toArray().length))+ dictionary.get(rn.nextInt(dictionary.toArray().length))+ dictionary.get(rn.nextInt(dictionary.toArray().length));
        for (int i = 0; i<a.length();i++){
            alphabet.add(a.charAt(i));

        }

    }
    public void populateBtns(){
        Random rn = new Random();
//        btn_list[0][0].setText(alphabet.get(rn.nextInt(26)));
//        if(btn_list[0][0] != null){
//            btn_list[0][0].setText("34");
//        }else{
//            r1c1.setText("nn");
//        }
        try {
            for (int i = 0; i<4;i++){
                for (int j = 0; j<4;j++){
                    if(btn_list[i][j] != null){
                        btn_list[i][j].setText(String.valueOf(alphabet.get(rn.nextInt(alphabet.size()))));
                    }

                }
            }
        }catch (Exception e){
            Log.w("failed",e);
        };



    }
    public boolean is_valid_move(Button[][] btn_list, Button lastBtn, Button currentBtn){

        if (lastBtn == null){
            return true;
        }
//        Log.w("move", "ids: "+ lastBtn.getId()+ ", "+currentBtn.getId());
        int lr=99,lc=99,cr=99,cc =99;
        for (int i = 0; i<4;i++){
            for (int j = 0; j<4;j++){

                if (btn_list[i][j].getId() == lastBtn.getId()){
                    lr = i;
                    lc = j;
                }
                else if (btn_list[i][j].getId() == currentBtn.getId()){
                    cr = i;
                    cc = j;
                }
            }
        }
        if (Math.abs(lr-cr)<=1 && Math.abs(lc-cc)<=1){
//            Log.w("move", "is_valid_move"+lr+lc+cr+cc);
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
            used_words.add(str);
            return true;
        }else{
            return false;
        }
    }

    public int countScore(String word){
        int localscore = 0;
        boolean is_double=false;
        List<Character> special= Arrays.asList('s','z','p','x','q');
        for (int i = 0; i < word.length(); i++) {
            if(vowels.contains(word.charAt(i))){
                localscore+=5;
            }else{
                if (special.contains(word.charAt(i))){
                    is_double = true;
                }
                localscore+=1;
            }
        }
        if (is_double){
            localscore *= 2;
        }
        return localscore;

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
        changeBoolean = view_gameFragment.findViewById(R.id.changeB);

        loadDictionary();




        btn_list = new Button[][]{{r1c1, r1c2, r1c3, r1c4}, {r2c1, r2c2, r2c3, r2c4}, {r3c1, r3c2, r3c3, r3c4}, {r4c1, r4c2, r4c3, r4c4}};
        currentWordTv.setText("");
        current_word="";
        changeAlphabet();
        populateBtns();


        getParentFragmentManager().setFragmentResultListener("newGameData", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if(result.getBoolean("newGame")){
                    changeBoolean.setText("true");
                }

            }
        });

        changeBoolean.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.w("textchange",charSequence.toString());
                if (charSequence.toString().equals("true")){
                    Log.w("textchange","equals true");
                    newGame();
                    populateBtns();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<buttonList.size();i++){
                    if (buttonList.get(i)==null){
                        break;
                    }
                    buttonList.get(i).setEnabled(true);

                }
                clearWord();

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String word = currentWordTv.getText().toString().toLowerCase(Locale.ROOT);
                if (is_valid_word(word)){
                    score+= countScore(word);
                }else{
                    score-=10;
                }
                Log.w("score",Integer.toString(score) );
                clearWord();
                listener.onInputGameSent(score);

                Bundle result = new Bundle();
                result.putInt("score", score);
                getParentFragmentManager().setFragmentResult("gameData", result);

            }
        });
        r1c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r1c1)){
                    Log.w("move", "is valid move");
                    r1c1.setEnabled(false);
                    current_word += r1c1.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r1c1;
                    buttonList.add(r1c1);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r1c2)){
                    r1c2.setEnabled(false);
                    current_word += r1c2.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r1c2;
                    buttonList.add(r1c2);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r1c3)){
                    r1c3.setEnabled(false);
                    current_word += r1c3.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r1c3;
                    buttonList.add(r1c3);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r1c4)){
                    r1c4.setEnabled(false);
                    current_word += r1c4.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r1c4;
                    buttonList.add(r1c4);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r2c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r2c1)){
                    r2c1.setEnabled(false);
                    current_word += r2c1.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r2c1;
                    buttonList.add(r2c1);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r2c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r2c2)){
                    r2c2.setEnabled(false);
                    current_word += r2c2.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r2c2;
                    buttonList.add(r2c2);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r2c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r2c3)){
                    r2c3.setEnabled(false);
                    current_word += r2c3.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r2c3;
                    buttonList.add(r2c3);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r2c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r2c4)){
                    r2c4.setEnabled(false);
                    current_word += r2c4.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r2c4;
                    buttonList.add(r2c4);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r3c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r3c1)){
                    r3c1.setEnabled(false);
                    current_word += r3c1.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r3c1;
                    buttonList.add(r3c1);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r3c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r3c2)){
                    r3c2.setEnabled(false);
                    current_word += r3c2.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r3c2;
                    buttonList.add(r3c2);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r3c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r3c3)){
                    r3c3.setEnabled(false);
                    current_word += r3c3.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r3c3;
                    buttonList.add(r3c3);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r3c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r3c4)){
                    r3c4.setEnabled(false);
                    current_word += r3c4.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r3c4;
                    buttonList.add(r3c4);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r4c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r4c1)){
                    r4c1.setEnabled(false);
                    current_word += r4c1.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r4c1;
                    buttonList.add(r4c1);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r4c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r4c2)){
                    r4c2.setEnabled(false);
                    current_word += r4c2.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r4c2;
                    buttonList.add(r4c2);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r4c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r4c3)){
                    r4c3.setEnabled(false);
                    current_word += r4c3.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r4c3;
                    buttonList.add(r4c3);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r4c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_valid_move(btn_list, current_Btn, r4c4)){
                    r4c4.setEnabled(false);
                    current_word += r4c4.getText();
                    currentWordTv.setText(current_word);
                    last_Btn = current_Btn;
                    current_Btn = r4c4;
                    buttonList.add(r4c4);
                }else{
                    Toast.makeText(getActivity(), "Not valid move", Toast.LENGTH_SHORT).show();
                }
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