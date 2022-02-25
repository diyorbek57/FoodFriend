package com.ayizor.foodfriend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ayizor.foodfriend.R;
import com.ayizor.foodfriend.adapter.CategotyAdapter;
import com.ayizor.foodfriend.adapter.CollectionsAdapter;
import com.ayizor.foodfriend.models.Category;

import java.util.ArrayList;

public class CollectionsFragment extends Fragment {

    private RecyclerView recycler;
    private CollectionsAdapter categotyAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collections_layout, container, false);
        inits(view);
        return view;
    }

    private void inits(View view) {
        recycler = view.findViewById(R.id.home_category_recycler);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 1));
        refreshAdapters(categoryList());
    }

    private void refreshAdapters(ArrayList<Category> categoryList) {
        categotyAdapter = new CollectionsAdapter(getContext(), categoryList);
        recycler.setAdapter(categotyAdapter);
    }
    private ArrayList<Category> categoryList() {
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.restaurant, "Restaurants"));
        list.add(new Category(R.drawable.car, "Car"));
        list.add(new Category(R.drawable.job, "Job"));
        list.add(new Category(R.drawable.phone, "Phone"));
        list.add(new Category(R.drawable.notebook, "Notebook"));
        list.add(new Category(R.drawable.hotel, "Hotel"));
        return list;
    }
}
