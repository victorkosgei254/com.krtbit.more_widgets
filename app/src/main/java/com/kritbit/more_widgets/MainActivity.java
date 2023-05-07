package com.kritbit.more_widgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button time_picker, date_picker;
    Spinner spinner;
    
    String[] payment_methods = {"M-PESA", "KRTPAY", "VISA", "MASTERCARD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_picker = findViewById(R.id.pick_time);
        date_picker = findViewById(R.id.pick_date);
        spinner = findViewById(R.id.paymentmethod);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                payment_methods);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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