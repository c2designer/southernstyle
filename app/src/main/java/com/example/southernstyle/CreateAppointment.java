package com.example.southernstyle;

import android.app.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateAppointment extends Activity {

    CalendarView calendarView;
    long selectedAppointment = 0;
    DatabaseReference databaseAppointments;
    DatabaseReference databaseAvailableTimes;
    Spinner spinner;
    List<String> times = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment);

        databaseAppointments = FirebaseDatabase.getInstance().getReference("appointments");
        databaseAvailableTimes = FirebaseDatabase.getInstance().getReference("avail_times");
        calendarView = findViewById(R.id.calendarView);
        spinner = findViewById(R.id.spinner);


        times.add("Please select a date above first");



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "hello", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), spinner.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(CreateAppointment.this, android.R.layout.simple_spinner_item, times);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

        findViewById(R.id.button_submit_appointment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAppointment();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //selectedAppointment = calendarView.getDate();
                Calendar c = Calendar.getInstance();
                c.set(year, month, dayOfMonth);
                selectedAppointment =  c.getTimeInMillis();
                if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    Toast.makeText(getApplicationContext(), "Sunday appointments are unavailable; Try again!", Toast.LENGTH_LONG).show();
                    selectedAppointment = 0;
                }

                times.clear();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String selectedDate = sdf.format(new Date(selectedAppointment));

                databaseAvailableTimes.child(selectedDate).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot availSnapshot : dataSnapshot.getChildren()){
                            if(availSnapshot.getValue(Boolean.class) == true){ //see if time is available and add to list if yes.
                                times.add(availSnapshot.getKey());
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




            }
        });


        //Toast.makeText(getApplicationContext(), "Creating Appointment", Toast.LENGTH_SHORT).show();
    }

    private void submitAppointment(){
        Appointment appointment;

        EditText name = findViewById(R.id.name_editText);
        EditText email = findViewById(R.id.email_editText);
        EditText phone = findViewById(R.id.contact_editText);
        Spinner time = findViewById(R.id.spinner);


        if(TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(phone.getText().toString()) || TextUtils.isEmpty(time.getSelectedItem().toString()) || selectedAppointment == 0){
            Toast.makeText(this, "All fields are required; Appointment not booked; try again!", Toast.LENGTH_LONG).show();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String selectedDate = sdf.format(new Date(selectedAppointment));

            String id = databaseAppointments.push().getKey();
            appointment = new Appointment(id, name.getText().toString(), email.getText().toString(), phone.getText().toString(), selectedDate, time.getSelectedItem().toString());
            databaseAppointments.child(id).setValue(appointment);
            Toast.makeText(this, "Appointment has been successfully booked. See you soon!", Toast.LENGTH_LONG).show();
        }
    }



}
