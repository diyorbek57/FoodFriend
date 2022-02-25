package com.ayizor.foodfriend.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ayizor.foodfriend.R;
import com.ayizor.foodfriend.adapter.SliderAdapter;

public class OnBoarding extends AppCompatActivity {

    //Variables
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button next, skip;
    Animation animation;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);
        onlyOnce();
        inits();

    }

    private void inits() {
        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        next = findViewById(R.id.next_btn);
        skip = findViewById(R.id.skip_btn);
        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(view);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skip(view);
            }
        });
    }

    public void skip(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
        if (next.getText().toString().contains("Done")) {
            SharedPreferences sharedpreferences = getSharedPreferences("ONLYONCE", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("ONLYONCE", true);
        }
    }

    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.main));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;
            if (position == 0) {
                next.setText(R.string.next);
                skip.setVisibility(View.VISIBLE);
            } else if (position == 1) {
                next.setText(R.string.next);
                skip.setVisibility(View.VISIBLE);
            } else if (position == 2) {
                next.setText(R.string.next);
                skip.setVisibility(View.VISIBLE);
            } else {
                next.setText(R.string.done);
                skip.setVisibility(View.INVISIBLE);
            }


//                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
//                letsGetStarted.setAnimation(animation);


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void onlyOnce() {
        SharedPreferences sharedpreferences = getSharedPreferences("ONLYONCE", Context.MODE_PRIVATE);
        Boolean onlyonce = sharedpreferences.getBoolean("ONLYONCE", true);

        if (onlyonce) {
            Intent intent = new Intent(OnBoarding.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}