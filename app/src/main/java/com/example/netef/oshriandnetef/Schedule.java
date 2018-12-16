package com.example.netef.oshriandnetef;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.netef.oshriandnetef.Classes.Controller;
import com.example.netef.oshriandnetef.Classes.CourseCheckBox;
import com.example.netef.oshriandnetef.Classes.ICourse;
import com.example.netef.oshriandnetef.Classes.IDay;
import com.example.netef.oshriandnetef.Classes.IHour;
import com.example.netef.oshriandnetef.Classes.IShow;
import com.example.netef.oshriandnetef.Classes.ISlot;
import com.example.netef.oshriandnetef.Classes.IView;
import com.example.netef.oshriandnetef.Classes.ScheduleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Schedule extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IView {

        public static final int COURSE_CODE_DEFAULT = -1;
        public static final int SHOWS_PER_ROW = 3;
        public static final int INITIAL_HOUR_OF_SCHEDULE = 8;
        public static final int LAST_HOUR_OF_SCHEDULE = 23;
        public final int[] colorArray={Color.parseColor("#F2740B"),Color.parseColor("#00e676"),Color.parseColor("#ffff00"),
                Color.parseColor("#1a237e"),Color.parseColor("#ffcdd2"),Color.parseColor("#5d4037"),Color.parseColor("#7b1fa2"),
                Color.parseColor("#bbdefb")};


        private ScheduleButton[][] scheduleButtons;
        private TableLayout tableCourses;
        private TableLayout table;
        private TableLayout.LayoutParams tlp;
        private TableRow.LayoutParams lp;
        private CourseCheckBox[] coursesCheckboxes;
        private NavigationView navigationView;

        @Override
        protected void onDestroy() {
            super.onDestroy();
            MainActivity.controller.invokeConroller(Controller.SCHEDULE_DESTROY_VIEWER,this);
            //remove class from controller viewers collection
            MainActivity.controller.removeViewer(this);
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_schedule);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            //write the class as viewer at controller
            MainActivity.controller.addViewer(this);


            //Changes are made in activity_Schedule_drawer
            //If you want to edit the listeners go to the onNavigationItemSelected() method

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


            setupMainScheduleTable();
            tableCourses = findViewById(R.id.tableCourses);


            //uncomment to see courses CB
            MainActivity.controller.invokeConroller(Controller.CREATE_SCHEDULE_VIEWER, this);

            unusedColor=new HashSet<>();
            for (Integer color:colorArray)
            {
                unusedColor.add(color);

            }

        }

        private void setupNavigationView(ICourse[] allCoursesForViewer) {
            Menu menu = navigationView.getMenu();
            int amountOfShows = 0;
            for (ICourse course : allCoursesForViewer) {
                Iterator<Integer> iter = course.getIShows().keySet().iterator();
                while (iter.hasNext()) {
                    amountOfShows++;
                    iter.next();
                }
            }
            coursesCheckboxes = new CourseCheckBox[amountOfShows];
            int courseCount = 0;
            int showCount = 0;
            for (ICourse course : allCoursesForViewer) {

                //iteratr over shows per course
                Iterator<Map.Entry<Integer,IShow>> iter = course.getIShows().entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<Integer,IShow> entry=iter.next();
                    int showCode = entry.getKey();
                    //setup string for ui , lecturer and days
                    String titleString=allCoursesForViewer[courseCount].getCourseName();
                    HashMap<IDay.Day, HashSet<String>> map =entry.getValue().getDaysAndLecturerName();
                    for (IDay.Day day:map.keySet()) {
                        titleString=new String(titleString+" "+day.toString());
                        for (String lecturer:map.get(day)) {
                            titleString=new String(titleString+" "+lecturer.toString());

                        }

                    }
                    menu.add(Menu.FIRST, showCount, showCount, titleString);
                    menu.getItem(showCount).setIcon(R.drawable.unchecked_course);
                    menu.getItem(showCount).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            courseCheckBoxAction(menuItem);
                            return false;
                        }
                    });

                    //init coursesCheckboxes vars
                    coursesCheckboxes[showCount] = new CourseCheckBox(allCoursesForViewer[courseCount].getCourseName(),
                            allCoursesForViewer[courseCount].getCourseCode(), showCode, menu.getItem(showCount), false);
                    //counting shows per row
                    showCount++;

                }
                //counting shows for allCoursesForViewer array placing
                courseCount++;
            }

        }


        private void setupMainScheduleTable() {
            table = findViewById(R.id.table);
            tlp = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
            lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
            scheduleButtons = new ScheduleButton[6][LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE];
            TableRow days = new TableRow(this);
            lp.weight = 1;
            tlp.weight = 1;


            Button space = new Button(this);
            Button sunday = new Button(this);
            Button monday = new Button(this);
            Button tuesday = new Button(this);
            Button wednesday = new Button(this);
            Button thursday = new Button(this);
            Button friday = new Button(this);


            space.setVisibility(View.INVISIBLE);
            sunday.setText("S");
            monday.setText("M");
            tuesday.setText("T");
            wednesday.setText("W");
            thursday.setText("T");
            friday.setText("F");


            sunday.setBackgroundColor(Color.TRANSPARENT);
            monday.setBackgroundColor(Color.TRANSPARENT);
            tuesday.setBackgroundColor(Color.TRANSPARENT);
            wednesday.setBackgroundColor(Color.TRANSPARENT);
            thursday.setBackgroundColor(Color.TRANSPARENT);
            friday.setBackgroundColor(Color.TRANSPARENT);
            space.setMinimumHeight(180);
            sunday.setTextSize(20);
            monday.setTextSize(20);
            tuesday.setTextSize(20);
            wednesday.setTextSize(20);
            thursday.setTextSize(20);
            friday.setTextSize(20);


            days.addView(space, lp);
            days.addView(sunday, lp);
            days.addView(monday, lp);
            days.addView(tuesday, lp);
            days.addView(wednesday, lp);
            days.addView(thursday, lp);
            days.addView(friday, lp);

            table.addView(days, tlp);


            for (int i = 0; i < LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE; i++) {
                TextView hour = new TextView(this);
                TableRow row = new TableRow(this);
                hour.setText("" + (i + INITIAL_HOUR_OF_SCHEDULE));
                hour.setWidth(20);
                hour.setTextSize(24);
                hour.setGravity(Gravity.CENTER);
                //checkBox.setGravity(Gravity.CENTER);

                row.addView(hour, lp);
                for (int j = 0; j < 6; j++) {
                    Button tempBtn = new Button(this);
                    tempBtn.setId(View.generateViewId());
                    //tempBtn.setBackgroundColor(Color.TRANSPARENT);
                    //create schedulebutton by android button
                    ScheduleButton tempButton = new ScheduleButton(IDay.dayByInt(j + 1), i + INITIAL_HOUR_OF_SCHEDULE, tempBtn);
                    //set on action button
                    tempBtn.setOnClickListener(e -> scheduleButtonsUnAvctive(tempButton));
                    tempButton.setFlag(true);
                    scheduleButtons[j][i] = tempButton;

                    row.addView(tempBtn, lp);
                }
                table.addView(row, tlp);

            }
            table.setShrinkAllColumns(true);
        }

        private ScheduleButton buttonInvoke;
    private void scheduleButtonsUnAvctive(ScheduleButton button) {
              buttonInvoke = button;
      if (!buttonInvoke.isBlocked()) {
           MainActivity.controller.invokeConroller(Controller.SCHEDULE_BUTTON_UNACTIVE_VIEWER,this);
      } else {
          MainActivity.controller.invokeConroller(Controller.SCHEDULE_BUTTON_ACTIVE_VIEWER,this);
       }
    }

    private CourseCheckBox invokingCourseCheckboxes;

        @Override
        public void addSlotTOschedule(ISlot[] inokedSlots) {

            for (ISlot iSlot : inokedSlots) {
                int day = IDay.intByDay(iSlot.getDay().toString()) - 1;
                int startColumn = iSlot.getStartingTime() - INITIAL_HOUR_OF_SCHEDULE;
                int endColumn = iSlot.getEndingTime() - INITIAL_HOUR_OF_SCHEDULE;
                for (int i = startColumn; i < endColumn; i++) {
                    scheduleButtons[day][i].getButton().getBackground().setColorFilter(colorChoosed, PorterDuff.Mode.MULTIPLY);
                    scheduleButtons[day][i].setCourseCode(getInvokingCourseCheckboxes().getCourseCode());
                }

            }
        }

        @Override
        public void removeSlotFromschedule(ISlot[] inokedSlots) {
            for (ISlot iSlot : inokedSlots) {
                int day = IDay.intByDay(iSlot.getDay().toString()) - 1;
                int startColumn = iSlot.getStartingTime() - INITIAL_HOUR_OF_SCHEDULE;
                int endColumn = iSlot.getEndingTime() - INITIAL_HOUR_OF_SCHEDULE;
                for (int i = startColumn; i < endColumn; i++) {
                    scheduleButtons[day][i].getButton().getBackground().clearColorFilter();
                    scheduleButtons[day][i].setCourseCode(COURSE_CODE_DEFAULT);
                }

            }
        }

        @Override
        public CourseCheckBox getInvokingCourseCheckboxes() {
            return invokingCourseCheckboxes;
        }



    @Override
        public void disableAndEnableCoursesCB(ArrayList<ICourse> impossibleCourses) {

            Map<Integer, ICourse> mapOfCourses = new HashMap<Integer, ICourse>();
            for (ICourse existCourse : impossibleCourses) {
                mapOfCourses.put(existCourse.getCourseCode(), existCourse);
            }
            //CHECK ALL impossible Courses
            for (CourseCheckBox course : coursesCheckboxes) {
                //if the course isnt impossible
                if (mapOfCourses.get(course.getCourseCode()) == null) {
                    course.getMenuItem().setVisible(true);
                } else {
                   int  showCodeFX=course.getShowCode();

                        if (mapOfCourses.get(course.getCourseCode()).getShowCodes().contains(showCodeFX)) {
                            //if course selected its impssible by user -selected
                            if (course.isSelected() == true) {
                                course.getMenuItem().setVisible(true);
                            } else
                                course.getMenuItem().setVisible(false);
                        } else
                            course.getMenuItem().setVisible(true);

                }

            }
            for (CourseCheckBox iCourse : coursesCheckboxes) {// choose only one Show per course
                if (iCourse.isSelected()) {
                    for (CourseCheckBox iCourse2 : coursesCheckboxes) {
                        if (iCourse2.getCourseCode() == iCourse.getCourseCode()) {
                            if (iCourse2.isSelected() == false) {
                                iCourse2.getMenuItem().setVisible(false);
                            }
                        }
                    }
                }

            }
        }

        private int colorChoosed;
        private HashMap<MenuItem,Integer> usedColor=new HashMap<>();
        private HashSet<Integer> unusedColor;
        private void courseCheckBoxAction(MenuItem menuItem) {
            invokingCourseCheckboxes = coursesCheckboxes[menuItem.getItemId()];
            if (!invokingCourseCheckboxes.isSelected()) {
                invokingCourseCheckboxes.setSelected(true);
                colorChoosed=colorArray[0];//cyan color is default , if no colors left
                if(!unusedColor.isEmpty()) {
                    colorChoosed= unusedColor.iterator().next();
                    unusedColor.remove(colorChoosed);
                }

                MainActivity.controller.invokeConroller(Controller.COURSE_CHECKBOX_ACTIVATED,true);
                //changing color to specific color.
                SpannableString s = new SpannableString(menuItem.getTitle());
                s.setSpan(new ForegroundColorSpan(colorChoosed), 0, s.length(), 0);
                menuItem.setTitle(s);
                menuItem.setIcon(R.drawable.checked_course);
                usedColor.put(menuItem,colorChoosed);

            } else {
                unusedColor.add(usedColor.get(menuItem));
                usedColor.remove(menuItem);
                invokingCourseCheckboxes.setSelected(false);

                MainActivity.controller.invokeConroller(Controller.COURSE_CHECKBOX_DEACTIVATED,true);
                //changing color to default=black
                unselecteUIMenuItem(menuItem);


            }
        }

    private void unselecteUIMenuItem(MenuItem menuItem) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, s.length(), 0);
        menuItem.setTitle(s);
        menuItem.setIcon(R.drawable.unchecked_course);
    }


    @Override
        public void onBackPressed() {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.schedule, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.


            //add this if you want to close the drawer after you click

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            //drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public void setCourses(ICourse[] allCoursesForViewer) {
            setupNavigationView(allCoursesForViewer);

        }

        @Override
        public void deactiveCollorButton(ScheduleButton button) {
            button.getButton().getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
            button.setBlocked(true);
        }

        @Override
        public void disableCoursesCBByHour(ArrayList<ICourse> impossibleCourses) {
            disableAndEnableCoursesCB(impossibleCourses);
            deactiveCollorButton(buttonInvoke);
            disableSelcetedCourseByHour(buttonInvoke,impossibleCourses);
            clearCollorCoulmnByHour(buttonInvoke);
            buttonInvoke.setCourseCode(COURSE_CODE_DEFAULT);


        }
    private void disableSelcetedCourseByHour(ScheduleButton buttonInvoke,ArrayList<ICourse> impossibleCourses) {
            //allow to choose another show from disabled course
        Map<Integer, ICourse> mapOfImpossibleCourses = new HashMap<Integer, ICourse>();
        for (ICourse existCourse : impossibleCourses) {
            mapOfImpossibleCourses.put(existCourse.getCourseCode(), existCourse);
        }
        for (CourseCheckBox iCourse : coursesCheckboxes) {
                    if (buttonInvoke.getCourseCode() == iCourse.getCourseCode()) {
                        if(mapOfImpossibleCourses.get(buttonInvoke.getCourseCode())!=null) {
                            if (!mapOfImpossibleCourses.get(buttonInvoke.getCourseCode()).getShowCodes().contains(iCourse.getShowCode())) {
                                iCourse.getMenuItem().setVisible(true);
                            }
                        }

                    }
                }



        //disabled blocked course
        for (CourseCheckBox course : coursesCheckboxes) {
                if (course.isSelected() && buttonInvoke.getCourseCode() == (course.getCourseCode())) {
                    course.setSelected(false);
                    course.getMenuItem().setVisible(false);
                    unselecteUIMenuItem(course.getMenuItem());

                }
            }


    }
    private void clearCollorCoulmnByHour(ScheduleButton buttonInvoke) {


        int dayNumber = IDay.intByDay(buttonInvoke.getDay().toString())-1;
        int courseCode = buttonInvoke.getCourseCode();
        // remove all courses of the invoking hour
        // remove show from other days
        for (int i = 0; i < scheduleButtons.length; i++) {
            for (int j = 0; j < scheduleButtons[i].length; j++) {
                if (scheduleButtons[i][j].isBlocked() == false) {
                    if (scheduleButtons[i][j].getCourseCode() == courseCode) {
                        scheduleButtons[i][j].getButton().getBackground().clearColorFilter();
                        scheduleButtons[i][j].setCourseCode(COURSE_CODE_DEFAULT);
                    }
                }
            }
        }

    }
    @Override
    public IHour getButtonInvoke() {
        return (IHour) this.buttonInvoke;
    }

    @Override
    public void ableCoursesCBByHour(ArrayList<ICourse> impossibleCourses) {
        activeCollorButton(buttonInvoke);
        disableAndEnableCoursesCB(impossibleCourses);
    }
    public void activeCollorButton(ScheduleButton button) {
        button.getButton().getBackground().clearColorFilter();
        button.setBlocked(false);
    }

        //unused methods !!

        @Override
        public void createNewCoursePane() {

        }

        @Override
        public void scheduleMakerPane() {

        }

        @Override
        public void createNewSlotPane() {

        }
    @Override
    public void disableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber) {

    }
        @Override
        public void courseCodeException() {

        }

        @Override
        public void courseNameException() {

        }
        @Override
        public void slotMatchingHoursException(int ivokingSlotNumber) {

        }
        @Override
        public void courseCodeNotAnIntegerException() {

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
        public void ableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber) {

        }






        @Override
        public void changeColumnToDeactiveColor(int coulmn) {

        }

        @Override
        public void changeColumnToActiveColor(int coulmn) {

        }


}
