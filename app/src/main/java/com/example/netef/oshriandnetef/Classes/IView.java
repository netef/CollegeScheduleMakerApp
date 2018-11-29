package com.example.netef.oshriandnetef.Classes;


import java.util.ArrayList;

public interface IView {
    //globalmethods
    int getCreatingCourseCode();
    //MainActivity
    void createNewCoursePane();
    void scheduleMakerPane(ICourse[] coursesName);
    //2
    void createNewSlotPane(int amountOfSlots);
    void courseCodeException();
    void courseNameException();

    String[] getCourseInput();
    String[] getShowInput();
    //3
    Node createNewShowPane(int courseCode);
    Node courseMenuPane();
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