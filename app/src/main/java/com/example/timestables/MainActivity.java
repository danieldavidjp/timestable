package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

     ListView myListView;


    public void generateTimesTable(int timesTableNumber) {

        ArrayList<String> timeNumbers = new ArrayList<String>();

        for(int i = 1; i <= 10; i++){
            timeNumbers.add(Integer.toString(i*timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeNumbers);

        myListView.setAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar); // make seekbar object

        myListView = findViewById(R.id.myListView);
        int max = 20; // Set maximun value of seekbar
        int startingPoint = 15;//Set Starting point of the seekbar
        generateTimesTable(startingPoint);
        seekBar.setMax(max);
        seekBar.setProgress(startingPoint);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                int min = 1;
                int timesTableNumber;
                if (progress < min){

                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }else{

                    timesTableNumber = progress;
                }
                Log.i("Seek Bar Value",Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }
        });


    }
}
