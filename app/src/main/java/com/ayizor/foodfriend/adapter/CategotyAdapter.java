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
import com.ayizor.foodfriend.models.Category;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategotyAdapter extends RecyclerView.Adapter<CategotyAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<Category> categoriesList;

    public CategotyAdapter(Context context, ArrayList<Category> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategotyAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategotyAdapter.CategoryViewHolder holder, int position) {
        Category category = categoriesList.get(position);
        Glide.with(holder.image.getContext()).load(category.getImage()).into(holder.image);
        holder.name.setText(category.getName());

    }


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_category_image);
            name = itemView.findViewById(R.id.tv_category_name);

        }
    }
}
