package com.example.calender_ex;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class Schedule_Memo extends AppCompatActivity {
    EditText dateEditText;
    CheckBox AlarmCheckBox;
    TextView timeTextView, selectedTimeText;
    ImageButton selectTimeButton;
    int alarmHour = 0, alarmMinute = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        dateEditText = (EditText) findViewById(R.id.dateEditText);
        AlarmCheckBox = (CheckBox) findViewById(R.id.AlarmCheckBox);
        selectedTimeText = (TextView) findViewById(R.id.selectedTimeText);
        timeTextView = (TextView) findViewById(R.id.timeTextView);
        selectTimeButton = (ImageButton) findViewById(R.id.selectTimeButton);


        String date = getIntent().getStringExtra("date");
        dateEditText.setText(" "+ date);

        AlarmCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeTextView.setVisibility(View.VISIBLE);
                selectedTimeText.setVisibility(View.VISIBLE);
                selectTimeButton.setVisibility(View.VISIBLE);
            }
        });

        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Schedule_Memo.this, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        selectedTimeText.setText(String.format("  %d시 %d분",hour, minute));
                    }
                },alarmHour, alarmMinute, false);
                timePickerDialog.show();
            }
        });


    }
}