package com.example.netef.oshriandnetef.Classes;


import android.widget.Button;


public class ScheduleButton implements IHour {
    private boolean flag;
    private IDay.Day day;
    private int beginingHour;
    private Button button;

    public ScheduleButton(IDay.Day day, int beginingHour, Button button) {
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
}

