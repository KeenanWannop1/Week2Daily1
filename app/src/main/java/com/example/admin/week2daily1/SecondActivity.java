package com.example.admin.week2daily1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static SeekBar seekBar1;
    private static SeekBar seekBar2;
    private static SeekBar seekBar3;
    private TextView textviewOne;
    private static int seekBarChanged = 0;
    private TextView textviewTwo;
    private TextView textviewThree;
    private TextView textviewAnswer;
    private double progressOne;
    private double progressTwo;
    private double progressThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        seekBar1 = findViewById(R.id.seekBarOne);
        textviewOne = findViewById(R.id.textViewAmount);
        seekBar2 = findViewById(R.id.seekBarTwo);
        textviewTwo = findViewById(R.id.textViewInterestRate);
        seekBar3 = findViewById(R.id.seekBarThree);
        textviewThree = findViewById(R.id.textViewLoanTenure);
        textviewAnswer = findViewById(R.id.textViewAnswer);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressOne = progress;
                seekBarChanged = 1;
                updateTextView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressTwo = progress;
                seekBarChanged = 2;
                updateTextView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressThree = progress;
                seekBarChanged = 3;
               updateTextView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }


        });
    }

    public void updateTextView(int progress) {
        double simpleInterest = progressTwo/(12*100);
        double emiAnswer = progressOne*(((simpleInterest*Math.pow((1+simpleInterest),(progressThree*12)))/((Math.pow((1+simpleInterest),(progressThree*12)))-1)));
        switch(seekBarChanged){
            case 1:
                textviewOne.setText(String.valueOf(progress));

                break;
            case 2:
                textviewTwo.setText(String.valueOf(progress));
                break;
            case 3:
                textviewThree.setText(String.valueOf(progress));
                break;
        }
        textviewAnswer.setText(String.valueOf("Estimated monthly payment: " + emiAnswer));
    }

}

