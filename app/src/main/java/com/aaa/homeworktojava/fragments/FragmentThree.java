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
import com.aaa.homeworktojava.adapter.GirlsAdapter;
import com.aaa.homeworktojava.data.CarData;
import com.aaa.homeworktojava.data.GirlsData;


public class FragmentThree extends Fragment {

    public Context context;


    public FragmentThree() {
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
        GirlsData[] girlsData= new GirlsData[]{
                new GirlsData("Anna", R.drawable.girls1),
                new GirlsData("Yulia",  R.drawable.girls2),
                new GirlsData("Tami", R.drawable.girls3),
                new GirlsData("Vika", R.drawable.girls4),
                new GirlsData("Yana", R.drawable.girls5),
                new GirlsData("Jenny", R.drawable.girls6),
                new GirlsData("Lena", R.drawable.girls7),
                new GirlsData("Anna", R.drawable.girls1),
                new GirlsData("Yulia",  R.drawable.girls2),
                new GirlsData("Tami", R.drawable.girls3),
                new GirlsData("Vika", R.drawable.girls4),
                new GirlsData("Yana", R.drawable.girls5),
                new GirlsData("Jenny", R.drawable.girls6),
                new GirlsData("Lena", R.drawable.girls7)

        };

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GirlsAdapter adapter = new GirlsAdapter(girlsData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

}
