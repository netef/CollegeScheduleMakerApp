//package com.example.netef.oshriandnetef;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//
//import com.example.netef.oshriandnetef.Classes.IDay;
//import com.example.netef.oshriandnetef.Classes.ScheduleButton;
//
//public class Schedule2 extends AppCompatActivity {
//    private static final int[] BUTTON_IDS = {
//            R.id.button81, R.id.button82, R.id.button83, R.id.button84, R.id.button85, R.id.button86,
//            R.id.button91, R.id.button92, R.id.button93, R.id.button94, R.id.button95, R.id.button96,
//            R.id.button101, R.id.button102, R.id.button103, R.id.button104, R.id.button105, R.id.button106,
//            R.id.button111, R.id.button112, R.id.button113, R.id.button114, R.id.button115, R.id.button116,
//            R.id.button121, R.id.button122, R.id.button123, R.id.button124, R.id.button125, R.id.button126,
//            R.id.button131, R.id.button132, R.id.button133, R.id.button134, R.id.button135, R.id.button136,
//            R.id.button141, R.id.button142, R.id.button143, R.id.button144, R.id.button145, R.id.button146,
//            R.id.button151, R.id.button152, R.id.button153, R.id.button154, R.id.button155, R.id.button156,
//            R.id.button161, R.id.button162, R.id.button163, R.id.button164, R.id.button165, R.id.button166,
//            R.id.button171, R.id.button172, R.id.button173, R.id.button174, R.id.button175, R.id.button176,
//            R.id.button181, R.id.button182, R.id.button183, R.id.button184, R.id.button185, R.id.button186,
//            R.id.button191, R.id.button192, R.id.button193, R.id.button194, R.id.button195, R.id.button196,
//            R.id.button201, R.id.button202, R.id.button203, R.id.button204, R.id.button205, R.id.button206,
//            R.id.button211, R.id.button212, R.id.button213, R.id.button214, R.id.button215, R.id.button216,
//            R.id.button221, R.id.button222, R.id.button223, R.id.button224, R.id.button225, R.id.button226,
//    };
//    public static final int INITIAL_HOUR_OF_SCHEDULE = 8;
//    public static final int LAST_HOUR_OF_SCHEDULE = 23;
//    private ScheduleButton[][] scheduleButtons;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_schedule2);
//
//        scheduleButtons = new ScheduleButton[6][LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE];
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < LAST_HOUR_OF_SCHEDULE - INITIAL_HOUR_OF_SCHEDULE; j++) {
//                ScheduleButton tempButton = new ScheduleButton(IDay.dayByInt(i + 1), j + INITIAL_HOUR_OF_SCHEDULE, findViewById(BUTTON_IDS[i + (j * 6)]));
//                tempButton.getButton().setOnClickListener(e -> scheduleButtonsUnAvctive(tempButton)); // mamesh me!
//                tempButton.setFlag(true);
//
//                scheduleButtons[i][j] = tempButton;
//            }
//        }
//    }
//
//}
