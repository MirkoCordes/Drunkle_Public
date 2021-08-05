package com.drinringmirkocordes.drinke2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Cards_Draw1 extends Fragment {

    Button sendFreeTextButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cards__draw1, container, false);
        sendFreeTextButton = view.findViewById(R.id.InfoOkay);
        sendFreeTextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent openMainActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(openMainActivity);
            }
        });
        return view;
    }
}
