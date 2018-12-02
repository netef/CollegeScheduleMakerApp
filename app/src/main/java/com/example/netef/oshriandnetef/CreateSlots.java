package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.netef.oshriandnetef.Classes.Controller;
import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
import com.example.netef.oshriandnetef.Classes.ICourse;
import com.example.netef.oshriandnetef.Classes.IHour;
import com.example.netef.oshriandnetef.Classes.ISlot;
import com.example.netef.oshriandnetef.Classes.IView;
import com.example.netef.oshriandnetef.Classes.ScheduleButton;
import com.example.netef.oshriandnetef.Classes.SlotInputObjects;

import java.util.ArrayList;

import static android.os.Build.ID;
import static android.view.View.generateViewId;

public class CreateSlots extends AppCompatActivity implements IView {

    public static final String days[] = {"Sunday", "Monday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    public static final Integer hour[] = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
    public static final int NUMBER_OF_INPUTS_PER_SLOT = 5;

    private int amountOfSlots;
    private SlotInputObjects slotInputObjects [];
    private LinearLayout linearLayout;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    public void onDestroy() {
        super.onDestroy();
        //remove activivty from the controller before activivty destroy
        MainActivity.controller.removeViewer(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trying);
        MainActivity.controller.addViewer(this);

        //get extra data from intent , to assign slots number
        Bundle bundle=getIntent().getExtras();
        amountOfSlots = bundle.getInt("amountOfSlots");
        slotInputObjects = new SlotInputObjects[amountOfSlots];

        //Assigning big layout
        linearLayout = findViewById(R.id.myLinear);

        //Params declaration
        layoutParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //make Slots!
        makeSlots();

        //Buttons
        Button confirmBtn = new Button(this);
        Button createBtn = new Button(this);
        confirmBtn.setOnClickListener(view -> {
            MainActivity.controller.invokeConroller(Controller.DONE_CREATE_SLOTS_VIEWER,this);
        });
        createBtn.setOnClickListener(view -> {
            MainActivity.controller.invokeConroller(Controller.CREATE_ANOTHER_SHOW_VIEWER,this);
        });


        //Confirm button declaration and adding to Big Layout
        confirmBtn.setId(View.generateViewId());
        confirmBtn.setText("Confirm");
        confirmBtn.setTextSize(20);
        linearLayout.addView(confirmBtn, layoutParams);

        //Confirm button declaration and adding to Big Layout
        createBtn.setId(View.generateViewId());
        createBtn.setText("Create Another Show");
        createBtn.setTextSize(20);
        linearLayout.addView(createBtn, layoutParams);





    }
    @Override
    public void courseMenuPane(){
        CreateNewCourse.isAnotherShow=false;
        Intent intent = new Intent(getApplicationContext(),MainActivity.class) ;
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    @Override
    public void createNewShowPane(int courseCode,String courseName){
        CreateNewCourse.isAnotherShow=true;
        finish();


    }
    @Override
    public String[][] getSlotsInput(){
        String [][]slotsInput = new String[amountOfSlots][NUMBER_OF_INPUTS_PER_SLOT];


        for (int i = 0; i < amountOfSlots; i++) {
            slotsInput[i][0] = slotInputObjects[i].getDayComboBox().getSelectedItem().toString();
            slotsInput[i][1] = slotInputObjects[i].getStartTimeComboBox().getSelectedItem().toString();
            slotsInput[i][2] = slotInputObjects[i].getFinishTimeComboBox().getSelectedItem().toString();
            slotsInput[i][3] = slotInputObjects[i].getRoomNumber().getText().toString();
            slotsInput[i][4] = slotInputObjects[i].getLecturerName().getText().toString();
        }

        return slotsInput;
    }

    @Override
    public void slotTimingException(int slotNumber){
        //NOTIFY USER WHERE IS THE ERROR
        //slotInputObjects[slotNumber].getFinishTimeComboBox().setBackgroundColor(Color.RED);
        //slotInputObjects[slotNumber].getStartTimeComboBox().setBackgroundColor(Color.RED);
    }

    @Override
    public  void roomFullException(int slotNumber){

        //NOTIFY USER WHERE IS THE ERROR
        slotInputObjects[slotNumber].getRoomNumber().setError("Room occupied");

    }

    @Override
    public void teacherTeachingException(int slotNumber){

        //NOTIFY USER WHERE IS THE ERROR
        slotInputObjects[slotNumber].getLecturerName().setError("Teacher Busy");
    }
    @Override
    public void roomInputIsntAint(int slotNumber){
        //NOTIFY USER WHERE IS THE ERROR
        slotInputObjects[slotNumber].getRoomNumber().setError("Input must be a number");
    }

    private void makeSlots() {


        //Title and prefs
        TextView title = new TextView(this);
        title.setText("Create New Slots");
        title.setTextSize(30);
        title.setGravity(Gravity.CENTER);
        linearLayout.addView(title);

        //The slots
        for (int i = 0; i < amountOfSlots; i++) {
            slotInputObjects[i]=new SlotInputObjects();

            //Layout declaration
            LinearLayout spinners = new LinearLayout(this);
            LinearLayout editTexts = new LinearLayout(this);

            //Centering everything
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

            //Spinner assignment
            Spinner chooseDay = new Spinner(this);
            Spinner startTime = new Spinner(this);
            Spinner finishTime = new Spinner(this);
            //assign Spinners to data slots
            slotInputObjects[i].setDayComboBox(chooseDay);
            slotInputObjects[i].setFinishTimeComboBox(finishTime);
            slotInputObjects[i].setStartTimeComboBox(startTime);

            //EditText assignment
            EditText roomNumber = new EditText(this);
            EditText lecturerName = new EditText(this);
            //assign EditTexts to data slots
            slotInputObjects[i].setRoomNumber(roomNumber);
            slotInputObjects[i].setLecturerName(lecturerName);

            //Spinner layout prefs
            spinners.setId(View.generateViewId());
            spinners.setOrientation(LinearLayout.HORIZONTAL);

            //Edit text layout prefs
            editTexts.setId(View.generateViewId());
            editTexts.setOrientation(LinearLayout.HORIZONTAL);

            //ArrayAdapters
            ArrayAdapter dayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, days);
            ArrayAdapter hourAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, hour);

            //Assigning values to spinners
            chooseDay.setAdapter(dayAdapter);
            startTime.setAdapter(hourAdapter);
            finishTime.setAdapter(hourAdapter);


            //Assigning hints
            roomNumber.setHint("Room Number");
            lecturerName.setHint("Lecturer Name");

            //Adding GUI elements
            spinners.addView(chooseDay, layoutParams);
            spinners.addView(startTime, layoutParams);
            spinners.addView(finishTime, layoutParams);
            editTexts.addView(roomNumber, layoutParams);
            editTexts.addView(lecturerName, layoutParams);

            //Adding everything to the big layout
            linearLayout.addView(spinners, layoutParams);
            linearLayout.addView(editTexts, layoutParams);
        }



    }


    //UNUSED METHODS


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
