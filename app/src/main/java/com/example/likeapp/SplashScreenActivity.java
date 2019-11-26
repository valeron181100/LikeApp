package com.example.likeapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.likeapp.models.SwipeRightViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SwipeRightViewModel.getInstance();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
