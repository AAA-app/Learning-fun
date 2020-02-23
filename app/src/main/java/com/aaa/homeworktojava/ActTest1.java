package com.aaa.homeworktojava;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tomer.fadingtextview.FadingTextView;

public class ActTest1 extends AppCompatActivity {
    private FadingTextView fadingTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        fadingTextView = findViewById(R.id.fading_text_view);
    }


}
