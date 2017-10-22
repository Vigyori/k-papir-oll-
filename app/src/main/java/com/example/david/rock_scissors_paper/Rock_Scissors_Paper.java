package com.example.david.rock_scissors_paper;


        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class Rock_Scissors_Paper extends AppCompatActivity {


    // változok létrehozása

    ImageView input, output;
    Button rock, paper, scissors;
    int[] images = new int[]{
            R.drawable.rock,
            R.drawable.paper,
            R.drawable.scissors
    };
    private Button ko, papir, ollo;
    private TextView eredmeny;
    private int human_score = 0, robot_score = 0;
    private ImageView ember, robot;
    int userinput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock__scissors__paper);


        //LAYOUTTAL VALÓ ÖSSZEKÖTÉS


        ko = (Button) findViewById(R.id.button_rock);
        papir = (Button) findViewById(R.id.button_paper);
        ollo = (Button) findViewById(R.id.button_scissors);
        eredmeny = (TextView) findViewById(R.id.textView_score);
        ember = (ImageView) findViewById(R.id.imageView_human);
        robot = (ImageView) findViewById(R.id.imageView_robot);

    /*    ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.rock);
            }
        });
        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.paper);
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.scissors);
            }
        });*/


    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_rock:
                userinput = 1;
                ember.setBackgroundResource(R.drawable.rock);
                setOutput();
                break;
            case R.id.button_paper:
                userinput = 2;
                ember.setBackgroundResource(R.drawable.paper);
                setOutput();
                break;
            case R.id.button_scissors:
                userinput = 3;
                ember.setBackgroundResource(R.drawable.scissors);
                setOutput();
                break;
        }
    }

    private void setOutput() {
        int imageId = (int) (Math.random() * images.length);
        robot.setBackgroundResource(images[imageId]);
        checkresult(imageId);
    }

    private void checkresult(int imageId) {
        if (userinput == 1 && imageId == 0) {     //User choose Rock,Computer choose Rock
            showresult(2);
        } else if (userinput == 1 && imageId == 1) { //User choose Rock,Computer choose Paper
            showresult(0);
        } else if (userinput == 1 && imageId == 2) { //User choose Rock,Computer choose Scissors
            showresult(1);
        } else if (userinput == 2 && imageId == 0) { //User choose Paper,Computer choose Rock
            showresult(1);
        } else if (userinput == 2 && imageId == 1) { //User choose Paper,Computer choose Paper
            showresult(2);
        } else if (userinput == 2 && imageId == 2) { //User choose Paper,Computer choose Scissors
            showresult(0);
        } else if (userinput == 3 && imageId == 0) {//User choose Scissors,Computer choose Rock
            showresult(0);
        } else if (userinput == 3 && imageId == 1) { //User choose Scissors,Computer choose Paper
            showresult(1);
        } else if (userinput == 3 && imageId == 2) { //User choose Scissors,Computer choose Scissors
            showresult(2);
        }
    }

    private void showresult(int result) {
        if (result == 0) {
            Toast.makeText(getApplicationContext(), "Vesztettél :'(", Toast.LENGTH_SHORT).show();
        } else if (result == 1)
            Toast.makeText(getApplicationContext(), "Nyertél! :)", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Döntetlen :P", Toast.LENGTH_SHORT).show();
    }
}
