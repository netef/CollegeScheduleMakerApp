package com.example.netef.oshriandnetef.Classes;

import java.util.ArrayList;

import javafx.event.EventHandler;

public interface IModel {
    void registerListener(EventHandler<MyActionEvent> e);

    void createNewCourse(String[] courseInput);

    void createNewShow(int courseCode, String[][] strings);

    int getIvokingSlotNumber();

    ICourse[] getAllCoursesForViewer();

    void addCourseToSchedule(ICourse wantedCourse);

    ISlot[] getInokedSlots();

    void removeCourseFromSchedule(ICourse invokingCourseCheckboxes);

    //TODO FOR TESTING ONLY!!!
    Model getModelForTestingOnly();

    ArrayList<ICourse> getImpossibleCourses();

    void createAnotherShow(int creatingCourseCode, String[][] slotsInput);

    void removeShowsByDay(int invokingDayNumber);

    void addShowsByDay(int invokingDayNumber);

    void addPossibleShowsByDay(int invokingDayNumber);

    void removeShowsByHour(IHour iHour);

    void addPossibleShowsByHour(IHour iHour);


}
