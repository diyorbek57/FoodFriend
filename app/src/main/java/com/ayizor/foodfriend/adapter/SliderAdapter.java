package com.ayizor.foodfriend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.ayizor.foodfriend.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int[] images = {R.drawable.ic_restaurant,
            R.drawable.ic_like, R.drawable.ic_chat, R.drawable.ic_notification
    };
    int[] headings = {
            R.string.best_restaurants, R.string.saved_listings, R.string.chat, R.string.get_nitified
    };
    int[] descriptions = {
            R.string.best_restaurants_desc, R.string.saved_listings_desc, R.string.chat_desc, R.string.get_nitified_desc

    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container, false);

        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView headerText = view.findViewById(R.id.slider_heading);
        TextView descText = view.findViewById(R.id.slider_desc);

        imageView.setImageResource(images[position]);
        headerText.setText(headings[position]);
        descText.setText(descriptions[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}

