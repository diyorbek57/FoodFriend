package com.ayizor.foodfriend.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ayizor.foodfriend.R;
import com.ayizor.foodfriend.fragment.ChatFragment;
import com.ayizor.foodfriend.fragment.CollectionsFragment;
import com.ayizor.foodfriend.fragment.HomeFragment;
import com.ayizor.foodfriend.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frFragment, new HomeFragment()).commit();
        }
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.fragment_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.fragment_collections:
                        fragment = new CollectionsFragment();
                        break;
                    case R.id.fragment_chat:
                        fragment = new ChatFragment();
                        break;
                    case R.id.fragment_search:
                        fragment = new SearchFragment();
                        break;
                }
                assert fragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.frFragment, fragment).commit();
                return true;
            };
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click BACK again", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}