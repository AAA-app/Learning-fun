package com.aaa.homeworktojava.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.adapter.RvAdapter;
import com.aaa.homeworktojava.data.DataClass;


public class FragmentTwo extends Fragment {
    public Context context;
    RecyclerView recyclerView;


    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.rv_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        DataClass[] dataClass= new DataClass[] {
//                new DataClass("Vernon", R.drawable.car1),
//                new DataClass("Jeep",  R.drawable.car2),
//                new DataClass("Porsche", R.drawable.car3),
//                new DataClass("Ford", R.drawable.car4),
//                new DataClass("Lamborghini", R.drawable.car5),
//                new DataClass("jeep", R.drawable.car6),
//                new DataClass("Vernon", R.drawable.car1),
//                new DataClass("Jeep",  R.drawable.car2),
//                new DataClass("Porsche", R.drawable.car3),
//                new DataClass("Ford", R.drawable.car4),
//                new DataClass("Lamborghini", R.drawable.car5),
//                new DataClass("jeep", R.drawable.car6),
//                new DataClass("Ford", R.drawable.car7)
//        };
//
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//                mAdapter = new RvAdapter(context, listData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//                recyclerView.setAdapter(mAdapter);
    }

}
