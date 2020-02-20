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


public class FragmentThree extends Fragment {

    public Context context;
     RecyclerView recyclerView;


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
//        DataClass[] dataClass= new DataClass[]{
//                new DataClass("Anna", R.drawable.girls1),
//                new DataClass("Yulia",  R.drawable.girls2),
//                new DataClass("Tami", R.drawable.girls3),
//                new DataClass("Vika", R.drawable.girls4),
//                new DataClass("Yana", R.drawable.girls5),
//                new DataClass("Jenny", R.drawable.girls6),
//                new DataClass("Lena", R.drawable.girls7),
//                new DataClass("Anna", R.drawable.girls1),
//                new DataClass("Yulia",  R.drawable.girls2),
//                new DataClass("Tami", R.drawable.girls3),
//                new DataClass("Vika", R.drawable.girls4),
//                new DataClass("Yana", R.drawable.girls5),
//                new DataClass("Jenny", R.drawable.girls6),
//                new DataClass("Lena", R.drawable.girls7)
//
//        };
//
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//                mAdapter = new RvAdapter(context, listData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//                recyclerView.setAdapter(mAdapter);
    }

}
