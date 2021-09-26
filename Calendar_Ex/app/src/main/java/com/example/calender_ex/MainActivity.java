package com.example.calender_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView dateTextView, scheduleTitleText;
    Button memoButton;
    Calendar calendar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateTextView = (TextView)  findViewById(R.id.dateTextView);
        scheduleTitleText = (TextView) findViewById(R.id.scheduleTitle);
        memoButton = (Button) findViewById(R.id.memoButton);

        calendar = Calendar.getInstance();
        dateTextView.setText(calendar.get(Calendar.YEAR) +"년 " + (calendar.get(Calendar.MONTH)+1) + "월 " + calendar.get(Calendar.DATE) + "일");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                dateTextView.setText( String.format("%d년 %d월 %d일",year,month+1,dayOfMonth));
            }
        });

        memoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Schedule_Memo.class);
                intent.putExtra("date",dateTextView.getText().toString());
                startActivity(intent);
            }
        });
    }
}