package com.example.netef.oshriandnetef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.netef.oshriandnetef.Classes.IView;

public class CreateSlots extends AppCompatActivity implements IView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slots);

        //Variables
        String days[] = {"Sunday", "Monday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Integer time[] = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};

        //Adapters
        ArrayAdapter dayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, days);
        ArrayAdapter timeAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, time);

        //DropBoxes
        Spinner chooseDay = findViewById(R.id.chooseDay);
        Spinner startTime = findViewById(R.id.startTime);
        Spinner finishTime = findViewById(R.id.finishTime);

        //User Input
        EditText roomNumber = findViewById(R.id.roomNumber);
        EditText lecturerName = findViewById(R.id.lecturerName);

        //Buttons
        Button confirmBtn = findViewById(R.id.confirmBtn);
        Button createBtn = findViewById(R.id.createBtn);

        //Setting The Adapters
        chooseDay.setAdapter(dayAdapter);
        startTime.setAdapter(timeAdapter);
        finishTime.setAdapter(timeAdapter);


    }
}
