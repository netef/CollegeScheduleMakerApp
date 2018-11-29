package com.example.netef.oshriandnetef;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_course);

        Integer dropBoxItems[] = {1,2,3,4,5};
        EditText courseID = findViewById(R.id.courseID);
        EditText courseName = findViewById(R.id.courseName);
        Spinner dropBox = findViewById(R.id.dropBox);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dropBoxItems);
        dropBox.setAdapter(arrayAdapter);
        Button confirmbtn = findViewById(R.id.confirmBtn);
        confirmbtn.setOnClickListener(view -> {
            MainActivity.controller.invokeConroller(Controller.DONE_CREATE_SHOW_VIEWER);
        });

    }
    @Override
    public void createNewSlotPane(int amountOfSlots) {
        Intent intent=new Intent(getApplicationContext(),createSlot.class);
        startActivity(intent);
    }
    //TODO - NETEF
    @Override
    public void courseCodeException() {

    }
    //TODO - NETEF
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
    //UNUSED METHODS
    @Override
    public void createNewCoursePane() {

    }

    @Override
    public void scheduleMakerPane(ICourse[] coursesName) {

    }





    @Override
    public Node createNewShowPane(int courseCode) {
        return null;
    }

    @Override
    public Node courseMenuPane() {
        return null;
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
