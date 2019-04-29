package com.example.southernstyle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


public class ContactActivity extends Activity {

    //private TextView contactTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getFB();
    }

    private void getFB() {
        Uri uri = Uri.parse("https://www.facebook.com/Southern-Style-478556552220661/?epa=SEARCH_BOX");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
