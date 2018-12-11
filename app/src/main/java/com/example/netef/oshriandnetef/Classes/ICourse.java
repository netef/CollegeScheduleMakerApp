package com.example.netef.oshriandnetef.Classes;

import java.util.HashMap;
import java.util.HashSet;

public interface ICourse {

    int getCourseCode();


    String getCourseName();
    HashSet<Integer> getShowCodes();
    HashMap<Integer,IShow> getIShows();

}
