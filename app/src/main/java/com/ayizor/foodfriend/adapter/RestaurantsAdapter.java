package com.ayizor.foodfriend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayizor.foodfriend.R;
import com.ayizor.foodfriend.models.Restaurant;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder> {
    Context context;
    ArrayList<Restaurant> restaurantList;

    public RestaurantsAdapter(Context context, ArrayList<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantsAdapter.RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new RestaurantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsAdapter.RestaurantsViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.name.setText(restaurant.getName());
        holder.address.setText(restaurant.getAddress());
        Glide.with(holder.image.getContext()).load(restaurant.getImage()).into(holder.image);
        if (restaurant.getRating() == 5) {
            holder.rating.setImageResource(R.drawable.five_star);
        }
        if (restaurant.getRating() == 4.5) {
            holder.rating.setImageResource(R.drawable.four_half_star);
        }
        if (restaurant.getRating() == 4) {
            holder.rating.setImageResource(R.drawable.four_star);
        }
        if (restaurant.getRating() == 3.5) {
            holder.rating.setImageResource(R.drawable.three_half_star);
        }
        if (restaurant.getRating() == 3) {
            holder.rating.setImageResource(R.drawable.three_star);
        }
        if (restaurant.getRating() == 2.5) {
            holder.rating.setImageResource(R.drawable.two_half_star);
        }
        if (restaurant.getRating() == 2 || restaurant.getRating() < 2) {
            holder.rating.setImageResource(R.drawable.two_star);
        }
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantsViewHolder extends RecyclerView.ViewHolder {
        ImageView rating, image;
        TextView name, address;

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.iv_restaurant_rating);
            image = itemView.findViewById(R.id.iv_restaurant_image);
            name = itemView.findViewById(R.id.tv_restaurant_name);
            address = itemView.findViewById(R.id.tv_restaurant_address);
        }
    }
}
