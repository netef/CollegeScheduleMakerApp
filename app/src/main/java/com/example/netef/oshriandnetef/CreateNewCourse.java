package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.netef.oshriandnetef.Classes.Controller;
import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
import com.example.netef.oshriandnetef.Classes.ICourse;
import com.example.netef.oshriandnetef.Classes.IHour;
import com.example.netef.oshriandnetef.Classes.ISlot;
import com.example.netef.oshriandnetef.Classes.IView;
import com.example.netef.oshriandnetef.Classes.ScheduleButton;

import java.util.ArrayList;

public class CreateNewCourse extends AppCompatActivity implements IView {

    public static final int NUMBER_OF_INPUTS_PER_COURSE = 2;
    public static final int NUMBER_OF_INPUTS_PER_SHOW = 1;

    private EditText courseID;
    private EditText courseName;
    private Spinner dropBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_course);

        Integer dropBoxItems[] = {1,2,3,4,5};
        courseID = findViewById(R.id.courseID);
        courseName = findViewById(R.id.courseName);
        dropBox = findViewById(R.id.dropBox);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dropBoxItems);
        dropBox.setAdapter(arrayAdapter);
        Button confirmbtn = findViewById(R.id.confirmBtn);
        confirmbtn.setOnClickListener(view -> {
            MainActivity.controller.invokeConroller(Controller.DONE_CREATE_SHOW_VIEWER);
        });

    }
    @Override
    public void createNewSlotPane(int amountOfSlots) {
        Intent intent=new Intent(getApplicationContext(),CreateSlots.class);
        intent.putExtra("amountOfSlots",amountOfSlots);
        startActivity(intent);
    }

    @Override
    public void courseCodeException() {
        courseID.setBackgroundColor(Color.RED);
        courseID.setText("Course code already exist");
    }

    @Override
    public void courseNameException() {
        courseName.setBackgroundColor(Color.RED);
        courseName.setText("Course name already exist");
    }

    @Override
    public String[] getCourseInput() {
        String[] courseInput = new String[NUMBER_OF_INPUTS_PER_COURSE];
        courseInput[0] = courseID.getText().toString();
        courseInput[1] = courseName.getText().toString();
        return courseInput;
    }
    @Override
    public String[] getShowInput() {
        String[] showInput = new String[NUMBER_OF_INPUTS_PER_SHOW];
        showInput[0] = courseID.getText().toString();
        return showInput;
    }
    @Override
    public int getNumberOfSlots() {
        //get index of selcted index , adding one because series number start at 1 and the indexes with 0
        return dropBox.getSelectedItemPosition()+1;
    }

    @Override
    public int getCreatingCourseCode() {
        return 0;
    }

    //UNUSED METHODS
    @Override
    public void createNewCoursePane() {

    }

    @Override
    public void scheduleMakerPane(ICourse[] coursesName) {

    }

    @Override
    public void courseMenuPane() {

    }

    @Override
    public String[][] getSlotsInput() {
        return new String[0][];
    }

    @Override
    public void slotTimingException(int slotNumber) {

    }

    @Override
    public void roomFullException(int slotNumber) {

    }

    @Override
    public void teacherTeachingException(int slotNumber) {

    }

    @Override
    public void roomInputIsntAint(int slotNumber) {

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
