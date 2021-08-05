package com.drinringmirkocordes.drinke2;

        import android.annotation.TargetApi;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Build;
        import android.support.annotation.RequiresApi;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.content.ContextCompat;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.ToggleButton;

        import java.util.ArrayList;
        import java.util.Random;

        import static android.graphics.Color.parseColor;

public class Bottle_Spinn_3 extends AppCompatActivity {
    ImageView BottleImg;
    ImageView BottleImg2;
    ImageView SpinLogoImg;
    int RandomDgNumber;
    Context mContext;
    ArrayList GetTasks;
    String RandomTask;
    Random randomDegree;
    Integer Bottlespin = 0;
    TextView Quest;
    TextView task;
    TextView ShowTaskInfo;
    View divider4;
    View viv;
    Boolean Taskshowed;
    Boolean TaskInfoShowed;
    Button StopButton;
    ToggleButton TaskToggle;
    int degreeNumbr = 0;
    Button SpinNow;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle__spinn_3);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Intent openCardsDraw2_2 = getIntent();
        GetTasks = openCardsDraw2_2.getStringArrayListExtra("TaskList");
        StopButton = findViewById(R.id.Stop);
        Quest = findViewById(R.id.Quest);
        task = findViewById(R.id.YourTask);
        divider4 = findViewById(R.id.divider4);
        viv = findViewById(R.id.viev);
        ShowTaskInfo = findViewById(R.id.textView13);
        mContext=this;
        BottleImg = findViewById(R.id.BottleImg);
        BottleImg2 = findViewById(R.id.bottleImg1);
        SpinLogoImg = findViewById(R.id.SpinLogoImg);
        SpinNow = findViewById(R.id.SpinNow);
        TaskToggle = findViewById(R.id.toggleButton);
        Taskshowed = false;
        TaskInfoShowed = false;
        ShowTaskInfo.setText("");
        TaskToggle.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.button_bg_task_tri));
        TaskToggle.setForeground(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen));
        TaskToggle.setVisibility(View.INVISIBLE);
        ShowTaskInfo.setVisibility(View.INVISIBLE);
        BottleImg2.setVisibility(View.INVISIBLE);
        SpinLogoImg.setVisibility(View.INVISIBLE);
        Quest.setVisibility(View.INVISIBLE);
        task.setVisibility(View.INVISIBLE);
        divider4.setVisibility(View.INVISIBLE);
        viv.setVisibility(View.INVISIBLE);




    }

    public void RandDg (View view){
        randomDegree = new Random();
        RandomDgNumber = randomDegree.nextInt(4000) +1031;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void SpinNow (View view){
        RandDg(view);
        Taskshowed = false;
        TaskToggle.setForeground(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen));
        SpinNow.setBackground(ContextCompat.getDrawable(this, R.drawable.random_choose));
        ShowTaskInfo.setVisibility(View.INVISIBLE);
        StopButton.setVisibility(View.VISIBLE);
        viv.setVisibility(View.INVISIBLE);
        Quest.setVisibility(View.INVISIBLE);
        task.setVisibility(View.INVISIBLE);
        divider4.setVisibility(View.INVISIBLE);

        SpinLogoImg.setVisibility(View.INVISIBLE);
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation);
        final Animation animNotify = AnimationUtils.loadAnimation(this, R.anim.notifyanimation);
        SpinLogoImg.startAnimation(animShake);
        TaskToggle.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.button_bg_task_one));
        TaskToggle.startAnimation(animNotify);

        if (!TaskInfoShowed){
            TaskToggle.setVisibility(View.VISIBLE);
            ShowTaskInfo.setText("Show the new Task >>>");
            ShowTaskInfo.setVisibility(View.VISIBLE);
            TaskInfoShowed = true;
        }



        if (degreeNumbr == 0){
            degreeNumbr = RandomDgNumber;
        }
        else if(degreeNumbr > 1){
            degreeNumbr = degreeNumbr + RandomDgNumber;
        }


        RandomTask = (String) GetTasks.get(new Random().nextInt(GetTasks.size()));
        task.setText(RandomTask);

        if (Bottlespin == 1){ //2
            Bottlespin = 2;
            BottleImg.setVisibility(View.INVISIBLE);
            BottleImg2.setVisibility(View.VISIBLE);
            BottleImg2.animate().rotation(degreeNumbr).setDuration(3000);
            BottleImg.animate().rotation(degreeNumbr).setDuration(0);
        }

        else if (Bottlespin == 2){ //3
            Bottlespin = 3;
            BottleImg.setVisibility(View.VISIBLE);
            BottleImg2.setVisibility(View.INVISIBLE);
            BottleImg.animate().rotation(degreeNumbr).setDuration(3000);
            BottleImg2.animate().rotation(degreeNumbr).setDuration(0);
        }

        else if (Bottlespin == 3){ //4
            Bottlespin = 0;
            BottleImg.setVisibility(View.INVISIBLE);
            BottleImg2.setVisibility(View.VISIBLE);
            BottleImg2.animate().rotation(degreeNumbr).setDuration(3000);
            BottleImg.animate().rotation(degreeNumbr).setDuration(0);
        }

        else if (Bottlespin == 0){ //1
            Bottlespin = 1;
            BottleImg.setVisibility(View.VISIBLE);
            BottleImg2.setVisibility(View.INVISIBLE);
            BottleImg.animate().rotation(degreeNumbr).setDuration(3000);
            BottleImg2.animate().rotation(degreeNumbr).setDuration(0);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void ShowTask (View view){
        final Animation animQuest = AnimationUtils.loadAnimation(this, R.anim.questanimation);

        if(Taskshowed){
            Taskshowed = false;
            TaskToggle.setForeground(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen));
            TaskToggle.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.button_bg_task_tri));
            SpinNow.setBackground(ContextCompat.getDrawable(this, R.drawable.random_choose));
            ShowTaskInfo.setVisibility(View.INVISIBLE);
            StopButton.setVisibility(View.VISIBLE);
            viv.setVisibility(View.INVISIBLE);
            Quest.setVisibility(View.INVISIBLE);
            task.setVisibility(View.INVISIBLE);
            divider4.setVisibility(View.INVISIBLE);
        }
        else{
            Taskshowed = true;
            TaskInfoShowed = true;
            TaskToggle.setForeground(ContextCompat.getDrawable(this, R.drawable.ic_close));
            TaskToggle.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.button_bg_task_two));
            SpinNow.setBackground(ContextCompat.getDrawable(this, R.drawable.random_choose_two));
            ShowTaskInfo.setText("Close >>>");
            StopButton.setVisibility(View.INVISIBLE);
            Quest.startAnimation(animQuest);
            task.startAnimation(animQuest);
            task.setVisibility(View.VISIBLE);
            viv.setVisibility(View.VISIBLE);
            Quest.setVisibility(View.VISIBLE);
            task.setVisibility(View.VISIBLE);
            divider4.setVisibility(View.VISIBLE);
        }
    }

    public void Back (View view){super.onBackPressed();}
}