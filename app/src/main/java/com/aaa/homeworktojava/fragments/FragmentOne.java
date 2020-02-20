package com.aaa.homeworktojava.fragments;

import android.content.Context;
import android.content.res.Resources.*;
import android.content.res.Resources.Theme.*;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.style.TtsSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.aaa.homeworktojava.MainActivity;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.adapter.RvAdapter;
import com.aaa.homeworktojava.data.DataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FragmentOne extends Fragment {

    Context context;
    DatabaseReference mRef;
    RecyclerView recyclerView;
    List<DataClass> listData = new ArrayList<>();
    RvAdapter mAdapter;


    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//"News" here will reflect what you have called your database in Firebase.
        mRef = FirebaseDatabase.getInstance().getReference().child("DataCars");
        mRef.keepSynced(true);

//        View anotherView = inflater.inflate(R.layout.activity_main,container,false);
//       ImageView toolbarImgOne = (ImageView)anotherView.findViewById(R.id.image_tv_toolbar);
//       toolbarImgOne.setImageResource(R.drawable.car1);

//        View anotherView = inflater.inflate(R.layout.activity_main,container,false);
//        ImageView toolbarImgOne = (ImageView)anotherView.findViewById(R.id.image_tv_toolbar);
//        toolbarImgOne.setBackgroundColor(R.color.colorPrimaryDark);
        return inflater.inflate(R.layout.rv_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        recyclerView = view.findViewById(R.id.recyclerView);

//        toolbarImgOne = view.findViewById(R.id.image_tv_toolbar);



        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                listData = new ArrayList<DataClass>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    DataClass dataClass = dataSnapshot1.getValue(DataClass.class);
                    listData.add(dataClass);
                }
                mAdapter = new RvAdapter(context, listData);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(mAdapter);


            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    public void onStart() {
//        super.onStart();
//        Log.d(TAG, "onStart: ");
//    }
//    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//    public void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop: ");
//    }
}

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
////        mRef= FirebaseDatabase.getInstance().getReference().child("DataCars");
////        Query dataQuery = mRef.orderByKey();
////        RecyclerView dataOptions = new .Builder<DataClass>().setQuery(dataQuery, DataClass.class).build();
//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                listData = new ArrayList<DataClass>();
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    DataClass dataClass = dataSnapshot1.getValue( DataClass.class);
//                    listData.add(dataClass);
//                }
//                mAdapter = new RvAdapter(context, listData);
//                recyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(context, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
