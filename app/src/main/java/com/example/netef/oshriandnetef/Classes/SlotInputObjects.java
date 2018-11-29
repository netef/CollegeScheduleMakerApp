package com.example.netef.oshriandnetef.Classes;


import android.widget.EditText;
import android.widget.Spinner;

public class SlotInputObjects {
    private Spinner dayComboBox;
    private Spinner startTimeComboBox;
    private Spinner finishTimeComboBox;
    private EditText roomNumber;
    private EditText lecturerName;

    public Spinner getDayComboBox() {
        return dayComboBox;
    }

    public void setDayComboBox(Spinner dayComboBox) {
        this.dayComboBox = dayComboBox;
    }

    public Spinner getStartTimeComboBox() {
        return startTimeComboBox;
    }

    public void setStartTimeComboBox(Spinner startTimeComboBox) {
        this.startTimeComboBox = startTimeComboBox;
    }

    public Spinner getFinishTimeComboBox() {
        return finishTimeComboBox;
    }

    public void setFinishTimeComboBox(Spinner finishTimeComboBox) {
        this.finishTimeComboBox = finishTimeComboBox;
    }

    public EditText getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(EditText roomNumber) {
        this.roomNumber = roomNumber;
    }

    public EditText getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(EditText lecturerName) {
        this.lecturerName = lecturerName;
    }

}
