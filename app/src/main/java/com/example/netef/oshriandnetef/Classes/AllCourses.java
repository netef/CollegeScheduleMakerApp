package com.example.netef.oshriandnetef.Classes;

import com.example.netef.oshriandnetef.exceptions.CourseCodeAlreadyExistException;
import com.example.netef.oshriandnetef.exceptions.CourseNameAlreadyExistException;
import com.example.netef.oshriandnetef.exceptions.EndingTimeBeforeStartingTimeException;
import com.example.netef.oshriandnetef.exceptions.RoomFullException;
import com.example.netef.oshriandnetef.exceptions.ShowContaintSlotWithMatchingHoursException;
import com.example.netef.oshriandnetef.exceptions.TeacherTeachingException;
import com.example.netef.oshriandnetef.exceptions.courseNotExistException;

import java.util.HashMap;
import java.util.Map;

public class AllCourses {
    private Map<Integer, Course> mapOfCourses;

    public AllCourses() {
        this.mapOfCourses = new HashMap<>();
    }

    public void addCourse(int courseId, String courseName) throws CourseCodeAlreadyExistException, CourseNameAlreadyExistException, NumberFormatException {
        for (ICourse icourse : mapOfCourses.values()) {
            Course course = (Course) icourse;
            if (course.getCourseCode() == courseId) {
                throw new CourseCodeAlreadyExistException("Id ALREADY EXIST !");
            }
            if (course.getCourseName().equals(courseName)) {
                throw new CourseNameAlreadyExistException("NAME ALREADY EXIST !");
            }
        }
        Course course = new Course(courseId, courseName);
        mapOfCourses.put(courseId, course);

    }

    public Course getCourseById(int courseId) throws courseNotExistException {
        Course wantedCourse = null;
        for (ICourse icourse : mapOfCourses.values()) {
            Course course = (Course) icourse;
            if (course.getCourseCode() == courseId) {
                wantedCourse = course;
            }
        }
        if (wantedCourse == null) {
            throw new courseNotExistException("course Id NOT FOUND");
        }
        return wantedCourse;
    }

    public void addShow(int courseId, int showCode) throws courseNotExistException {
        Show show = new Show(showCode);
        Course wantedCourse = getCourseById(courseId);
        wantedCourse.getShows().put(showCode, show);
    }

    public Map<Integer, Course> getMapOfCourse() {
        return mapOfCourses;
    }

    public void addSlot(int courseId, int numOfShow, int numOfSlot, IDay.Day day, int startingTime, int endingTime, int numberOfRoom, String nameOfLect) throws RoomFullException, TeacherTeachingException, EndingTimeBeforeStartingTimeException, courseNotExistException, ShowContaintSlotWithMatchingHoursException {
        Slot newSlot = new Slot(day, startingTime, endingTime, numberOfRoom, nameOfLect);
        if (ligitSlotByroom(newSlot) == false) {
            throw new RoomFullException("Room full those hours ");
        } else if (ligitSlotByTeacher(newSlot) == false) {
            throw new TeacherTeachingException("Teacher teaching those hours");
        }
        else if(ligitSlotByHourOfothersSlot(newSlot,courseId,numOfShow)== false){
            throw new ShowContaintSlotWithMatchingHoursException("Show contains slots that have matching hours");
        }
        Course wantedCourse = getCourseById(courseId);
        wantedCourse.getShows().get(numOfShow).getSlots().add(newSlot);
    }
    //check if if there are slots in the created show with same hours

    private boolean ligitSlotByHourOfothersSlot(Slot newSlot, int courseCode, int showNumber) {
            for (Slot slotTwo: this.getMapOfCourse().get(courseCode).getShows().get(showNumber).getSlots()) {
                if (!newSlot.equals(slotTwo)&&!newSlot.noMatchingHours(slotTwo)) {
                    return false;
                }
            }
        return true;
    }

    @Override
    public String toString() {
        return "AllCourses [mapOfCorses=" + mapOfCourses + "]";
    }

    public boolean ligitSlotByTeacher(Slot newSlot) {
        for (ICourse icourse : mapOfCourses.values()) {
            Course course = (Course) icourse;
            for (Show shows : course.getShows().values()) {
                for (Slot slot : shows.getSlots()) {
                    if (slot != null && newSlot.matchTeacher(slot) == true && newSlot.noMatchingHours(slot) == false) {//TODO clear null condition
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean ligitSlotByroom(Slot tempSlot) {
        for (ICourse icourse : mapOfCourses.values()) {
            Course course = (Course) icourse;
            //for (Show shows : course.getShows()){
            for (Show shows : course.getShows().values()) {
                for (Slot slot : shows.getSlots()) {
                    if (slot != null && tempSlot.matchRoom(slot) == true && tempSlot.noMatchingHours(slot) == false) {//TODO clear null condition
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void removeShow(int courseCode, int showNumber) {
        mapOfCourses.get(courseCode).getShows().remove(showNumber);
    }
}