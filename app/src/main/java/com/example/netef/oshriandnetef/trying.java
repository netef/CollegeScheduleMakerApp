package com.example.netef.oshriandnetef;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
import com.example.netef.oshriandnetef.Classes.ICourse;
import com.example.netef.oshriandnetef.Classes.IDay;
import com.example.netef.oshriandnetef.Classes.IHour;
import com.example.netef.oshriandnetef.Classes.ISlot;
import com.example.netef.oshriandnetef.Classes.IView;
import com.example.netef.oshriandnetef.Classes.ScheduleButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class trying extends AppCompatActivity implements IView {

    public static final int INITIAL_HOUR_OF_SCHEDULE = 8;
    public static final int LAST_HOUR_OF_SCHEDULE = 22;
    private ScheduleButton[][] scheduleButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trying);


        LinearLayout linear = findViewById(R.id.linear);
        LinearLayout days = new LinearLayout(this);

        LinearLayout.LayoutParams tlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        days.setLayoutParams(tlp);

        TextView sunday = new TextView(this);
        TextView monday = new TextView(this);
        TextView tuesday = new TextView(this);
        TextView wednesday = new TextView(this);
        TextView thursday = new TextView(this);
        TextView friday = new TextView(this);
        TextView saturday = new TextView(this);


        TableLayout table = findViewById(R.id.table);

        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

        //days specification
        sunday.setText("Sun");
        sunday.setPadding(100,0,95,0);
        monday.setText("Mon");
        monday.setPadding(0,0,95,0);
        tuesday.setText("Tue");
        tuesday.setPadding(0,0,95,0);
        wednesday.setText("Wed");
        wednesday.setPadding(0,0,95,0);
        thursday.setText("Thu");
        thursday.setPadding(0,0,95,0);
        friday.setText("Fri");

        //add days to linear layout
        days.addView(sunday);
        days.addView(monday);
        days.addView(tuesday);
        days.addView(wednesday);
        days.addView(thursday);
        days.addView(friday);

        linear.addView(days, 0);


        scheduleButtons = new ScheduleButton[6][LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE];
        for (int i = 0; i < LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE; i++) {
            TextView hour = new TextView(this);
            hour.setText("" + (i+INITIAL_HOUR_OF_SCHEDULE));
            hour.setWidth(150);
            hour.setGravity(Gravity.CENTER);
            TableRow row = new TableRow(this);
            row.setLayoutParams(lp);
            row.addView(hour);
            for (int j = 0; j < 6; j++) {
                Button tempBtn = new Button(this);
                tempBtn.setId(View.generateViewId());
                tempBtn.setWidth(10);
                tempBtn.setMaxLines(2);
                tempBtn.setTextSize(10);
                tempBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
                //create schedulebutton by android button
                ScheduleButton tempButton = new ScheduleButton(IDay.dayByInt(j + 1), i + INITIAL_HOUR_OF_SCHEDULE,tempBtn);
                //set on action button
                //tempButton.setOnAction(e -> scheduleButtonsUnAvctive(tempButton));
                tempButton.setFlag(true);
                scheduleButtons[j][i] = tempButton;

                row.addView(tempBtn, lp);
            }
            table.addView(row, tlp);
        }
        scheduleButtons[2][4].getButton().setText("wow213sad");
        table.setShrinkAllColumns(true);

    }

    @Override
    public void deactiveCollorButton(ScheduleButton button) {
        button.getButton().setBackgroundColor(Color.BLACK);
        button.setFlag(false);
    }

    //unused methods !!

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
    public void createNewShowPane(int courseCode, String courseName) {

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
