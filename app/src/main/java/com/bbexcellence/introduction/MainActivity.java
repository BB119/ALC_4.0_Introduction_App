package com.bbexcellence.introduction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Displaying the alc web view screen when the "about ALC" button is clicked
        Button alcButton = findViewById(R.id.about_alc);
        alcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), AboutAlcActivity.class));
            }
        });

        // Displaying the information screen when the "about me" button is clicked
        Button aboutMeButton = findViewById(R.id.about_me);
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), AboutMeActivity.class));
            }
        });
    }
}
