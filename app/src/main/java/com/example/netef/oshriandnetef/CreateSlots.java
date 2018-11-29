package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
import com.example.netef.oshriandnetef.Classes.ICourse;
import com.example.netef.oshriandnetef.Classes.IHour;
import com.example.netef.oshriandnetef.Classes.ISlot;
import com.example.netef.oshriandnetef.Classes.IView;
import com.example.netef.oshriandnetef.Classes.ScheduleButton;
import com.example.netef.oshriandnetef.Classes.SlotInputObjects;

import java.util.ArrayList;

public class CreateSlots extends AppCompatActivity implements IView {
    public static final int NUMBER_OF_INPUTS_PER_SLOT = 5;
    private int slotsNumber;
    private SlotInputObjects slotInputObjects [];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slots);
        //get extra data from intent , to assign slots number
        Bundle bundle=getIntent().getExtras();
        slotsNumber = bundle.getInt("amountOfSlots");
        slotInputObjects = new SlotInputObjects[slotsNumber];


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
    public int getCreatingCourseCode() {
        return 0;
    }

    @Override
    public void createNewCoursePane() {

    }

    @Override
    public void scheduleMakerPane(ICourse[] coursesName) {

    }

    @Override
    public void createNewSlotPane() {

    }

    @Override
    public void courseCodeException() {

    }

    @Override
    public void courseNameException() {

    }

    @Override
    public String[] getCourseInput() {
        return new String[0];
    }

    @Override
    public String[] getShowInput() {
        return new String[0];
    }

    @Override
    public int getNumberOfSlots() {
        return 0;
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
            slotsInput[i][0] = slotInputObjects[i].getDayComboBox().getSelectedItem().toString();
            slotsInput[i][1] = slotInputObjects[i].getStartTimeComboBox().getSelectedItem().toString();
            slotsInput[i][2] = slotInputObjects[i].getFinishTimeComboBox().getSelectedItem().toString();
            slotsInput[i][3] = slotInputObjects[i].getRoomNumber().getText().toString();
            slotsInput[i][4] = slotInputObjects[i].getLecturerName().getText().toString();
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

    @Override
    public int getInvokingDayNumber() {
        return 0;
    }

    @Override
    public CourseCheckBox getInvokingCourseCheckboxes() {
        return null;
    }

    @Override
    public void disableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber) {

    }

    @Override
    public void ableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber) {

    }

    @Override
    public void disableCoursesCBByHour(ArrayList<ICourse> impossibleCourses) {

    }

    @Override
    public void ableCoursesCBByHour(ArrayList<ICourse> impossibleCourses) {

    }

    @Override
    public void deactiveCollorButton(ScheduleButton button) {

    }

    @Override
    public void disableAndEnableCoursesCB(ArrayList<ICourse> impossibleCourses) {

    }

    @Override
    public void addSlotTOschedule(ISlot[] iSlots) {

    }

    @Override
    public void removeSlotFromschedule(ISlot[] inokedSlots) {

    }

    @Override
    public void changeColumnToDeactiveColor(int coulmn) {

    }

    @Override
    public void changeColumnToActiveColor(int coulmn) {

    }

    @Override
    public IHour getButtonInvoke() {
        return null;
    }

}
