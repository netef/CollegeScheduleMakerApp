package com.example.netef.oshriandnetef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Collections;

public class CreateNewCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_course);

        int dropBoxItems[] = new int[5];
        EditText courseID = findViewById(R.id.courseID);
        EditText courseName = findViewById(R.id.courseName);
        Button confirmbtn = findViewById(R.id.confirmBtn);
        Spinner dropBox = findViewById(R.id.dropBox);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Collections.singletonList(dropBoxItems));
        dropBox.setAdapter(arrayAdapter);




    }
}
