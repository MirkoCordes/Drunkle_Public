package com.drinringmirkocordes.drinke2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Cards_Draw2 extends AppCompatActivity {
    int RandomNumber;
    int GroupInt;
    int Round = 0;
    int ChooseNext;
    int round1;
    Random random;
    boolean hardcoremode;
    boolean midmode;
    boolean normmode;
    String Numbr;

    ImageView WinImage1;
    ImageView WinImage2;
    ImageView LoseImage1;
    ImageView LoseImage2;
    int Wincard1;
    int Losecard1;
    ArrayAdapter<CharSequence> adapter;
    TextView NumberOfPlayers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards__draw2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Intent openCardsDraw2 = getIntent();
        RandomNumber = openCardsDraw2.getIntExtra("RandomNumber", 0);
        GroupInt = openCardsDraw2.getIntExtra("GroupInt", 0);
        ChooseNext = openCardsDraw2.getIntExtra("ChooseNext", 0);
        round1 = openCardsDraw2.getIntExtra("round1", 0);
        hardcoremode = openCardsDraw2.getBooleanExtra("hardcoremode", false);
        midmode = openCardsDraw2.getBooleanExtra("midmode", false);
        normmode = openCardsDraw2.getBooleanExtra("normmode", true);
        Numbr = openCardsDraw2.getStringExtra("Numbr");

        adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        WinImage1 = findViewById(R.id.WinImage1);
        WinImage2 = findViewById(R.id.winImage2);
        LoseImage1 = findViewById(R.id.LoseImage1);
        LoseImage2 = findViewById(R.id.loseImage2);
        Wincard1 = 0;
        Losecard1 = 0;
        NumberOfPlayers = findViewById(R.id.NumberofPlayers);
        if(Numbr.equals("more...")){
            NumberOfPlayers.setText("Number of players: ∞");
        }
        else if(midmode){
            NumberOfPlayers.setText("Number of players: " + Numbr);
        }
        else{
            NumberOfPlayers.setText("ROUND: " + round1);
        }
    }

    public void guess(View view){
        if(Numbr.equals("more...")){
            NumberOfPlayers.setText("Number of players: ∞");
        }

        else if(midmode){
            NumberOfPlayers.setText("Number of players: " + Numbr);
        }

        else if (Round == GroupInt){
            ++round1;
            Round = 0;
            NumberOfPlayers.setText("ROUND: " + round1);
        }

        if (!hardcoremode){
            guess1(view);
        }
        if(hardcoremode){
            guess2(view);
        }
    }

    public void guess1(View view){
        if (RandomNumber != ChooseNext && Wincard1 == 1){ //2
            ++ChooseNext;
            Wincard1 = 0;
            Losecard1 = 0;
            WinImage1.animate().rotation(-360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            WinImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            ++Round;
        }
        else if (RandomNumber != ChooseNext && Wincard1 == 0){ //1
            ++ChooseNext;
            Wincard1 = 1;
            Losecard1 = 0;
            WinImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            WinImage2.animate().rotation(360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            LoseImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            ++Round;
        }
        else if (RandomNumber == ChooseNext && Losecard1 == 1){
            ChooseNext = 1;
            GenerateRandomNum1(view);
            Wincard1 = 0;
            Losecard1 = 0;
            WinImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            WinImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage2.animate().rotation(360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            ++Round;
        }

        else{ //1
            ChooseNext = 1;
            GenerateRandomNum1(view);
            Wincard1 = 0;
            Losecard1 = 1;
            WinImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            WinImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage1.animate().rotation(-360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            LoseImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            ++Round;
        }
    }

    public void guess2(View view){


        if (RandomNumber == ChooseNext && Wincard1 == 1){ //2
            ChooseNext = 1;
            GenerateRandomNum1(view);
            Wincard1 = 0;
            Losecard1 = 0;
            WinImage1.animate().rotation(-360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            WinImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            ++Round;
        }
        else if (RandomNumber == ChooseNext && Wincard1 == 0){ //1
            ChooseNext = 1;
            GenerateRandomNum1(view);
            Wincard1 = 1;
            Losecard1 = 0;
            WinImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            WinImage2.animate().rotation(360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            LoseImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            ++Round;

        }
        else if (RandomNumber != ChooseNext && Losecard1 == 1){
            ++ChooseNext;
            Wincard1 = 0;
            Losecard1 = 0;
            WinImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            WinImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage2.animate().rotation(360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            ++Round;
        }

        else{ //1
            ++ChooseNext;
            Wincard1 = 0;
            Losecard1 = 1;
            WinImage1.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            WinImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            LoseImage1.animate().rotation(-360).scaleY(1f).scaleX(1f).alpha(1).setDuration(500).setStartDelay(500);
            LoseImage2.animate().rotation(0).scaleY(0f).scaleX(0f).alpha(0).setDuration(500).setStartDelay(0);
            ++Round;
        }
    }

    public void Back (View view){
        super.onBackPressed();
    }

    public void GenerateRandomNum1(View view){
        random = new Random();
        if(normmode || hardcoremode){
            if(GroupInt <= 40){
                RandomNumber = random.nextInt(GroupInt) +1;

            }
            else if(Numbr.equals("more...")){
                GroupInt = 10;
                RandomNumber = random.nextInt(GroupInt) +1;
            }
        }

        if(midmode){

            if(Numbr.equals("more...")){
                GroupInt = 3;
                RandomNumber = random.nextInt(GroupInt) +1;
            }
            else if(GroupInt <= 40){
                GroupInt = 3;
                RandomNumber = random.nextInt(GroupInt)+1;

            }
        }
    }
}
