package com.aaa.homeworktojava.fragments;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaa.homeworktojava.data.DataClass;
import com.aaa.homeworktojava.webview.WebView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Utils {
    // connecting to firebase realTime
    public DatabaseReference getmRef() {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        mRef.keepSynced(true);
        return mRef;
    }
    //get url go to webSite
    public void clickWebview(Context context, DataClass obj) {
        Toast.makeText(context, "place white..", Toast.LENGTH_SHORT).show();
        final String url = obj.getUrl();
        assert context != null;
        Intent intent = new Intent(context.getApplicationContext(), WebView.class);
        intent.putExtra("id", url);
        context.startActivity(intent);
    }
    // layout options
    public void LayoutOptions(RecyclerView recyclerView, Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

}
