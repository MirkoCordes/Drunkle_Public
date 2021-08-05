package com.drinringmirkocordes.drinke2;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Busdriver3 extends AppCompatActivity {
    TextView question;
    TextView failtext;
    ImageView maincard;
    ImageView MainCard;
    ImageView cardthumb1;
    ImageView cardthumb2;
    ImageView cardthumb3;
    ImageView cardthumb4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    int roundCounter = 1;
    Random randomfirst;
    int RandomNumberFirst;
    int RandomNumberLast;
    Random randomlast;
    int color;
    int clickNumber;
    int cardSector;
    int NumberSaver;
    boolean round2 = false;
    int ra1;
    int ra2;
    int rb1;
    int rb2;
    int rc1;
    int rc2;
    int rd1;
    int rd2;
    View WonView;
    TextView Grat1;
    TextView Grat2;
    Button button5;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busdriver3);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        WonView = findViewById(R.id.WonView);
        Grat1 = findViewById(R.id.Grat1);
        Grat2 = findViewById(R.id.Grat2);
        button5 = findViewById(R.id.Button5);
        question = findViewById(R.id.Question);
        failtext = findViewById(R.id.Failtext);
        maincard = findViewById(R.id.Maincard);
        MainCard = findViewById(R.id.maincard);
        cardthumb1 = findViewById(R.id.Cardthumb1);
        cardthumb2 = findViewById(R.id.Cardthumb2);
        cardthumb3 = findViewById(R.id.Cardthumb3);
        cardthumb4 = findViewById(R.id.Cardthumb4);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        button3 = findViewById(R.id.Button3);
        button4 = findViewById(R.id.Button4);
        WonView.setVisibility(View.INVISIBLE);
        Grat1.setVisibility(View.INVISIBLE);
        Grat2.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setText("Schwarz");
        button4.setText("Rot");
        question.setText("Schwarz oder Rot?");
        failtext.setVisibility(View.INVISIBLE);
    }

    public void rand1 (View view){
        randomfirst = new Random();
        ra1 = randomfirst.nextInt(4) +1;
        ra2 = randomfirst.nextInt(13) +1;
    }
    public void rand2 (View view){
        randomlast = new Random();
        rb1 = randomlast.nextInt(4) +1;
        rb2 = randomlast.nextInt(13) +1;
    }
    public void rand3 (View view){
        rc1 = randomfirst.nextInt(4) +1;
        rc2 = randomfirst.nextInt(13) +1;
    }
    public void rand4 (View view){
        rd1 = randomfirst.nextInt(4) +1;
        rd2 = randomfirst.nextInt(13) +1;
    }


    // 1
    public void guess3 (View view){
        clickNumber = 1;
        guess(view);
    }
    public void guess4 (View view){
        clickNumber = 2;
        guess(view);
    }
    public void guess5 (View view){
        clickNumber = 3;
        guess(view);
    }
    public void guess6 (View view){
        clickNumber = 4;
        guess(view);
    }


    // 2
    public void guess (View view){
        final Animation animCloseCard = AnimationUtils.loadAnimation(this, R.anim.cardcloseanimation);
        final Animation animOpenCard = AnimationUtils.loadAnimation(this, R.anim.cardopenanimation);
        final Animation animOpenText = AnimationUtils.loadAnimation(this, R.anim.textopenanimation);

        MainCard.startAnimation(animCloseCard);
        maincard.startAnimation(animOpenCard);
        button1.startAnimation(animCloseCard);
        button2.startAnimation(animCloseCard);
        button3.startAnimation(animCloseCard);
        button4.startAnimation(animCloseCard);
        question.startAnimation(animCloseCard);

        if(roundCounter == 1){
            rand1(view);
            RandomNumberFirst = ra1;
            RandomNumberLast = ra2;
            guess2(view);
            if (clickNumber == cardSector){
                cardthumb1.setImageDrawable(ContextCompat.getDrawable(this, color));
                roundCounter = 2;
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setText("Höher");
                button4.setText("Tiefer");
                question.setText("Höher oder tiefer?");
                failtext.startAnimation(animOpenText);
                failtext.setText("correct");
                failtext.setTextColor(getResources().getColor(R.color.corr));
                failtext.setVisibility(View.INVISIBLE);
                rand2(view);
                NumberSaver = 0;
                round2 = false;
            } else {
                failtext.startAnimation(animOpenText);
                failtext.setText("you failed");
                failtext.setTextColor(getResources().getColor(R.color.failing));
                failtext.setVisibility(View.INVISIBLE);
                NumberSaver = 0;
            }
        }
        else if (roundCounter == 2){
            if (rb2 > ra2 ){
                NumberSaver = 3;
            }
            else if (rb2 < ra2){
                NumberSaver = 4;
            }
            else if(rb2 == ra2){
                NumberSaver = 0;
            }
            else{
                NumberSaver = 0;
            }
            RandomNumberFirst = rb1;
            RandomNumberLast = rb2;
            guess2(view);
            if (NumberSaver == clickNumber){
                cardthumb2.setImageDrawable(ContextCompat.getDrawable(this, color));
                roundCounter++;
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setText("Innerhalb");
                button4.setText("Außerhalb");
                question.setText("Innerhalb oder außerhalb?");
                failtext.startAnimation(animOpenText);
                failtext.setText("correct");
                failtext.setTextColor(getResources().getColor(R.color.corr));
                failtext.setVisibility(View.INVISIBLE);
                rand3(view);
                round2 = false;
                NumberSaver = 0;
            } else {

                cardthumb1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
                roundCounter = 1;
                button3.setText("Schwarz");
                button4.setText("Rot");
                question.setText("Schwarz oder Rot?");
                failtext.startAnimation(animOpenText);
                failtext.setText("you failed");
                failtext.setTextColor(getResources().getColor(R.color.failing));
                failtext.setVisibility(View.INVISIBLE);
                NumberSaver = 0;
            }

        }
        else if (roundCounter == 3){
            if (ra2 < rb2 && (rc2 > ra2) && (rc2 < rb2)){
                NumberSaver = 3;
            }
            else if (rb2 < ra2 && (rc2 > rb2) && (rc2 < ra2)){
                NumberSaver = 3;
            }
            else if (rc2 == ra2 || rc2 == rb2){
                NumberSaver = 3;
            }

            else if (ra2 < rb2 && (rc2 < ra2) || (rc2 > rb2)){
                NumberSaver = 4;
            }
            else if (rb2 < ra2 &&  (rc2 < rb2) || (rc2 > ra2)){
                NumberSaver = 4;
            }
            else{
                NumberSaver = 0;
            }

            RandomNumberFirst = rc1;
            RandomNumberLast = rc2;
            guess2(view);
            if (NumberSaver == clickNumber){
                cardthumb3.setImageDrawable(ContextCompat.getDrawable(this, color));
                roundCounter++;
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button1.setText("Herz");
                button2.setText("Karo");
                button3.setText("Pik");
                button4.setText("Kreuz");
                question.setText("Welche Farbe?");
                failtext.startAnimation(animOpenText);
                failtext.setText("correct");
                failtext.setTextColor(getResources().getColor(R.color.corr));
                failtext.setVisibility(View.INVISIBLE);
                round2 = false;
                NumberSaver = 0;
                rand4(view);
            } else {
                cardthumb1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
                cardthumb2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
                roundCounter = 1;
                button3.setText("Schwarz");
                button4.setText("Rot");
                question.setText("Schwarz oder Rot?");
                failtext.startAnimation(animOpenText);
                failtext.setText("you failed");
                failtext.setTextColor(getResources().getColor(R.color.failing));
                failtext.setVisibility(View.INVISIBLE);
                round2 = false;
            }
        }
        else if (roundCounter == 4){
            if (rd1 == 1){
                NumberSaver = 1;
            }
            else if (rd1 == 2){
                NumberSaver = 2;
            }
            else if (rd1 == 3){
                NumberSaver = 3;
            }
            else if (rd1 == 4){
                NumberSaver = 4;
            }
            else {
                NumberSaver = 0;
            }

            RandomNumberFirst = rd1;
            RandomNumberLast = rd2;
            guess2(view);
            if (NumberSaver == clickNumber){
                cardthumb4.setImageDrawable(ContextCompat.getDrawable(this, color));
                roundCounter++;
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);

                WonView.setVisibility(View.VISIBLE);
                Grat1.setVisibility(View.VISIBLE);
                Grat2.setVisibility(View.VISIBLE);
                button5.setVisibility(View.VISIBLE);
            } else {
                WonView.setVisibility(View.INVISIBLE);
                Grat1.setVisibility(View.INVISIBLE);
                Grat2.setVisibility(View.INVISIBLE);
                button5.setVisibility(View.INVISIBLE);
                cardthumb1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
                cardthumb2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
                cardthumb3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
                roundCounter = 1;
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setText("Schwarz");
                button4.setText("Rot");
                question.setText("Schwarz oder Rot?");
                failtext.startAnimation(animOpenCard);
                failtext.setText("you failed");
                failtext.setTextColor(getResources().getColor(R.color.failing));
                failtext.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void reload (View view){
        WonView.setVisibility(View.INVISIBLE);
        Grat1.setVisibility(View.INVISIBLE);
        Grat2.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        failtext.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        cardthumb1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
        cardthumb2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
        cardthumb3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
        cardthumb4.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cards_behind));
        roundCounter = 1;
        button3.setText("Schwarz");
        button4.setText("Rot");
        question.setText("Schwarz oder Rot?");
    }

    // 3
    public void guess2 (View view){
        if (RandomNumberFirst == 1){
            if (RandomNumberLast == 1){color = R.drawable.h2;}
            else if (RandomNumberLast == 2){color = R.drawable.h3;}
            else if (RandomNumberLast == 3){color = R.drawable.h4;}
            else if (RandomNumberLast == 4){color = R.drawable.h5;}
            else if (RandomNumberLast == 5){color = R.drawable.h6;}
            else if (RandomNumberLast == 6){color = R.drawable.h7;}
            else if (RandomNumberLast == 7){color = R.drawable.h8;}
            else if (RandomNumberLast == 8){color = R.drawable.h9;}
            else if (RandomNumberLast == 9){color = R.drawable.h10;}
            else if (RandomNumberLast == 10){color = R.drawable.hb;}
            else if (RandomNumberLast == 11){color = R.drawable.hd;}
            else if (RandomNumberLast == 12){color = R.drawable.hk;}
            else if (RandomNumberLast == 13){color = R.drawable.ha;}
            cardSector = 4;
            maincard.setImageDrawable(ContextCompat.getDrawable(this, color));
        }
        else if (RandomNumberFirst == 2){
            if (RandomNumberLast == 1){color = R.drawable.k2;}
            else if (RandomNumberLast == 2){color = R.drawable.k3;}
            else if (RandomNumberLast == 3){color = R.drawable.k4;}
            else if (RandomNumberLast == 4){color = R.drawable.k5;}
            else if (RandomNumberLast == 5){color = R.drawable.k6;}
            else if (RandomNumberLast == 6){color = R.drawable.k7;}
            else if (RandomNumberLast == 7){color = R.drawable.k8;}
            else if (RandomNumberLast == 8){color = R.drawable.k9;}
            else if (RandomNumberLast == 9){color = R.drawable.k10;}
            else if (RandomNumberLast == 10){color = R.drawable.kb;}
            else if (RandomNumberLast == 11){color = R.drawable.kd;}
            else if (RandomNumberLast == 12){color = R.drawable.kk;}
            else if (RandomNumberLast == 13){color = R.drawable.ka;}
            cardSector = 4;
            maincard.setImageDrawable(ContextCompat.getDrawable(this, color));
        }
        else if (RandomNumberFirst == 3){
            if (RandomNumberLast == 1){color = R.drawable.p2;}
            else if (RandomNumberLast == 2){color = R.drawable.p3;}
            else if (RandomNumberLast == 3){color = R.drawable.p4;}
            else if (RandomNumberLast == 4){color = R.drawable.p5;}
            else if (RandomNumberLast == 5){color = R.drawable.p6;}
            else if (RandomNumberLast == 6){color = R.drawable.p7;}
            else if (RandomNumberLast == 7){color = R.drawable.p8;}
            else if (RandomNumberLast == 8){color = R.drawable.p9;}
            else if (RandomNumberLast == 9){color = R.drawable.p10;}
            else if (RandomNumberLast == 10){color = R.drawable.pb;}
            else if (RandomNumberLast == 11){color = R.drawable.pd;}
            else if (RandomNumberLast == 12){color = R.drawable.pk;}
            else if (RandomNumberLast == 13){color = R.drawable.pa;}
            cardSector = 3;
            maincard.setImageDrawable(ContextCompat.getDrawable(this, color));
        }
        else if (RandomNumberFirst == 4){
            if (RandomNumberLast == 1){color = R.drawable.r2;}
            else if (RandomNumberLast == 2){color = R.drawable.r3;}
            else if (RandomNumberLast == 3){color = R.drawable.r4;}
            else if (RandomNumberLast == 4){color = R.drawable.r5;}
            else if (RandomNumberLast == 5){color = R.drawable.r6;}
            else if (RandomNumberLast == 6){color = R.drawable.r7;}
            else if (RandomNumberLast == 7){color = R.drawable.r8;}
            else if (RandomNumberLast == 8){color = R.drawable.r9;}
            else if (RandomNumberLast == 9){color = R.drawable.r10;}
            else if (RandomNumberLast == 10){color = R.drawable.rb;}
            else if (RandomNumberLast == 11){color = R.drawable.rd;}
            else if (RandomNumberLast == 12){color = R.drawable.rk;}
            else if (RandomNumberLast == 13){color = R.drawable.ra;}
            cardSector = 3;
            maincard.setImageDrawable(ContextCompat.getDrawable(this, color));
        }
    }

    public void Back (View view){super.onBackPressed();}

}
