package com.drinringmirkocordes.drinke2;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Locale;

public class Ban_words_2 extends AppCompatActivity {

    Button speakButton;
    TextView speakText;
    final int SpeechIntentReqCode = 11;
    Button startBtn;
    Button deleteBtn;
    View view3;
    View view2;
    TextView TextHinzu;
    ArrayList<String> Speechresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_words_2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        TextHinzu = findViewById(R.id.textView17);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        deleteBtn = findViewById(R.id.deleteBtnClick);
        startBtn = findViewById(R.id.startBtn2);
        speakButton = findViewById(R.id.SpeakButton);
        speakText = findViewById(R.id.SpeakText);

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SpeechRecognitionIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                SpeechRecognitionIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault().toString());
                startActivityForResult(SpeechRecognitionIntent, SpeechIntentReqCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SpeechIntentReqCode && resultCode == RESULT_OK){
            Speechresults = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String Finaltext;

            if (speakText.getText().length() >0) {
                Finaltext = Speechresults.get(0);
                TextHinzu.setVisibility(View.VISIBLE);
                view3.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                startBtn.setVisibility(View.VISIBLE);
                deleteBtn.setVisibility(View.VISIBLE);
                speakButton.setVisibility(View.INVISIBLE);
            } else {
                Finaltext = Speechresults.get(0);
            }
            speakText.setText(Finaltext);
        }
    }

    public void DeleteClick (View view){
        TextHinzu.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.VISIBLE);
        startBtn.setVisibility(View.INVISIBLE);
        deleteBtn.setVisibility(View.INVISIBLE);
        speakButton.setVisibility(View.VISIBLE);
        speakText.setText("Listen...");
    }

    public void Startbtn (View view){
        Intent startSpeakGame = new Intent(getApplicationContext(), Ban_Words_3.class);

        startSpeakGame.putStringArrayListExtra("Speechresults", Speechresults);
        startActivity(startSpeakGame);
    }

    public void Back (View view){
        super.onBackPressed();
    }
}
