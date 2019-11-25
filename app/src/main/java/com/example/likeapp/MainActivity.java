package com.example.likeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.likeapp.models.SwipeRightViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout mFragmentContainer;
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentContainer = findViewById(R.id.fragmentContainer);
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);


        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.fragmentContainer, new CardFragment()).commit();

        mBottomNavigationView.setOnNavigationItemSelectedListener(navItemSelListener);


    }

    BottomNavigationView.OnNavigationItemSelectedListener navItemSelListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
            Log.d(LogTags.BOTTOM_NAV_BAR, menuItem.getTitle() + " bottom nav item was selected!");
            return true;
        }
    };
}
