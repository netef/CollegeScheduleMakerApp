package com.example.netef.oshriandnetef.Classes;

import java.util.ArrayList;

public interface IModel {
    void registerListener(Controller e);

    void createNewCourse(String[] courseInput);

    void createNewShow(String[][] strings);

    int getIvokingSlotNumber();

    ICourse[] getAllCoursesForViewer();

    void addCourseToSchedule(ICourse wantedCourse);

    ISlot[] getInokedSlots();

    void removeCourseFromSchedule(ICourse invokingCourseCheckboxes);

    //TODO FOR TESTING ONLY!!!
    Model getModelForTestingOnly();

    ArrayList<ICourse> getImpossibleCourses();

    void createAnotherShow(String[][] slotsInput);

    void removeShowsByDay(int invokingDayNumber);

    void addShowsByDay(int invokingDayNumber);

    void addPossibleShowsByDay(int invokingDayNumber);

    void removeShowsByHour(IHour iHour);

    void deleteSchedule();

    void addPossibleShowsByHour(IHour iHour);


    ICourse lastCratedCourse();

    void removeCourse(String s);
}
