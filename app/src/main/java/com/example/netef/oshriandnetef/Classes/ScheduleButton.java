package com.example.netef.oshriandnetef.Classes;


import android.widget.Button;

import com.example.netef.oshriandnetef.Schedule;


public class ScheduleButton implements IHour {
    private boolean flag;
    private IDay.Day day;
    private int beginingHour;
    private Button button;
    private int courseCode;
    private boolean blocked;

    public ScheduleButton(IDay.Day day, int beginingHour, Button button) {
        this.blocked=false;
        this.courseCode=Schedule.COURSE_CODE_DEFAULT;
        this.day = day;
        this.beginingHour = beginingHour;
        setFlag(true);
        this.button = button;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getBeginingHour() {
        return beginingHour;
    }

    public IDay.Day getDay() {
        return day;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode=courseCode;
    }

    public int getCourseCode() {
        return courseCode;
    }


    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}

