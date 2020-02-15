package com.aaa.homeworktojava.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.adapter.MusicAdapter;
import com.aaa.homeworktojava.data.MusicData;


public class FragmentOne extends Fragment {
    Context context;

    public FragmentOne() {
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
        MusicData[] musicData = new MusicData[] {
                new MusicData("DeepHouse", R.drawable.music1),
                new MusicData("R'N'B",  R.drawable.music2),
                new MusicData("Remix", R.drawable.music3),
                new MusicData("Coding Remix", R.drawable.music4),
                new MusicData("Psychedelic Trance", R.drawable.music5),
                new MusicData("Hits deep Progressive", R.drawable.music6),
                new MusicData("chillout", R.drawable.music7),
        };

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        MusicAdapter adapter = new MusicAdapter(musicData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

    }
}
