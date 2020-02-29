package com.aaa.homeworktojava.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.adapter.RvAdapter;
import com.aaa.homeworktojava.data.DataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;


public class FragmentAnimation extends Fragment {


    RecyclerView recyclerView;
    ArrayList<DataClass> listData;
    RvAdapter mAdapter;
    Utils utils = new Utils();
    //"DataClass" here will reflect what you have called your database in Firebase.
    DatabaseReference mRef= utils.getmRef().child("DataAnimation");

    public FragmentAnimation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

                utils.LayoutOptions(recyclerView,context);
                mAdapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(ConstraintLayout view, View view1, DataClass obj, int position) {
                        utils.clickWebview(getContext(), obj);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}