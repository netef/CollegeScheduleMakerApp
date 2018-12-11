package com.example.netef.oshriandnetef.Classes;

public class Teacher {
    private String name;
    //private int assigned; dont know why

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}