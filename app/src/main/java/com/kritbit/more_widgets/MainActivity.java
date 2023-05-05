package com.kritbit.more_widgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button time_picker, date_picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_picker = findViewById(R.id.pick_time);
        date_picker = findViewById(R.id.pick_date);
        time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Display the time picker
                DialogFragment fragment = new TimePickerFragment();
                fragment.show(getSupportFragmentManager(),"Select your desired time.");
            }
        });

        date_picker.setOnClickListener(view ->{
            DialogFragment fragment = new DatePickerFragment();
            fragment.show(getSupportFragmentManager(),"Pick you pick up date.");
        });
    }
}