package com.example.netef.oshriandnetef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class trying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trying);


        LinearLayout linear = findViewById(R.id.linear);
        LinearLayout days = new LinearLayout(this);

        LinearLayout.LayoutParams tlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        days.setLayoutParams(tlp);

        TextView sunday = new TextView(this);
        TextView monday = new TextView(this);
        TextView tuesday = new TextView(this);
        TextView wednesday = new TextView(this);
        TextView thursday = new TextView(this);
        TextView friday = new TextView(this);
        TextView saturday = new TextView(this);

        ScrollView scroll = findViewById(R.id.scroll);

        TableLayout table = findViewById(R.id.table);

        TableLayout.LayoutParams tbl = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

        sunday.setText("Sun");
        monday.setText("Mon");
        tuesday.setText("Tue");
        wednesday.setText("Wed");
        thursday.setText("Thu");
        friday.setText("Fri");
        saturday.setText("Sat");

        days.addView(sunday);
        days.addView(monday);
        days.addView(tuesday);
        days.addView(wednesday);
        days.addView(thursday);
        days.addView(friday);
        days.addView(saturday);
        days.setGravity(Gravity.CENTER);

        linear.addView(days, 0);



        for (int i = 8; i < 23; i++) {
            TextView hour = new TextView(this);
            hour.setText("" + i);
            hour.setWidth(150);
            hour.setGravity(Gravity.CENTER);
            TableRow row = new TableRow(this);
            row.setLayoutParams(lp);
            row.addView(hour);
            for (int j = 0; j < 6; j++) {
                Button tempBtn = new Button(this);
                tempBtn.setId(View.generateViewId());
                tempBtn.setWidth(10);
                row.addView(tempBtn, lp);
            }
            table.addView(row, tlp);
        }

        table.setShrinkAllColumns(true);

    }

}
