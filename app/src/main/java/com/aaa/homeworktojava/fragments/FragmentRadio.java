package com.aaa.homeworktojava.fragments;


import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.adapter.RadioAdapter;
import com.aaa.homeworktojava.data.DataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class FragmentRadio extends Fragment {

    private ArrayList<DataClass> listData = new ArrayList<DataClass>();
    RecyclerView recyclerView;
    SeekBar seekBar;
    RadioAdapter mAdapter;
    MediaPlayer mediaPlayer;
    private Handler myHandler = new Handler();
    Utils utils = new Utils();
    //"DataClass" here will reflect what you have called your database in Firebase.
    DatabaseReference mRef= utils.getmRef().child("DataRadio");


    public FragmentRadio() {
        // empty public constructor
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
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setVisibility(View.VISIBLE) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listData = new ArrayList<DataClass>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    DataClass dataClass = dataSnapshot1.getValue(DataClass.class);
                    listData.add(dataClass);
                }
                mAdapter = new RadioAdapter(context, listData);
                mAdapter.notifyDataSetChanged();
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(mAdapter);


                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                        linearLayoutManager.getOrientation());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.addItemDecoration(dividerItemDecoration);

                mAdapter.setOnItemClickListener(new RadioAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(final Button button, View view, final DataClass obj, int position) {
                        if (button.getText().equals("Stop")) {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            button.setText("Play");
                        } else {

                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        mediaPlayer = new MediaPlayer();
                                        mediaPlayer.setDataSource(obj.getRadioUrl());
                                        mediaPlayer.prepareAsync();
                                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                            @Override
                                            public void onPrepared(MediaPlayer mediaPlayer) {
                                                mediaPlayer.start();
                                                seekBar.setProgress(0);
                                                seekBar.setMax(mediaPlayer.getDuration());

                                            }
                                        });
                                        button.setText("Stop");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            myHandler.postDelayed(runnable, 1000);
                        }

                    }
                });
//                checkUserPermission();

                Thread thread = new runThread();
                thread.start();
            }

            class runThread extends Thread {
                private static final String TAG = "runThread";

                @Override
                public void run() {
                    while (true) {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "run: " + 1);
                        if (mediaPlayer != null) {

                            seekBar.post(new Runnable() {
                                @Override
                                public void run() {
                                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                                }
                            });
                            Log.d(TAG, "run: " + mediaPlayer.getCurrentPosition());
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void checkUserPermission() {
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getContext()), Manifest.permission.READ_EXTERNAL_STORAGE)
//                    != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
//                return;
//            }
//        }
//        loadSongs();
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadSongs();
                } else {
                    Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
//                    checkUserPermission();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    private void loadSongs() {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " !=0";
        Cursor cursor = Objects.requireNonNull(getContext()).getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
//                    String description = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String radioUrl = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

                    DataClass dataClass = new DataClass(null, null, radioUrl, null);
                    listData.add(dataClass);

                } while (cursor.moveToNext());
            }
            cursor.close();
            mAdapter = new RadioAdapter(getContext(), listData);
        }
    }
}



