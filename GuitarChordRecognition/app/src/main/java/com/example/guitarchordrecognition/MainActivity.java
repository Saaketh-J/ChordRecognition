package com.example.guitarchordrecognition;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button welcome;
        welcome = (Button) findViewById(R.id.welcomeButton);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.record);
            }
        });

        ImageButton record;
        record = (ImageButton) findViewById(R.id.recordButton);

        record.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.record);
            }
        });

        MyCanvas myCanvas;
        myCanvas = findViewById(R.id.display);

        myCanvas.setBackgroundColor(0);
    }
}
