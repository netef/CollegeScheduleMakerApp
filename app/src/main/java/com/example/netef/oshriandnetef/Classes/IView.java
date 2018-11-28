package com.example.netef.oshriandnetef.Classes;


import java.util.ArrayList;

public interface IView {
    //maybe remove
    Node createNewShowPane(int courseCode);
    Node courseMenuPane();


    //1
    Node createNewCoursePane();
    void scheduleMakerPane(ICourse[] coursesName);
    //2
    Node createNewSlotPane(int amountOfSlots);
    void courseCodeException();

    void courseNameException();

    int getCreatingCourseCode();
    String[] getCourseInput();

    String[] getShowInput();
    //3
    void setMainPane(Node p);
    String[][] getSlotsInput();
    void slotTimingException(int slotNumber);
    void roomFullException(int slotNumber);
    void teacherTeachingException(int slotNumber);
    void roomInputIsntAint(int slotNumber);
    int getNumberOfSlots();
    //4
    int getInvokingDayNumber();
    CourseCheckBox getInvokingCourseCheckboxes();
    void disableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber);
    void ableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber);
    void disableCoursesCBByHour(ArrayList<ICourse> impossibleCourses);
    void ableCoursesCBByHour(ArrayList<ICourse> impossibleCourses);
    void deactiveCollorButton(ScheduleButton button);
    void disableAndEnableCoursesCB(ArrayList<ICourse> impossibleCourses);
    void addSlotTOschedule(ISlot[] iSlots);
    void removeSlotFromschedule(ISlot[] inokedSlots);
    void changeColumnToDeactiveColor(int coulmn);
    void changeColumnToActiveColor(int coulmn);
    IHour getButtonInvoke();




}