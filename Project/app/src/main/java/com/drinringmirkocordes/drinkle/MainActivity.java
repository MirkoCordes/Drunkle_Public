package com.drinringmirkocordes.drinkle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> AddNewWord = new ArrayList<String>();
    ArrayAdapter<String> NWadapter;
    Button ToggleDelete;
    Button ToggleDeleteR;

    Button Startbtn;
    Button Stopbtn;

    int LongClicklistning = 0;
    int StartSave = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleDelete = findViewById(R.id.DeleteBtnClick);
        ToggleDeleteR = findViewById(R.id.deleteBtnReady);
        ToggleDelete.setVisibility(View.VISIBLE);
        ToggleDeleteR.setVisibility(View.INVISIBLE);

        Startbtn = findViewById(R.id.StartBtn);
        Stopbtn = findViewById(R.id.stopBtn);
        Startbtn.setVisibility(View.VISIBLE);
        Stopbtn.setVisibility(View.INVISIBLE);

        NWadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AddNewWord);
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Zum entfernen erneut kurz auf das Feld klicken!", Toast.LENGTH_LONG).show();
                getApplicationContext();
                LongClicklistning = 1;

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            if (LongClicklistning == 1) {
                            Toast.makeText(getApplicationContext(), "\"" + AddNewWord.get(position) + "\" wurde entfernt!", Toast.LENGTH_LONG).show();
                            AddNewWord.remove(position);
                            NWadapter.notifyDataSetChanged();
                            LongClicklistning = 0;
                            }
                        }
                    });

                return true;
            }
        });
    }


    public void AddWord(View view){                                                      //Fehler beim Prüfen ".contains"
        EditText AddedTextET = findViewById(R.id.AddTextET);
        String ListeToStart = AddNewWord.toString();
        String NormWord = AddedTextET.getText().toString();


        if (StartSave == 0) {

            if (ListeToStart.contains(NormWord)){
                Toast.makeText(this, "\"" + AddedTextET.getText().toString() + "\" existiert bereits!", Toast.LENGTH_SHORT).show();
            }

            if (!"".equals(NormWord) && !ListeToStart.contains(NormWord)) {
                NWadapter.add(AddedTextET.getText().toString());


                Toast.makeText(this, "\"" + AddedTextET.getText().toString() + "\" wurde hinzugefügt!", Toast.LENGTH_SHORT).show();

                Log.i("New Word", AddedTextET.getText().toString());
            }
        }

        if (StartSave == 1){
            Toast.makeText(this, "Stoppe erst das Spiel...", Toast.LENGTH_SHORT).show();
        }


        if ("".equals(NormWord)) {
            Toast.makeText(this, "Schreibe vernünftige Wörter!", Toast.LENGTH_SHORT).show();
        }
    }

    public  void DeleteBtn(View view){
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);

        LongClicklistning = 1;

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (LongClicklistning == 1) {
                    Toast.makeText(getApplicationContext(), "\"" + AddNewWord.get(position) + "\" wurde entfernt!", Toast.LENGTH_LONG).show();
                    AddNewWord.remove(position);
                    NWadapter.notifyDataSetChanged();
                }
                }
            });
        Toast.makeText(getApplicationContext(), "Felder zum entfernen berühren!", Toast.LENGTH_SHORT).show();
    }

    public void DeleteClick(View view){
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);


        String ListeToStart = AddNewWord.toString();
        if (ListeToStart == "[]"){
            Toast.makeText(this, "Du hast keine Wörter eingespeichert!", Toast.LENGTH_SHORT).show();
        }
        if (StartSave == 0) {
            ToggleDeleteR.setVisibility(View.VISIBLE);
            ToggleDelete.setVisibility(View.INVISIBLE);
            LongClicklistning = 1;

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (LongClicklistning == 1) {
                        Toast.makeText(getApplicationContext(), "\"" + AddNewWord.get(position) + "\" wurde entfernt!", Toast.LENGTH_LONG).show();
                        AddNewWord.remove(position);
                        NWadapter.notifyDataSetChanged();
                    }
                }
            });
            Toast.makeText(getApplicationContext(), "Felder zum entfernen berühren!", Toast.LENGTH_SHORT).show();
        }

        if (StartSave == 1){
            Toast.makeText(this, "Stoppe erst das Spiel...", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteReady(View view){
        ToggleDeleteR.setVisibility(View.INVISIBLE);
        ToggleDelete.setVisibility(View.VISIBLE);
        LongClicklistning = 0;
        Toast.makeText(getApplicationContext(), "Änderungen wurden gespeichert!", Toast.LENGTH_SHORT).show();

        if (StartSave == 1) {
            ToggleDeleteR.setVisibility(View.INVISIBLE);
            ToggleDelete.setVisibility(View.VISIBLE);
            LongClicklistning = 0;
        }
    }

//Sprachsteuerung startenS

    public void Startbtn(View view){
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);
        String ListeToStart = AddNewWord.toString();
        if (ListeToStart == "[]"){
            Toast.makeText(this, "Füge erstmal wörter ein!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Spiel wurde gestartet...", Toast.LENGTH_SHORT).show();
            Log.i("Started", "true");
            Startbtn.setVisibility(View.INVISIBLE);
            Stopbtn.setVisibility(View.VISIBLE);

            ToggleDeleteR.setVisibility(View.INVISIBLE);
            ToggleDelete.setVisibility(View.VISIBLE);
            LongClicklistning = 0;
            StartSave = 1;
        }

    }

    public void Stopbtn(View view){
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);
        StartSave = 0;

        Toast.makeText(this, "Spiel wurde gestoppt...", Toast.LENGTH_SHORT).show();
        Log.i("Started", "false");
        Startbtn.setVisibility(View.VISIBLE);
        Stopbtn.setVisibility(View.INVISIBLE);

        ToggleDeleteR.setVisibility(View.INVISIBLE);
        ToggleDelete.setVisibility(View.VISIBLE);
    }
}
