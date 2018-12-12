package com.example.netef.oshriandnetef.Classes;


import java.util.ArrayList;

public interface IView {

    //MainActivity
    void createNewCoursePane();
    void scheduleMakerPane();
    //CreateNewCourse
    void createNewSlotPane();
    void courseCodeException();
    void courseCodeNotAnIntegerException();

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
    void slotMatchingHoursException(int ivokingSlotNumber);
    //4

    void disableCoursesCBByHour(ArrayList<ICourse> impossibleCourses);//done
    void ableCoursesCBByHour(ArrayList<ICourse> impossibleCourses);//done
    void disableAndEnableCoursesCB(ArrayList<ICourse> impossibleCourses);//done
    void setCourses(ICourse[] allCoursesForViewer);//done
    IHour getButtonInvoke();//done
    void addSlotTOschedule(ISlot[] iSlots);//done
    void removeSlotFromschedule(ISlot[] inokedSlots);//done
    void deactiveCollorButton(ScheduleButton button);//done

    //DAY METHODS
    int getInvokingDayNumber();
    CourseCheckBox getInvokingCourseCheckboxes();//done
    void disableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber);
    void ableCoursesCBByDay(ArrayList<ICourse> impossibleCourses, int invokingDayNumber);
    void changeColumnToDeactiveColor(int coulmn);
    void changeColumnToActiveColor(int coulmn);






}