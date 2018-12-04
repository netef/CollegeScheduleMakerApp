package com.example.netef.oshriandnetef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class WeekViewAPI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view_api);
        MaterialCalendarView calendarView =findViewById(R.id.calendarView);

    }
}
