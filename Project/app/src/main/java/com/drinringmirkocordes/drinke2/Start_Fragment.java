package com.drinringmirkocordes.drinke2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;

public class Start_Fragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_start__fragment, container, false);

        TableRow DriveBtn = (TableRow) view.findViewById(R.id.BusDrive);
        DriveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Busdriver1()).commit();
            }
        });
        Button DriveBtn1 = (Button) view.findViewById(R.id.DriveButton);
        DriveBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Busdriver1()).commit();
            }
        });

        TableRow BottleSpinBtn = (TableRow) view.findViewById(R.id.SpinBottle);
        BottleSpinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Bottle_Spinn_1()).commit();
            }
        });
        Button BottleSpinBtn1 = (Button) view.findViewById(R.id.Button3);
        BottleSpinBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Bottle_Spinn_1()).commit();
            }
        });

        TableRow CardsBtn = (TableRow) view.findViewById(R.id.CardDraw);
        CardsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Cards_Draw1()).commit();
            }
        });
        Button CardsDrawBtn = (Button) view.findViewById(R.id.Button2);
        CardsDrawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Cards_Draw1()).commit();
            }
        });


        TableRow SpeechBtn = (TableRow) view.findViewById(R.id.Speech);
        SpeechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Ban_Words_1()).commit();
            }
        });
        Button Speech1Btn = (Button) view.findViewById(R.id.SpeechBtn);
        Speech1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Ban_Words_1()).commit();
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
