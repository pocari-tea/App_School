package com.example.a09;

import android.icu.util.Calendar;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Calendar cal;
    Chronometer cm;
    Button startBtn, setBtn;
    CheckBox calBox, timeBox;
    TimePicker tp;
    DatePicker dp;
    TextView tv;
    static boolean tpOk = false, dpOk = false;
    int selectYear, selectMonth, selectDay, selectHour, selectMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = Calendar.getInstance();

        selectYear = cal.get(cal.YEAR);
        selectMonth = cal.get(cal.MONTH) + 1;
        selectDay = cal.get(cal.DATE);
        selectHour = cal.get(cal.HOUR_OF_DAY);
        selectMinute = cal.get(cal.MINUTE);

        cm = (Chronometer)findViewById(R.id.counting);
        startBtn = (Button)findViewById(R.id.startBtn);
        calBox = (CheckBox)findViewById(R.id.calBox);
        timeBox = (CheckBox)findViewById(R.id.timeBox);
        tp = (TimePicker)findViewById(R.id.timeP);
        dp = (DatePicker)findViewById(R.id.dateP);
        setBtn = (Button)findViewById(R.id.setBtn);
        tv = (TextView)findViewById(R.id.resultTextView);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calBox.setVisibility(View.VISIBLE);
                timeBox.setVisibility(View.VISIBLE);
                cm.setBase(SystemClock.elapsedRealtime());
                cm.start();
            }
        });

        calBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(calBox.isChecked()) {
                    dpOk = true;
                    timeBox.setChecked(false);
                    tp.setVisibility(View.INVISIBLE);
                    dp.setVisibility(View.VISIBLE);
                }
                if(tpOk && dpOk)
                    setBtn.setEnabled(true);
            }
        });

        timeBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(timeBox.isChecked()) {
                    tpOk = true;
                    calBox.setChecked(false);
                    dp.setVisibility(View.INVISIBLE);
                    tp.setVisibility(View.VISIBLE);
                }
                if(tpOk && dpOk)
                    setBtn.setEnabled(true);
            }
        });

        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                selectYear = dp.getYear();
                selectMonth = dp.getMonth() + 1;
                selectDay = dp.getDayOfMonth();
            }
        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                selectHour = tp.getHour();
                selectMinute = tp.getMinute();
            }
        });

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBtn.setEnabled(false);
                calBox.setEnabled(false);
                timeBox.setEnabled(false);
                cm.stop();
                tv.setText(Integer.toString(selectYear) + "년 " +
                        Integer.toString(selectMonth) + "월 " +
                        Integer.toString(selectDay) + "일, " +
                        Integer.toString(selectHour) + "시 " +
                        Integer.toString(selectMinute) + "분 예약 완료 ;D");
            }
        });
    }
}