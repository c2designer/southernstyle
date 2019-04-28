package com.example.southernstyle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class CreateAppointment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment);


        Toast.makeText(getApplicationContext(), "Creating Appointment", Toast.LENGTH_SHORT).show();
    }



}
