package com.aaa.homeworktojava.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaa.homeworktojava.MainActivity;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.adapter.RvAdapter;
import com.aaa.homeworktojava.data.DataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FragmentJava extends Fragment {


    DatabaseReference mRef;
    RecyclerView recyclerView;
    ArrayList<DataClass> listData;
    RvAdapter mAdapter;
    ImageView toolbarImg = MainActivity.mImageView;


    public FragmentJava() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //"News" here will reflect what you have called your database in Firebase.
        mRef = FirebaseDatabase.getInstance().getReference().child("DataCars");
        mRef.keepSynced(true);
        return inflater.inflate(R.layout.rv_list, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Context context = this.getContext();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               listData = new ArrayList<DataClass>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    DataClass dataClass = dataSnapshot1.getValue(DataClass.class);
                    listData.add(dataClass);
                }
                mAdapter = new RvAdapter(context, listData);
                mAdapter.notifyDataSetChanged();
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}