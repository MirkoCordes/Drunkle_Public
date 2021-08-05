package com.drinringmirkocordes.drinke2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.NameList;

import java.util.ArrayList;

public class Bottle_Spinn_2_2 extends AppCompatActivity {
    ArrayList<String> AddNewWord = new ArrayList<String>();
    ArrayAdapter<String> NWadapter;
    Button ToggleDelete;
    Button ToggleDeleteR;

    Button Startbtn;
    int LongClicklistning = 0;
    EditText AddedTextET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle__spinn_2_2);
        AddedTextET  = findViewById(R.id.AddTextET);
        ToggleDelete = findViewById(R.id.DeleteBtnClick);
        ToggleDeleteR = findViewById(R.id.deleteBtnReady);
        ToggleDelete.setVisibility(View.VISIBLE);
        ToggleDeleteR.setVisibility(View.INVISIBLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Startbtn = findViewById(R.id.StartBtn);
        Startbtn.setVisibility(View.VISIBLE);

        NWadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AddNewWord);
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);

        AddedTextET.setOnEditorActionListener(AddListener);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Click once again on the name, to delete!", Toast.LENGTH_LONG).show();
                getApplicationContext();
                LongClicklistning = 1;

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (LongClicklistning == 1) {
                            Toast.makeText(getApplicationContext(), "\"" + AddNewWord.get(position) + "\" was deleted!", Toast.LENGTH_LONG).show();
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


    private TextView.OnEditorActionListener AddListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            NWadapter.add(AddedTextET.getText().toString());
            AddedTextET.getText().clear();
            return false;
        }
    };

    public void AddWord(View view) {                                                      //Fehler beim Prüfen ".contains"
        String ListeToStart = AddNewWord.toString();
        String NormWord = AddedTextET.getText().toString();


        if (ListeToStart.contains(NormWord)) {
            Toast.makeText(this, "\"" + AddedTextET.getText().toString() + "\" already exist!", Toast.LENGTH_SHORT).show();
        }

        else if (!"".equals(NormWord) && !ListeToStart.contains(NormWord)) {
            NWadapter.add(AddedTextET.getText().toString());
            Toast.makeText(this, "\"" + AddedTextET.getText().toString() + "\" was added!", Toast.LENGTH_SHORT).show();
            Log.i("New Word", AddedTextET.getText().toString());
            AddedTextET.getText().clear();
        }

        else if ("".equals(NormWord)) {
            Toast.makeText(this, "Write some sane tasks!", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteClick(View view) {
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);


        String ListeToStart = AddNewWord.toString();
        if (ListeToStart == "[]") {
            Toast.makeText(this, "The list of game tasks is empty!", Toast.LENGTH_SHORT).show();
        }

        ToggleDeleteR.setVisibility(View.VISIBLE);
        ToggleDelete.setVisibility(View.INVISIBLE);
        LongClicklistning = 1;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (LongClicklistning == 1) {
                    Toast.makeText(getApplicationContext(), "\"" + AddNewWord.get(position) + "\" was deleted!", Toast.LENGTH_LONG).show();
                    AddNewWord.remove(position);
                    NWadapter.notifyDataSetChanged();
                }
            }
        });
        Toast.makeText(getApplicationContext(), "Touch the words to delete!", Toast.LENGTH_SHORT).show();

    }

    public void DeleteReady(View view) {
        ToggleDeleteR.setVisibility(View.INVISIBLE);
        ToggleDelete.setVisibility(View.VISIBLE);
        LongClicklistning = 0;
        Toast.makeText(getApplicationContext(), "Adjustment saved!", Toast.LENGTH_SHORT).show();
    }

//Sprachsteuerung startenS

    public void Startbtn(View view) {
        final ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(NWadapter);
        String ListeToStart = AddNewWord.toString();
        if (ListeToStart == "[]") {
            Toast.makeText(this, "Please add some tasks!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Game tasks were saved!", Toast.LENGTH_SHORT).show();
            Log.i("Started", "true");

            ToggleDeleteR.setVisibility(View.INVISIBLE);
            ToggleDelete.setVisibility(View.VISIBLE);
            LongClicklistning = 0;

            Intent startBottle3 = new Intent(getApplicationContext(), Bottle_Spinn_3.class);

            startBottle3.putStringArrayListExtra("TaskList", AddNewWord);
            startActivity(startBottle3);
        }

    }

    public void Back (View view){
        super.onBackPressed();
    }
}
