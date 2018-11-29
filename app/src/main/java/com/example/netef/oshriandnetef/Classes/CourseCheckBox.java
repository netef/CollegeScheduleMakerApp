package com.example.netef.oshriandnetef.Classes;

import android.widget.CheckBox;
import java.util.HashSet;

public class CourseCheckBox implements ICourse {

    private int showCode;
    private int courseCode;
    private String name;
    private HashSet<Integer> set;
    private CheckBox checkBox;

    public CourseCheckBox(String name, int courseCode, int showCode, CheckBox checkBox) {

        this.name = name;
        this.courseCode = courseCode;
        this.showCode = showCode;
        this.checkBox = checkBox;
        set = new HashSet<Integer>() {{
            add(showCode);
        }};
    }

    @Override
    public int getCourseCode() {
        return this.courseCode;
    }

    @Override
    public String getCourseName() {
        return this.name;
    }

    @Override
    public HashSet<Integer> getShowCodes() {
        return set;
    }

    public int getShowCode() {
        return this.courseCode;
    }


    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
