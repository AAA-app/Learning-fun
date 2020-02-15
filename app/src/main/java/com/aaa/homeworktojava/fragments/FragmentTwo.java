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
import com.aaa.homeworktojava.adapter.CarAdapter;
import com.aaa.homeworktojava.data.CarData;


public class FragmentTwo extends Fragment {
    public Context context;


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
        CarData[] carData= new CarData[] {
                new CarData("Vernon", R.drawable.car1),
                new CarData("Jeep",  R.drawable.car2),
                new CarData("Porsche", R.drawable.car3),
                new CarData("Ford", R.drawable.car4),
                new CarData("Lamborghini", R.drawable.car5),
                new CarData("jeep", R.drawable.car6),
                new CarData("Vernon", R.drawable.car1),
                new CarData("Jeep",  R.drawable.car2),
                new CarData("Porsche", R.drawable.car3),
                new CarData("Ford", R.drawable.car4),
                new CarData("Lamborghini", R.drawable.car5),
                new CarData("jeep", R.drawable.car6),
                new CarData("Ford", R.drawable.car7)
        };

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        CarAdapter adapter = new CarAdapter(carData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

    }

}
