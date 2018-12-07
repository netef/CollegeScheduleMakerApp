//package com.example.netef.oshriandnetef;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.FrameLayout;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//
//import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
//import com.example.netef.oshriandnetef.Classes.ICourse;
//import com.example.netef.oshriandnetef.Classes.IDay;
//import com.example.netef.oshriandnetef.Classes.IHour;
//import com.example.netef.oshriandnetef.Classes.ISlot;
//import com.example.netef.oshriandnetef.Classes.IView;
//import com.example.netef.oshriandnetef.Classes.ScheduleButton;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class trying extends AppCompatActivity implements IView {
//
//    public static final int SHOWS_PER_ROW = 3;
//    public static final int INITIAL_HOUR_OF_SCHEDULE = 8;
//    public static final int LAST_HOUR_OF_SCHEDULE = 23;
//
//    private ScheduleButton[][] scheduleButtons;
//    private TableLayout tableCourses;
//    private CourseCheckBox[] coursesCheckboxes;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trying);
//
//        TableLayout table = findViewById(R.id.table);
//        setupMainScheduleTable(table);
//        tableCourses = findViewById(R.id.tableCourses);
//        //uncomment to see courses CB
//        //MainActivity.controller.invokeConroller(Controller.CREATE_SCHEDULE_VIEWER,this);
//
//
//        table.setShrinkAllColumns(true);
//
//    }
//
//
//
//    private void setupMainScheduleTable(TableLayout table) {
//        scheduleButtons = new ScheduleButton[6][LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE];
//        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//        TableRow days = new TableRow(this);
//        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
//
//        Button space = new Button(this);
//        Button sunday = new Button(this);
//        Button monday = new Button(this);
//        Button tuesday = new Button(this);
//        Button wednesday = new Button(this);
//        Button thursday = new Button(this);
//        Button friday = new Button(this);
//
//        space.setVisibility(View.INVISIBLE);
//        sunday.setText("S");
//        monday.setText("M");
//        tuesday.setText("T");
//        wednesday.setText("W");
//        thursday.setText("T");
//        friday.setText("F");
//
//        sunday.setBackgroundColor(Color.TRANSPARENT);
//        monday.setBackgroundColor(Color.TRANSPARENT);
//        tuesday.setBackgroundColor(Color.TRANSPARENT);
//        wednesday.setBackgroundColor(Color.TRANSPARENT);
//        thursday.setBackgroundColor(Color.TRANSPARENT);
//        friday.setBackgroundColor(Color.TRANSPARENT);
//
//        sunday.setTextSize(20);
//        monday.setTextSize(20);
//        tuesday.setTextSize(20);
//        wednesday.setTextSize(20);
//        thursday.setTextSize(20);
//        friday.setTextSize(20);
//
//
//        days.addView(space);
//        days.addView(sunday);
//        days.addView(monday);
//        days.addView(tuesday);
//        days.addView(wednesday);
//        days.addView(thursday);
//        days.addView(friday);
//
//        table.addView(days);
//
//
//
//        for (int i = 0; i < LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE; i++) {
//            TextView hour = new TextView(this);
//            hour.setText("" + (i + INITIAL_HOUR_OF_SCHEDULE));
//            hour.setWidth(20);
//            hour.setTextSize(20);
//            hour.setGravity(Gravity.CENTER);
//            //checkBox.setGravity(Gravity.CENTER);
//            TableRow row = new TableRow(this);
//            row.setLayoutParams(lp);
//            row.addView(hour);
//            for (int j = 0; j < 6; j++) {
//                Button tempBtn = new Button(this);
//                tempBtn.setId(View.generateViewId());
//                //tempBtn.setBackgroundColor(Color.TRANSPARENT);
//                //create schedulebutton by android button
//                ScheduleButton tempButton = new ScheduleButton(IDay.dayByInt(j + 1), i + INITIAL_HOUR_OF_SCHEDULE, tempBtn);
//                //set on action button
//                //tempButton.setOnAction(e -> scheduleButtonsUnAvctive(tempButton));
//                tempButton.setFlag(true);
//                scheduleButtons[j][i] = tempButton;
//
//                row.addView(tempBtn, lp);
//            }
//            table.addView(row);
//            table.setStretchAllColumns(true);
//        }
//    }
//
//    @Override
//    public void setCourses(ICourse[] allCoursesForViewer) {
//        //Every course has one or more shows, need to counting them before malloc the array
//        int amountOfShows = 0;
//        for (ICourse course : allCoursesForViewer) {
//            Iterator<Integer> iter = course.getShowCodes().iterator();
//            while (iter.hasNext()) {
//                amountOfShows++;
//                iter.next();
//            }
//        }
//        coursesCheckboxes = new CourseCheckBox[amountOfShows];
//        int courseCount = 0;
//        int showCount = 0;
//        TableRow row = null;
//        int showsPerRow = SHOWS_PER_ROW;
//        for (ICourse course : allCoursesForViewer) {
//
//
//            //iteratr ove shows per course
//            Iterator<Integer> iter = course.getShowCodes().iterator();
//            while (iter.hasNext()) {
//
//                //checking  if shows per row is true
//                //CREATE NEW ROW FOR 3 COURES AT MOST
//                if (showsPerRow == SHOWS_PER_ROW) {
//                    showsPerRow = 0;
//                    row = new TableRow(this);
//                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//                    row.setLayoutParams(lp);
//                    //adding the row to the upper table
//                    tableCourses.addView(row);
//                }
//                //init check box
//                CheckBox checkBox = new CheckBox(this);
//                checkBox.setText(allCoursesForViewer[courseCount].getCourseName());
//                checkBox.setTextSize(14);
//                //adding checkbox to row
//                row.addView(checkBox);
//                int showCode = iter.next();
//                //init coursesCheckboxes vars
//                coursesCheckboxes[showCount] = new CourseCheckBox(allCoursesForViewer[courseCount].getCourseName(),
//                        allCoursesForViewer[courseCount].getCourseCode(), showCode, checkBox);
//                //coursesCheckboxes[i].setOnAction(e -> courseCheckBoxAction((CourseCheckBox) e.getSource()));
//                //counting  if shows per row is true
//                showsPerRow++;
//                //counting shows per row
//                showCount++;
//            }
//            //counting shows for allCoursesForViewer array placing
//            courseCount++;
//
//        }
//
//    }
//
//    @Override
//    public void deactiveCollorButton(ScheduleButton button) {
//        button.getButton().setBackgroundColor(Color.BLACK);
//        button.setFlag(false);
//    }
//
//    //unused methods !!
//
//    @Override
//    public void createNewCoursePane() {
//
//    }
//
//    @Override
//    public void scheduleMakerPane() {
//
//    }
//
//    @Override
//    public void createNewSlotPane() {
//
//    }
//
//    @Override
//    public void courseCodeException() {
//
//    }
//
//    @Override
//    public void courseNameException() {
//
//    }
//
//    @Override
//    public String[] getCourseInput() {
//        return new String[0];
//    }
//
//    @Override
//    public String[] getShowInput() {
//        return new String[0];
//    }
//
//    @Override
//    public int getNumberOfSlots() {
//        return 0;
//    }
//
//    @Override
//    public void createNewShowPane(int courseCode, String courseName) {
//
//    }
//
//    @Override
//    public void courseMenuPane() {
//
//    }
//
//    @Override
//    public String[][] getSlotsInput() {
//        return new String[0][];
//    }
//
//    @Override
//    public void slotTimingException(int slotNumber) {
//
//    }
//
//    @Override
//    public void roomFullException(int slotNumber) {
//
//    }
//
//    @Override
//    public void teacherTeachingException(int slotNumber) {
//
//    }
//
//    @Override
//    public void roomInputIsntAint(int slotNumber) {
//
//    }
//
//    @Override
//    public int getInvokingDayNumber() {
//        return 0;
//    }
//
//    @Override
//    public CourseCheckBox getInvokingCourseCheckboxes() {
//        return null;
//    }
//
//    @Override
//    public void disableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber) {
//
//    }
//
//    @Override
//    public void ableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber) {
//
//    }
//
//    @Override
//    public void disableCoursesCBByHour(ArrayList<ICourse> impossibleCourses) {
//
//    }
//
//    @Override
//    public void ableCoursesCBByHour(ArrayList<ICourse> impossibleCourses) {
//
//    }
//
//
//    @Override
//    public void disableAndEnableCoursesCB(ArrayList<ICourse> impossibleCourses) {
//
//    }
//
//    @Override
//    public void addSlotTOschedule(ISlot[] iSlots) {
//
//    }
//
//    @Override
//    public void removeSlotFromschedule(ISlot[] inokedSlots) {
//
//    }
//
//    @Override
//    public void changeColumnToDeactiveColor(int coulmn) {
//
//    }
//
//    @Override
//    public void changeColumnToActiveColor(int coulmn) {
//
//    }
//
//    @Override
//    public IHour getButtonInvoke() {
//        return null;
//    }
//
//}
