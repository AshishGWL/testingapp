package com.helloapp.testingapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private int mDay, mMonth, mYear;
    private TextView mDateTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();

        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mMonth = calendar.get(Calendar.MONTH);
        mYear = calendar.get(Calendar.YEAR);

        mDateTv = (TextView) findViewById(R.id.txt_date);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
        updateDate();

    }

    private void updateDate(){
        String date = "Date: " + mDay + "/" + (mMonth + 1) + "/" + mYear;
        mDateTv.setText(date);
    }

    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        mDay = datePicker.getDayOfMonth();
        mMonth = datePicker.getMonth();
        mYear = datePicker.getYear();
        updateDate();
    }
}
