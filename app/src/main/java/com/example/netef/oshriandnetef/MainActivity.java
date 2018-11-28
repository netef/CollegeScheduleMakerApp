package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.netef.oshriandnetef.Classes.Controller;
import com.example.netef.oshriandnetef.Classes.Model;

public class MainActivity extends AppCompatActivity {

    public static Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Model model = new Model();
        controller = new Controller(model);
        controller.addViewer(this);

        Button createBtn = findViewById(R.id.createBtn);

        createBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CreateNewCourse.class);
            startActivity(intent);
        });
    }
}
