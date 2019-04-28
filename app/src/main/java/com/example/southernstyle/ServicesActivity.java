package com.example.southernstyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Button a = findViewById(R.id.homeButton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
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
    }

    private void goHome() {
        Intent intent = new Intent(getApplicationContext(),
                MainActivity.class);
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

}
