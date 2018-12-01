package com.example.netef.oshriandnetef.Classes;


import java.util.ArrayList;

public interface IView {

    //MainActivity
    void createNewCoursePane();
    void scheduleMakerPane(ICourse[] coursesName);
    //CreateNewCourse
    void createNewSlotPane();
    void courseCodeException();
    void courseNameException();
    String[] getCourseInput();
    String[] getShowInput();
    //2-3 viewers
    int getNumberOfSlots();
    //CreateSlots
    void createNewShowPane(int courseCode,String courseName);
    void courseMenuPane();
    String[][] getSlotsInput();
    void slotTimingException(int slotNumber);
    void roomFullException(int slotNumber);
    void teacherTeachingException(int slotNumber);
    void roomInputIsntAint(int slotNumber);

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