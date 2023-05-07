package com.kritbit.more_widgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button time_picker, date_picker, save;
    Spinner spinner;
    ProgressBar pg_bar;
    String[] payment_methods = {"M-PESA", "KRTPAY", "VISA", "MASTERCARD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_picker = findViewById(R.id.pick_time);
        date_picker = findViewById(R.id.pick_date);
        spinner = findViewById(R.id.paymentmethod);
        pg_bar = findViewById(R.id.progressBar);
        save = findViewById(R.id.save);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                payment_methods);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        pg_bar.setProgress(12);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Selected payment method: "+payment_methods[i],
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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

        save.setOnClickListener(view->{
            pg_bar.incrementProgressBy(5);
        });
    }
}