package com.example.guitarchordrecognition;

import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaRecorder myAudioRecorder;
    ImageButton record;
    boolean recordPressed = false;
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

        MyCanvas myCanvas;
        myCanvas = findViewById(R.id.display);
        myCanvas.setBackgroundColor(0);


        String outputFile;
        outputFile = getExternalCacheDir().getAbsolutePath()+"/recording.3gp";

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);


        record = (ImageButton) findViewById(R.id.recordButton);


        record.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                recordPressed = true;
                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                } catch (IllegalStateException ise) {
                    // make something ...
                } catch (IOException ioe) {
                    // make something
                }
                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        if(recordPressed) {
            record.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    recordPressed = false;
                    myAudioRecorder.stop();
                    myAudioRecorder.release();
                    myAudioRecorder = null;
                    Toast.makeText(getApplicationContext(), "Audio Recorder successfully", Toast.LENGTH_LONG).show();
                }
            });
        }
/*
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(outputFile);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        Toast.makeText(getApplicationContext(), "Playing Audio", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        // make something
                    }
                }
            });
            }
  */
    }
}

