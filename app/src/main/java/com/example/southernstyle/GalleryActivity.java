package com.example.southernstyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GalleryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Button a = findViewById(R.id.servicesButton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewServices();
            }
        });

        Button b = findViewById(R.id.homeButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        Button c = findViewById(R.id.contactButton);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewContact();
            }
        });
    }

    private void viewServices() {
        Intent intent = new Intent(getApplicationContext(),
                ServicesActivity.class);
        startActivity(intent);
    }

    private void goHome() {
        Intent intent = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(intent);
    }

    private void viewContact() {
        Intent intent = new Intent(getApplicationContext(),
                ContactActivity.class);
        startActivity(intent);
    }

}
