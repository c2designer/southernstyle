package com.example.southernstyle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button a = findViewById(R.id.servicesButton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewServices();
            }
        });

        Button b = findViewById(R.id.galleryButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewGallery();
            }
        });

        Button c = findViewById(R.id.contactButton);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewContact();
            }
        });

        Button d = findViewById(R.id.createAppointment);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAppointment();
            }
        });
    }

    private void viewServices() {
        Intent intent = new Intent(getApplicationContext(),
                ServicesActivity.class);
        startActivity(intent);
    }

    private void viewGallery() {
        Intent intent = new Intent(getApplicationContext(),
                GalleryActivity.class);
        startActivity(intent);
    }

    private void viewContact() {
        Intent intent = new Intent(getApplicationContext(),
                ContactActivity.class);
        startActivity(intent);
    }

    private void createAppointment() {
        Intent intent = new Intent(getApplicationContext(),
                CreateAppointment.class);
        startActivity(intent);
    }
}
