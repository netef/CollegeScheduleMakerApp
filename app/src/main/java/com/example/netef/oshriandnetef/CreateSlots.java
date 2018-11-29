package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.netef.oshriandnetef.Classes.IView;

public class CreateSlots extends AppCompatActivity implements IView {
    public static final int NUMBER_OF_INPUTS_PER_SLOT = 5;
    private int slotsNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slots);
        //get extra data from intent , to assign slots number
        Bundle bundle=getIntent().getExtras();
        slotsNumber = bundle.getInt("amountOfSlots");

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
    @Override
    public Node createNewShowPane(int courseCode){

    }
    @Override
    public void courseMenuPane(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class) ;
        startActivity(intent);
    }
    //TODO NETEF
    @Override
    public String[][] getSlotsInput(){
        String [][]slotsInput = new String[slotsNumber][NUMBER_OF_INPUTS_PER_SLOT];
        for (int i = 0; i < slotsNumber; i++) {
            slotsInput[i][0] = (String) slotComboBoxandTextField[i].getDayComboBox().getValue();
            slotsInput[i][1] = (String) slotComboBoxandTextField[i].getStartTimeComboBox().getValue();
            slotsInput[i][2] = (String) slotComboBoxandTextField[i].getFinishTimeComboBox().getValue();
            slotsInput[i][3] = slotComboBoxandTextField[i].getRoomNumber().getText();
            slotsInput[i][4] = slotComboBoxandTextField[i].getLecturerName().getText();
        }

        return slotsInput;
    }
    //TODO NETEF
    @Override
    public void slotTimingException(int slotNumber){

    }
    //TODO NETEF
    @Override
    public  void roomFullException(int slotNumber){

    }
    //TODO NETEF
    @Override
    public void teacherTeachingException(int slotNumber){

    }
    //TODO NETEF
    @Override
    public void roomInputIsntAint(int slotNumber){

    }

}
