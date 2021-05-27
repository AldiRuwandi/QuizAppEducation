package com.example.quizappeducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collections;
import java.util.List;

import static com.example.quizappeducation.MainActivity.list;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timeValue = 20;
    RoundedHorizontalProgressBar progressBar;
    List<ModelClass> allQuetionList;
    ModelClass modelClass;
    int index = 0;
    TextView card_question, optiona, optionb, optionc, optiond;
    CardView cardAO, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

        allQuetionList = list;
        Collections.shuffle(allQuetionList);
        modelClass = list.get(index);

        cardAO.setBackgroundColor(getResources().getColor(R.color.color_white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.color_white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.color_white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.color_white));

        nextBtn.setClickable(false);

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeValue = timeValue - 1;
                progressBar.setProgress(timeValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this, R.style.Dialog);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        }.start();

        setAllData();
    }

    private void setAllData() {
        card_question.setText(modelClass.getQuetion());
        optiona.setText(modelClass.getoA());
        optionb.setText(modelClass.getoB());
        optionc.setText(modelClass.getoC());
        optiond.setText(modelClass.getoD());
        timeValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();
    }

    private void Hooks() {

        progressBar = findViewById(R.id.quiz_time);
        card_question = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_option);
        optionb = findViewById(R.id.card_optionb);
        optionc = findViewById(R.id.card_optionc);
        optiond = findViewById(R.id.card_optiond);

        cardAO = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);
        cardOD = findViewById(R.id.cardD);

        nextBtn = findViewById(R.id.nextBtn);
    }

    public void Correct(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modelClass = list.get(index);
                resetColor();
                setAllData();
                enableButton();
            }
        });
    }

    public void Wrong(CardView cardOA){

        cardOA.setBackgroundColor(getResources().getColor(R.color.red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if (index < list.size() - 1){
                    index++;
                    modelClass = list.get(index);
                    resetColor();
                    setAllData();
                    enableButton();
                }else{
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);
    }

    public void enableButton(){
        cardAO.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void disableButton(){
        cardAO.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor(){
        cardAO.setBackgroundColor(getResources().getColor(R.color.color_white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.color_white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.color_white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.color_white));
    }

    public void OptionAClickA(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelClass.getoA().equals(modelClass.getAns())){
            cardAO.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1){
                Correct(cardAO);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardAO);
        }
    }

    public void OptionAClickB(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelClass.getoB().equals(modelClass.getAns())){
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1){
                Correct(cardOB);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOB);
        }
    }

    public void OptionAClickC(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelClass.getoC().equals(modelClass.getAns())){
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1){
                Correct(cardOC);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOC);
        }
    }

    public void OptionAClickD(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelClass.getoD().equals(modelClass.getAns())){
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1){
                Correct(cardOD);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOD);
        }
    }
}
