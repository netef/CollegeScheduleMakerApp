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
    public static boolean isAnotherShow=false;

    private EditText courseID;
    private EditText courseName;
    private Spinner dropBox;

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        //if resume and another show is true , meaning creating another show for the course
        if(isAnotherShow){
            anotherShow();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_course);
        //write the class as viewer at controller
        MainActivity.controller.addViewer(this);

        //Spinner assigenment
        Integer dropBoxItems[] = {1,2,3,4,5};
        dropBox = findViewById(R.id.dropBox);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dropBoxItems);
        dropBox.setAdapter(arrayAdapter);

        //course id edit text
        courseID = findViewById(R.id.courseID);

        //course name  edit text
        courseName = findViewById(R.id.courseName);

        //confiem button
        Button confirmbtn = findViewById(R.id.confirmBtn);
        confirmbtn.setOnClickListener(view -> {
            if(isAnotherShow) {
                isAnotherShow=false;
                MainActivity.controller.invokeConroller(Controller.DONE_CREATE_COURSE_ANOTHER_SHOW_VIEWER,this);
            }
            else MainActivity.controller.invokeConroller(Controller.DONE_CREATE_COURSE_VIEWER,this);
        });
        //check if activity should create another show or new course
        //if its another show secnrio


    }
    @Override
    public void createNewSlotPane() {
        Intent intent=new Intent(getApplicationContext(),CreateSlots.class);
        int numberOfSlots = getNumberOfSlots();
        intent.putExtra("amountOfSlots",numberOfSlots);
        startActivity(intent);
    }
    private void anotherShow() {
        //SET Course code from last show,Also disable editing.
        this.courseID.setEnabled(false);

        //SET Course name from last show,Also disable editing.
        this.courseName.setEnabled(false);
    }
    @Override
    public void courseCodeException() {
        courseID.setError("Course code already exist");
    }

    @Override
    public void courseNameException() {
        courseName.setError("Course name already exist");
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


    //UNUSED METHODS
    @Override
    public void createNewCoursePane() {

    }
    @Override
    public void createNewShowPane(int courseCode,String courseName){

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
