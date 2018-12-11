package com.example.netef.oshriandnetef.Classes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Show implements  IShow{

    @Override
    public String toString() {
        return "Show [showCode=" + showCode + ", slots=" + slots + "]";
    }

    private int showCode;
    private ArrayList<Slot> slots;

    public Show(int showCode) {
        this.showCode = showCode;
        this.slots = new ArrayList<Slot>();
    }


    public ArrayList<Slot> getSlots() {
        return slots;
    }


    public int getShowCode() {
        return showCode;
    }

    public int getNumberOfSlots() {
        // TODO Auto-generated method stub
        return slots.size();
    }


    @Override
    public HashMap<IDay.Day, HashSet<String>> getDaysAndLecturerName() {
        HashMap<IDay.Day, HashSet<String>> map=new HashMap<>();
        for (Slot slot:slots){
         if(map.containsKey(slot.getDay())){
             map.get(slot.getDay()).add(slot.getTeacher().toString());
         }
        else{
             HashSet<String> set=new HashSet<>();
             set.add(slot.getTeacher().toString());
             map.put(slot.getDay(),set);
         }
        }
        return map;

    }
}
