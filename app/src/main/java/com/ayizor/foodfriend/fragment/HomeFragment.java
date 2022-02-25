package com.ayizor.foodfriend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ayizor.foodfriend.R;
import com.ayizor.foodfriend.adapter.CategotyAdapter;
import com.ayizor.foodfriend.adapter.RestaurantsAdapter;
import com.ayizor.foodfriend.models.Category;
import com.ayizor.foodfriend.models.Restaurant;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView categoryRecycler, mainRecycler;
    private CategotyAdapter categotyAdapter;
    private RestaurantsAdapter restaurantsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);
        inits(view);
        return view;
    }

    private void inits(View view) {
        categoryRecycler = view.findViewById(R.id.home_category_recycler);
        mainRecycler = view.findViewById(R.id.home_recycler_view);
        mainRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        refreshAdapters(categoryList(), mainList());
    }

    private void refreshAdapters(ArrayList<Category> categoryList, ArrayList<Restaurant> mainList) {
        restaurantsAdapter = new RestaurantsAdapter(getContext(), mainList);
        categotyAdapter = new CategotyAdapter(getContext(), categoryList);
        mainRecycler.setAdapter(restaurantsAdapter);
        categoryRecycler.setAdapter(categotyAdapter);
    }

    private ArrayList<Restaurant> mainList() {
        ArrayList<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant("Noma", "Copenhagen, Denmark", 3.5, R.drawable.restaurant));
        list.add(new Restaurant("Asador Etxebarri", "Copenhagen, Denmark", 5, R.drawable.restaurant));
        list.add(new Restaurant("Central", "Atxondo, Spain", 4.5, R.drawable.restaurant));
        list.add(new Restaurant("Disfrutar", "Lima, Peru", 3, R.drawable.restaurant));
        list.add(new Restaurant("Frantzén", "Stockholm, Sweden", 4, R.drawable.restaurant));
        list.add(new Restaurant("Maido", "Lima, Peru", 2.5, R.drawable.restaurant));
        list.add(new Restaurant("Odette", "Singapore", 2, R.drawable.restaurant));
        list.add(new Restaurant("Pujol", "Mexico City, Mexico", 3, R.drawable.restaurant));
        list.add(new Restaurant("The Chairman", "Hong Kong, China", 2.5, R.drawable.restaurant));

        return list;
    }

    private ArrayList<Category> categoryList() {
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.restaurant, "Restaurants"));
        list.add(new Category(R.drawable.restaurant, "Shops"));
        list.add(new Category(R.drawable.restaurant, "Coffee shops"));
        list.add(new Category(R.drawable.restaurant, "Hotels"));
        list.add(new Category(R.drawable.restaurant, "Jobs"));
        return list;
    }
}
