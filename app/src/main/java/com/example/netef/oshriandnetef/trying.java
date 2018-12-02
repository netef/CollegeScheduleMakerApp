package com.example.netef.oshriandnetef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

public class trying extends AppCompatActivity {

    public static String days[] = {"Sunday", "Monday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    public static Integer hour[] = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trying);

        //Get number of slots
        Bundle bundle=getIntent().getExtras();

        //make Slots!
        makeSlots(bundle.getInt("amountOfSlots"));
    }


    public void makeSlots(int slots) {

        //Assigning big layout
        LinearLayout linearLayout = findViewById(R.id.myLinear);

        //Params declaration
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        //Title and prefs
        TextView title = new TextView(this);
        title.setText("Create New Slots");
        title.setTextSize(30);
        title.setGravity(Gravity.CENTER);
        linearLayout.addView(title);

        //The slots
        for (int i = 0; i < slots; i++) {

            //Layout declaration
            LinearLayout spinners = new LinearLayout(this);
            LinearLayout editTexts = new LinearLayout(this);

            //Centering everything
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

            //Spinner assignment
            Spinner day = new Spinner(this);
            Spinner startHour = new Spinner(this);
            Spinner endHour = new Spinner(this);

            //EditText assignment
            EditText roomNumber = new EditText(this);
            EditText lecturerName = new EditText(this);

            //Spinner layout prefs
            spinners.setId(View.generateViewId());
            spinners.setOrientation(LinearLayout.HORIZONTAL);

            //Edit text layout prefs
            editTexts.setId(View.generateViewId());
            editTexts.setOrientation(LinearLayout.HORIZONTAL);

            //ArrayAdapters
            ArrayAdapter dayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, days);
            ArrayAdapter hourAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, hour);

            //Assigning values to spinners
            day.setAdapter(dayAdapter);
            startHour.setAdapter(hourAdapter);
            endHour.setAdapter(hourAdapter);


            //Assigning hints
            roomNumber.setHint("Room Number");
            lecturerName.setHint("Lecturer Name");

            //Adding GUI elements
            spinners.addView(day, layoutParams);
            spinners.addView(startHour, layoutParams);
            spinners.addView(endHour, layoutParams);
            editTexts.addView(roomNumber, layoutParams);
            editTexts.addView(lecturerName, layoutParams);

            //Adding everything to the big layout
            linearLayout.addView(spinners, layoutParams);
            linearLayout.addView(editTexts, layoutParams);
        }

        //Confirm button declaration and adding to Big Layout
        Button confirmBtn = new Button(this);
        confirmBtn.setId(View.generateViewId());
        confirmBtn.setText("Confirm");
        confirmBtn.setTextSize(20);
        linearLayout.addView(confirmBtn, layoutParams);

        confirmBtn.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(), Schedule.class);
                startActivity(intent);
        });
    }
}
