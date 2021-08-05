package com.drinringmirkocordes.drinke2;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int RandomNumber;
    int ChooseNext = 1;
    int GroupInt;
    String Numbr;
    Spinner GroupNum;
    Button SaveBtn;
    Button Info;
    int round = 0;
    int round1 = 1;
    boolean ShowInformation;
    ArrayAdapter<CharSequence> adapter;
    Random random;
    int Saver = 0;
    TextView Howto1;
    TextView Howto2;
    TextView Howto3;
    TextView Howto4;
    boolean hardcoremode = false;
    boolean midmode = false;
    boolean normmode = true;

    Intent openCardsDraw2;



    Spinner Modesp;
    String [] Modes = {"Normal", "Medium", "Hardcore (warning: too high)"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        openCardsDraw2 = new Intent(MainActivity.this, Cards_Draw2.class);

        GroupNum = findViewById(R.id.GroupNum);
        adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GroupNum.setAdapter(adapter);
        GroupNum.setOnItemSelectedListener(this);
        SaveBtn = findViewById(R.id.SaveBtn);
        Info = findViewById(R.id.Info);
        Howto1 = findViewById(R.id.Howto1);
        Howto2 = findViewById(R.id.Howto2);
        Howto3 = findViewById(R.id.Howto3);
        Howto4 = findViewById(R.id.Howto4);
        Howto1.setVisibility(View.INVISIBLE);
        Howto2.setVisibility(View.INVISIBLE);
        Info.setVisibility(View.VISIBLE);
        ShowInformation = true;
        GroupNum.setPrompt("Number of players:");



        Modesp = findViewById(R.id.Mode);
        Modesp.setPrompt("Choose the game mode:");
        ArrayAdapter ModeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Modes);
        Modesp.setAdapter(ModeAdapter);
        Modesp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int modeposition = Modesp.getSelectedItemPosition();
                switch (modeposition){
                    case 0:{
                        hardcoremode = false;
                        midmode = false;
                        normmode = true;
                        break;

                    }

                    case 1:{
                        hardcoremode = false;
                        midmode = true;
                        normmode = false;
                        break;

                    }

                    case 2:{
                        hardcoremode = true;
                        midmode = false;
                        normmode = false;
                        break;

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Numbr = parent.getItemAtPosition(position).toString();
        if (!Numbr.equals("more...")){
            GroupInt = Integer.parseInt(Numbr);
            round = Integer.parseInt(Numbr);
        } else{
            Numbr = parent.getItemAtPosition(position).toString();
            GroupInt = 10;
            round = 0;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void ShowInfo (View view){
        if (ShowInformation){
            ShowInformation = false;
            Howto1.setVisibility(View.VISIBLE);
            Howto2.setVisibility(View.VISIBLE);
        }
        else if (!ShowInformation){
            ShowInformation = true;
            Howto1.setVisibility(View.INVISIBLE);
            Howto2.setVisibility(View.INVISIBLE);
        }

    }





    public void Back (View view){
        super.onBackPressed();
    }

    public void GenerateRandomNum(View view){
        if(normmode || hardcoremode){
            if(GroupInt <= 40){
                Toast.makeText(getApplicationContext(), "Settings saved! \n Number of players: " + Numbr, Toast.LENGTH_SHORT).show();
                random = new Random();
                RandomNumber = random.nextInt(GroupInt) +1;

            }
            else if(Numbr.equals("more...")){
                Toast.makeText(getApplicationContext(), "Settings saved! \n Number of players: 40+", Toast.LENGTH_SHORT).show();
                random = new Random();
                GroupInt = 10;
                RandomNumber = random.nextInt(GroupInt) +1;
            }
            Saver = 1;
        }

        if(midmode){
            if(Numbr.equals("more...")){
                Toast.makeText(getApplicationContext(), "Settings saved! \n Number of players: 40+", Toast.LENGTH_SHORT).show();
                random = new Random();
                GroupInt = 3;
                RandomNumber = random.nextInt(GroupInt) +1;
            }
            else if(GroupInt <= 40){
                GroupInt = 3;
                Toast.makeText(getApplicationContext(), "Settings saved! \n Number of players: " + Numbr, Toast.LENGTH_SHORT).show();
                random = new Random();
                RandomNumber = random.nextInt(GroupInt)+1;

            }
            Saver = 1;
        }




        openCardsDraw2.putExtra("RandomNumber", RandomNumber);
        openCardsDraw2.putExtra("GroupInt", GroupInt);
        openCardsDraw2.putExtra("ChooseNext", ChooseNext);
        openCardsDraw2.putExtra("round1", round1);
        openCardsDraw2.putExtra("hardcoremode", hardcoremode);
        openCardsDraw2.putExtra("midmode", midmode);
        openCardsDraw2.putExtra("normmode", normmode);
        openCardsDraw2.putExtra("Numbr", Numbr);
        startActivity(openCardsDraw2);
    }
}
