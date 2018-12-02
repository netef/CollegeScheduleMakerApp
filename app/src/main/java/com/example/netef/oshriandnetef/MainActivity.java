package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.netef.oshriandnetef.Classes.Controller;
import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
import com.example.netef.oshriandnetef.Classes.ICourse;
import com.example.netef.oshriandnetef.Classes.IHour;
import com.example.netef.oshriandnetef.Classes.ISlot;
import com.example.netef.oshriandnetef.Classes.IView;
import com.example.netef.oshriandnetef.Classes.Model;
import com.example.netef.oshriandnetef.Classes.ScheduleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView {
    public static Controller controller;
    private static boolean firstRun=true;

    @Override
    public void onDestroy() {
        super.onDestroy();
        //remove activivty from the controller before activivty destroy
        MainActivity.controller.removeViewer(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(firstRun) {
            firstRun=false;
            Model model = new Model();
            controller = new Controller(model);
            controller.addViewer(this);
        }
        Button createBtn = findViewById(R.id.createBtn);
        Button scheduleBtn = findViewById(R.id.scheduleBtn);

        createBtn.setOnClickListener(v -> {
            controller.invokeConroller(Controller.CREATE_COURSE_VIEWER,this);
        });
        scheduleBtn.setOnClickListener(v -> {
            controller.invokeConroller(Controller.DONE_CREATE_ALL_COURSES_VIEWER,this);
        });
    }

    @Override
    public void scheduleMakerPane(ICourse[] coursesName) {
        Intent intent = new Intent(getApplicationContext(), Schedule.class);
        startActivity(intent);
    }
    @Override
    public void createNewCoursePane() {
        Intent intent = new Intent(getApplicationContext(), CreateNewCourse.class);
        intent.putExtra("isAnotherShow",false);
        startActivity(intent);
    }

    //UNUSED FUNCTIONS

    @Override
    public void courseMenuPane() {
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
    public void createNewShowPane(int courseCode,String courseName){

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
