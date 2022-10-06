package com.example.hangmangame;


import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class GameActivity extends AppCompatActivity {

    public String alphabet = "yutdfghbniopjklzxcvasqwerm";
    public WordContent w;
    int int_random = (new Random()).nextInt(w.words.length);
    String test = w.words[int_random][0];
    String without_answer = deleteS(test,alphabet);
    public String answer_record = "";

    public int total_len = 0;
    public int turn = 6;
    public int hint_count = 3;
    private TextView wd0;
    private TextView wd1;
    private TextView wd2 ;
    private TextView wd3;
    private TextView wd4;
    private TextView wd5;
    private TextView lost;
    private TextView win;
    private TextView hint;
    private ImageView img;

    private Button btA;
    private Button btB;
    private Button btC;
    private Button btD;
    private Button btE;
    private Button btF;
    private Button btG;
    private Button btH;
    private Button btI;
    private Button btJ;
    private Button btK;
    private Button btL;
    private Button btM;
    private Button btN;
    private Button btO;
    private Button btP;
    private Button btQ;
    private Button btR;
    private Button btS;
    private Button btT;
    private Button btU;
    private Button btV;
    private Button btW;
    private Button btX;
    private Button btY;
    private Button btZ;
    private Button newgame;
    private Button hintBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(savedInstanceState !=null){

            total_len = savedInstanceState.getInt("total_len");
            turn = savedInstanceState.getInt("turn");
            hint_count = savedInstanceState.getInt("hint_count");
            test = savedInstanceState.getString("test");
            answer_record = savedInstanceState.getString("answer_record");
            alphabet = savedInstanceState.getString("alphabet");
            without_answer = savedInstanceState.getString("without_answer");

//            wd0.setText(savedInstanceState.getString("wd0"));
//            wd1.setText(savedInstanceState.getString("wd1"));
//            wd2.setText(savedInstanceState.getString("wd2"));
//            wd3.setText(savedInstanceState.getString("wd3"));
//            wd4.setText(savedInstanceState.getString("wd4"));
//            wd5.setText(savedInstanceState.getString("wd5"));

        }



        setContentView(R.layout.activity_game);

         wd0 = (TextView) findViewById(R.id.word0);
         wd1 = (TextView) findViewById(R.id.word1);
         wd2 = (TextView) findViewById(R.id.word2);
         wd3 = (TextView) findViewById(R.id.word3);
         wd4 = (TextView) findViewById(R.id.word4);
         wd5 = (TextView) findViewById(R.id.word5);
         img = (ImageView) findViewById(R.id.imageView);
         lost = (TextView) findViewById(R.id.lose);
         win = (TextView) findViewById(R.id.win);
         hint = (TextView) findViewById(R.id.textHint);
         hintBtn = (Button) findViewById(R.id.button63);
         lost.setVisibility(View.GONE);
         win.setVisibility(View.GONE);

            btA = (Button) findViewById(R.id.buttonA);
            btB = (Button) findViewById(R.id.buttonB);
            btC = (Button) findViewById(R.id.buttonC);
            btD = (Button) findViewById(R.id.buttonD);
            btE = (Button) findViewById(R.id.buttonE);
            btF = (Button) findViewById(R.id.buttonF);
            btG = (Button) findViewById(R.id.buttonG);
            btH = (Button) findViewById(R.id.buttonH);
            btI = (Button) findViewById(R.id.buttonI);
            btJ = (Button) findViewById(R.id.buttonJ);
            btK = (Button) findViewById(R.id.buttonK);
            btL = (Button) findViewById(R.id.buttonL);
            btM = (Button) findViewById(R.id.buttonM);
            btN = (Button) findViewById(R.id.buttonN);
            btO = (Button) findViewById(R.id.buttonO);
            btP = (Button) findViewById(R.id.buttonP);
            btQ = (Button) findViewById(R.id.buttonQ);
            btR = (Button) findViewById(R.id.buttonR);
            btS = (Button) findViewById(R.id.buttonS);
            btT = (Button) findViewById(R.id.buttonT);
            btU = (Button) findViewById(R.id.buttonU);
            btV = (Button) findViewById(R.id.buttonV);
            btW = (Button) findViewById(R.id.buttonW);
            btX = (Button) findViewById(R.id.buttonX);
            btY = (Button) findViewById(R.id.buttonY);
            btZ = (Button) findViewById(R.id.buttonZ);
            newgame = (Button) findViewById(R.id.newGameButton);

        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {

            outState.putString("test",test);
            outState.putString("answer_record",answer_record);
            outState.putString("alphabet",alphabet);
            outState.putString("without_answer",without_answer);

            outState.putInt("total_len",total_len);
            outState.putInt("turn",turn);
            outState.putInt("hint_count",hint_count);



            super.onSaveInstanceState(outState);

//            outState.putString("wd0",wd0.getText().toString());
//            outState.putString("wd1",wd1.getText().toString());
//            outState.putString("wd2",wd2.getText().toString());
//            outState.putString("wd3",wd3.getText().toString());
//            outState.putString("wd4",wd4.getText().toString());
//            outState.putString("wd5",wd5.getText().toString());



        }


        public ArrayList<Integer> getIndex(String x, String y){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int index = y.indexOf(x);
            while (index >= 0) {
                list.add(index);
                index = y.indexOf(x, index + 1);
            }

            return list;
        }

        public String deleteS(String x, String original){
            for (int i = 0; i < x.length() ; i++){
                original = original.replaceAll(String.valueOf(x.charAt(i)),"");

            }
            return original;
        }

        public void hintTwo(){
            if (turn == 1){
                hintBtn.setEnabled(false);
                Toast.makeText(this, "Hint not available", Toast.LENGTH_SHORT).show();
            }else{
        //hinttwo
            turn--;
            checkTurn(turn);
            String remain = deleteS(answer_record,without_answer);
            for (int i = 0; i < remain.length()/2 + 1;i++) {
                String x = remain.substring(0, 1);
                remain = remain.substring(1);
                switch (x) {
                    case "a":
                        btA.setEnabled(false);
                        continue;
                    case "b":
                        btB.setEnabled(false);
                        continue;
                    case "c":
                        btC.setEnabled(false);
                        continue;
                    case "d":
                        btD.setEnabled(false);
                        continue;
                    case "e":
                        btE.setEnabled(false);
                        continue;
                    case "f":
                        btF.setEnabled(false);
                        continue;
                    case "g":
                        btG.setEnabled(false);
                        continue;
                    case "h":
                        btH.setEnabled(false);
                        continue;
                    case "i":
                        btI.setEnabled(false);
                        continue;
                    case "j":
                        btJ.setEnabled(false);
                        continue;
                    case "k":
                        btK.setEnabled(false);
                        continue;
                    case "l":
                        btL.setEnabled(false);
                        continue;
                    case "m":
                        btM.setEnabled(false);
                        continue;
                    case "n":
                        btN.setEnabled(false);
                        continue;
                    case "o":
                        btO.setEnabled(false);
                        continue;
                    case "p":
                        btP.setEnabled(false);
                        continue;
                    case "q":
                        btQ.setEnabled(false);
                        continue;
                    case "r":
                        btR.setEnabled(false);
                        continue;
                    case "s":
                        btS.setEnabled(false);
                        continue;
                    case "t":
                        btT.setEnabled(false);
                        continue;
                    case "u":
                        btU.setEnabled(false);
                        continue;
                    case "v":
                        btV.setEnabled(false);
                        continue;
                    case "w":
                        btW.setEnabled(false);
                        continue;
                    case "x":
                        btX.setEnabled(false);
                        continue;
                    case "y":
                        btY.setEnabled(false);
                        continue;
                    case "z":
                        btZ.setEnabled(false);
                        continue;
                }
            }
            }
        }

        public void hintThree(){
            String[] vowels = {"a", "e", "i", "o", "u"};
            if (turn == 1){
                Toast.makeText(this, "Hint not available", Toast.LENGTH_SHORT).show();
                hintBtn.setEnabled(false);
            }else{
                //hintThree
                turn--;
                checkTurn(turn);
                for (String vowel: vowels){
                    if (!answer_record.contains(vowel)){
                        ArrayList<Integer> index= getIndex(vowel,test);
                        switch (vowel){
                            case "a":
                                for (int i =0; i < index.size();i++){
                                    int j = index.get(i);
                                    setxt(j,"A");
                                }
                                btA.setEnabled(false);
                                total_len += index.size();
                                continue;
                            case "e":
                                for (int i =0; i < index.size();i++){
                                    int j = index.get(i);
                                    setxt(j,"E");
                                }
                                btE.setEnabled(false);
                                total_len += index.size();
                                continue;
                            case "i":
                                for (int i =0; i < index.size();i++){
                                    int j = index.get(i);
                                    setxt(j,"I");
                                }
                                btI.setEnabled(false);
                                total_len += index.size();
                                continue;
                            case "o":
                                for (int i =0; i < index.size();i++){
                                    int j = index.get(i);
                                    setxt(j,"O");
                                }
                                btO.setEnabled(false);
                                total_len += index.size();
                                continue;
                            case "u":
                                for (int i =0; i < index.size();i++){
                                    int j = index.get(i);
                                    setxt(j,"U");
                                }
                                btU.setEnabled(false);
                                total_len += index.size();
                        }
                        if (total_len == test.length()){

                            win.setVisibility(View.VISIBLE);

                            setBtnFalse();

                        }
                    }
                }
            }
        }

        public void checkTurn(int turn){

            switch (turn){
                case 5:
                    img.setImageResource(R.drawable.hangman5);
                    break;
                case 4:
                    img.setImageResource(R.drawable.hangman4);
                    break;
                case 3:
                    img.setImageResource(R.drawable.hangman3);
                    break;
                case 2:
                    img.setImageResource(R.drawable.hangman2);
                    break;
                case 1:
                    img.setImageResource(R.drawable.hangman1);
                    break;
                case 0:
                    img.setImageResource(R.drawable.hangman0);
                    lost.setVisibility(View.VISIBLE);
                    Toast.makeText(this, "The answer is " + test, Toast.LENGTH_SHORT).show();
                    hintBtn.setEnabled(false);
                    btA.setEnabled(false);btB.setEnabled(false);btC.setEnabled(false);btD.setEnabled(false);btE.setEnabled(false);btF.setEnabled(false);btG.setEnabled(false);
                    btH.setEnabled(false);btI.setEnabled(false);btJ.setEnabled(false);btK.setEnabled(false);btL.setEnabled(false);btM.setEnabled(false);btN.setEnabled(false);
                    btO.setEnabled(false);btP.setEnabled(false);btQ.setEnabled(false);btR.setEnabled(false);btS.setEnabled(false);btT.setEnabled(false);btU.setEnabled(false);
                    btV.setEnabled(false);btW.setEnabled(false);btX.setEnabled(false);btY.setEnabled(false);btZ.setEnabled(false);
                    break;
            }
        }

        public void HintShown(View view){
            if (hint_count == 3) {
                hint_count --;
                hint.setText(w.words[int_random][1]);
            } else if (hint_count == 2){
                hint_count --;
                hintTwo();
            } else if (hint_count == 1){
                hint_count --;
                hintThree();
                hintBtn.setEnabled(false);
                Toast.makeText(this, "You have used up all your hints!", Toast.LENGTH_SHORT).show();
            }

        }

        public void startNewGame(View view){
//            hint.setText("");
//            lost.setVisibility(View.GONE);
//            win.setVisibility(View.GONE);
//            int int_random = (new Random()).nextInt(7);
//            String test = w.words[int_random][0];
//            int total_len = 0;
//            int turn = 6;
//            wd0.setText("   ");
//            wd1.setText("   ");
//            wd2.setText("   ");
//            wd3.setText("   ");
//            wd4.setText("   ");
//            wd5.setText("   ");
//
//            img.setImageResource(R.drawable.hangman6);
//            btA.setEnabled(true);btB.setEnabled(true);btC.setEnabled(true);btD.setEnabled(true);btE.setEnabled(true);btF.setEnabled(true);btG.setEnabled(true);
//            btH.setEnabled(true);btI.setEnabled(true);btJ.setEnabled(true);btK.setEnabled(true);btL.setEnabled(true);btM.setEnabled(true);btN.setEnabled(true);
//            btO.setEnabled(true);btP.setEnabled(true);btQ.setEnabled(true);btR.setEnabled(true);btS.setEnabled(true);btT.setEnabled(true);btU.setEnabled(true);
//            btV.setEnabled(true);btW.setEnabled(true);btX.setEnabled(true);btY.setEnabled(true);btZ.setEnabled(true);
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);
            finish();
        }

        public void setxt(int j, String x){
            answer_record += (x.toLowerCase());
            switch (j){
                case 0:
                    wd0.setText(x);
                    break;
                case 1:
                    wd1.setText(x);
                    break;
                case 2:
                    wd2.setText(x);
                    break;
                case 3:
                    wd3.setText(x);
                    break;
                case 4:
                    wd4.setText(x);
                    break;
                case 5:
                    wd5.setText(x);
                    break;
            }
        }

        public void setBtnFalse(){
            hintBtn.setEnabled(false);
            btA.setEnabled(false);btB.setEnabled(false);btC.setEnabled(false);btD.setEnabled(false);btE.setEnabled(false);btF.setEnabled(false);btG.setEnabled(false);
            btH.setEnabled(false);btI.setEnabled(false);btJ.setEnabled(false);btK.setEnabled(false);btL.setEnabled(false);btM.setEnabled(false);btN.setEnabled(false);
            btO.setEnabled(false);btP.setEnabled(false);btQ.setEnabled(false);btR.setEnabled(false);btS.setEnabled(false);btT.setEnabled(false);btU.setEnabled(false);
            btV.setEnabled(false);btW.setEnabled(false);btX.setEnabled(false);btY.setEnabled(false);btZ.setEnabled(false);
        }

        public void printA(View view){
            ArrayList<Integer> index= getIndex("a",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"A");
            }
            btA.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);

                setBtnFalse();

            }

        }

        public void printB(View view){
            ArrayList<Integer> index= getIndex("b",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"B");
            }
            btB.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();
            }
        }

        public void printC(View view){
            ArrayList<Integer> index= getIndex("c",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"C");
            }
            btC.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();
            }
        }

        public void printD(View view){
            ArrayList<Integer> index= getIndex("d",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"D");
            }
            btD.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();
            }
        }

        public void printE(View view){
            ArrayList<Integer> index= getIndex("e",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"E");
            }
            btE.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();
            }
        }

        public void printF(View view){
            ArrayList<Integer> index= getIndex("f",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"F");
            }
            btF.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();
            }
        }

        public void printG(View view){
            ArrayList<Integer> index= getIndex("g",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                setxt(j,"G");
            }
            btG.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();
            }
        }

        public void printH(View view){
            ArrayList<Integer> index= getIndex("h",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("H");
                        break;
                    case 1:
                        wd1.setText("H");
                        break;
                    case 2:
                        wd2.setText("H");
                        break;
                    case 3:
                        wd3.setText("H");
                        break;
                    case 4:
                        wd4.setText("H");
                        break;
                    case 5:
                        wd5.setText("H");
                        break;
                }
            }
            btH.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printI(View view){
            ArrayList<Integer> index= getIndex("i",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("I");
                        break;
                    case 1:
                        wd1.setText("I");
                        break;
                    case 2:
                        wd2.setText("I");
                        break;
                    case 3:
                        wd3.setText("I");
                        break;
                    case 4:
                        wd4.setText("I");
                        break;
                    case 5:
                        wd5.setText("I");
                        break;
                }
            }
            btI.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printJ(View view){
            ArrayList<Integer> index= getIndex("j",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("J");
                        break;
                    case 1:
                        wd1.setText("J");
                        break;
                    case 2:
                        wd2.setText("J");
                        break;
                    case 3:
                        wd3.setText("J");
                        break;
                    case 4:
                        wd4.setText("J");
                        break;
                    case 5:
                        wd5.setText("J");
                        break;
                }
            }
            btJ.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printK(View view){
            ArrayList<Integer> index= getIndex("k",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("K");
                        break;
                    case 1:
                        wd1.setText("K");
                        break;
                    case 2:
                        wd2.setText("K");
                        break;
                    case 3:
                        wd3.setText("K");
                        break;
                    case 4:
                        wd4.setText("K");
                        break;
                    case 5:
                        wd5.setText("K");
                        break;
                }
            }
            btK.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printL(View view){
            ArrayList<Integer> index= getIndex("l",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("L");
                        break;
                    case 1:
                        wd1.setText("L");
                        break;
                    case 2:
                        wd2.setText("L");
                        break;
                    case 3:
                        wd3.setText("L");
                        break;
                    case 4:
                        wd4.setText("L");
                        break;
                    case 5:
                        wd5.setText("L");
                        break;
                }
            }
            btL.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printM(View view){
            ArrayList<Integer> index= getIndex("m",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("M");
                        break;
                    case 1:
                        wd1.setText("M");
                        break;
                    case 2:
                        wd2.setText("M");
                        break;
                    case 3:
                        wd3.setText("M");
                        break;
                    case 4:
                        wd4.setText("M");
                        break;
                    case 5:
                        wd5.setText("M");
                        break;
                }
            }
            btM.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printN(View view){
            ArrayList<Integer> index= getIndex("n",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("N");
                        break;
                    case 1:
                        wd1.setText("N");
                        break;
                    case 2:
                        wd2.setText("N");
                        break;
                    case 3:
                        wd3.setText("N");
                        break;
                    case 4:
                        wd4.setText("N");
                        break;
                    case 5:
                        wd5.setText("N");
                        break;
                }
            }
            btN.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printO(View view){
            ArrayList<Integer> index= getIndex("o",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("O");
                        break;
                    case 1:
                        wd1.setText("O");
                        break;
                    case 2:
                        wd2.setText("O");
                        break;
                    case 3:
                        wd3.setText("O");
                        break;
                    case 4:
                        wd4.setText("O");
                        break;
                    case 5:
                        wd5.setText("O");
                        break;
                }
            }
            btO.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printP(View view){
            ArrayList<Integer> index= getIndex("p",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("P");
                        break;
                    case 1:
                        wd1.setText("P");
                        break;
                    case 2:
                        wd2.setText("P");
                        break;
                    case 3:
                        wd3.setText("P");
                        break;
                    case 4:
                        wd4.setText("P");
                        break;
                    case 5:
                        wd5.setText("P");
                        break;
                }
            }
            btP.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printQ(View view){
            ArrayList<Integer> index= getIndex("q",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("Q");
                        break;
                    case 1:
                        wd1.setText("Q");
                        break;
                    case 2:
                        wd2.setText("Q");
                        break;
                    case 3:
                        wd3.setText("Q");
                        break;
                    case 4:
                        wd4.setText("Q");
                        break;
                    case 5:
                        wd5.setText("Q");
                        break;
                }
            }
            btQ.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printR(View view){
            ArrayList<Integer> index= getIndex("r",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("R");
                        break;
                    case 1:
                        wd1.setText("R");
                        break;
                    case 2:
                        wd2.setText("R");
                        break;
                    case 3:
                        wd3.setText("R");
                        break;
                    case 4:
                        wd4.setText("R");
                        break;
                    case 5:
                        wd5.setText("R");
                        break;
                }
            }
            btR.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printS(View view){
            ArrayList<Integer> index= getIndex("s",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("S");
                        break;
                    case 1:
                        wd1.setText("S");
                        break;
                    case 2:
                        wd2.setText("S");
                        break;
                    case 3:
                        wd3.setText("S");
                        break;
                    case 4:
                        wd4.setText("S");
                        break;
                    case 5:
                        wd5.setText("S");
                        break;
                }
            }
            btS.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printT(View view){
            ArrayList<Integer> index= getIndex("t",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("T");
                        break;
                    case 1:
                        wd1.setText("T");
                        break;
                    case 2:
                        wd2.setText("T");
                        break;
                    case 3:
                        wd3.setText("T");
                        break;
                    case 4:
                        wd4.setText("T");
                        break;
                    case 5:
                        wd5.setText("T");
                        break;
                }
            }
            btT.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printU(View view){
            ArrayList<Integer> index= getIndex("u",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("U");
                        break;
                    case 1:
                        wd1.setText("U");
                        break;
                    case 2:
                        wd2.setText("U");
                        break;
                    case 3:
                        wd3.setText("U");
                        break;
                    case 4:
                        wd4.setText("U");
                        break;
                    case 5:
                        wd5.setText("U");
                        break;
                }
            }
            btU.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printV(View view){
            ArrayList<Integer> index= getIndex("v",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("V");
                        break;
                    case 1:
                        wd1.setText("V");
                        break;
                    case 2:
                        wd2.setText("V");
                        break;
                    case 3:
                        wd3.setText("V");
                        break;
                    case 4:
                        wd4.setText("V");
                        break;
                    case 5:
                        wd5.setText("V");
                        break;
                }
            }
            btV.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printW(View view){
            ArrayList<Integer> index= getIndex("w",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("W");
                        break;
                    case 1:
                        wd1.setText("W");
                        break;
                    case 2:
                        wd2.setText("W");
                        break;
                    case 3:
                        wd3.setText("W");
                        break;
                    case 4:
                        wd4.setText("W");
                        break;
                    case 5:
                        wd5.setText("W");
                        break;
                }
            }
            btW.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printX(View view){
            ArrayList<Integer> index= getIndex("x",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("X");
                        break;
                    case 1:
                        wd1.setText("X");
                        break;
                    case 2:
                        wd2.setText("X");
                        break;
                    case 3:
                        wd3.setText("X");
                        break;
                    case 4:
                        wd4.setText("X");
                        break;
                    case 5:
                        wd5.setText("X");
                        break;
                }
            }
            btX.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printY(View view){
            ArrayList<Integer> index= getIndex("y",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("Y");
                        break;
                    case 1:
                        wd1.setText("Y");
                        break;
                    case 2:
                        wd2.setText("Y");
                        break;
                    case 3:
                        wd3.setText("Y");
                        break;
                    case 4:
                        wd4.setText("Y");
                        break;
                    case 5:
                        wd5.setText("Y");
                        break;
                }
            }
            btY.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

        public void printZ(View view){
            ArrayList<Integer> index= getIndex("z",test);
            if (index.size() == 0){
                turn --;
                checkTurn(turn);
            }
            for (int i =0; i < index.size();i++){
                int j = index.get(i);
                switch (j){
                    case 0:
                        wd0.setText("Z");
                        break;
                    case 1:
                        wd1.setText("Z");
                        break;
                    case 2:
                        wd2.setText("Z");
                        break;
                    case 3:
                        wd3.setText("Z");
                        break;
                    case 4:
                        wd4.setText("Z");
                        break;
                    case 5:
                        wd5.setText("Z");
                        break;
                }
            }
            btZ.setEnabled(false);
            total_len += index.size();
            if (total_len == test.length()){

                win.setVisibility(View.VISIBLE);
                setBtnFalse();

            }
        }

    }




