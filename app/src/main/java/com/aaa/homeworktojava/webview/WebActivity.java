//package com.aaa.homeworktojava.webview;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.aaa.homeworktojava.R;
//import com.aaa.homeworktojava.data.DataClass;
//import com.bumptech.glide.Glide;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//
//
//public class WebActivity extends AppCompatActivity {
//
//    private RecyclerView mPeopleRV;
//    private DatabaseReference mDatabase;
//    private FirebaseRecyclerAdapter<DataClass, WebActivity.ViewHolder> mPeopleRVAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.rv_list);
//
////        setTitle("DataCars");
//
//        //"News" here will reflect what you have called your database in Firebase.
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("DataCars");
//        mDatabase.keepSynced(true);
//
//        mPeopleRV = (RecyclerView) findViewById(R.id.recyclerView);
//
//        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("DataCars");
//        Query personsQuery = personsRef.orderByKey();
//
//        mPeopleRV.hasFixedSize();
//        mPeopleRV.setLayoutManager(new LinearLayoutManager(this));
//
//        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<DataClass>().setQuery(personsQuery, DataClass.class).build();
//
//        mPeopleRVAdapter = new FirebaseRecyclerAdapter<DataClass, WebActivity.ViewHolder>(personsOptions) {
//            @Override
//            protected void onBindViewHolder(WebActivity.ViewHolder holder, final int position, final DataClass model) {
//                holder.setDesc(model.getDescription());
//                holder.setImage(getBaseContext(), model.getImage());
//
//                holder.mView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        final String url = model.getUrl();
//                        Intent intent = new Intent(getApplicationContext(), WebView.class);
//                        intent.putExtra("id", url);
//                        startActivity(intent);
//                    }
//                });
//            }
//
//            @NonNull
//            @Override
//            public WebActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//                View view = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.item_list, parent, false);
//
//                return new ViewHolder(view);
//            }
//        };
//
//        mPeopleRV.setAdapter(mPeopleRVAdapter);
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        mPeopleRVAdapter.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        mPeopleRVAdapter.stopListening();
//
//
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        View mView;
//        public ViewHolder(View itemView){
//            super(itemView);
//            mView = itemView;
//        }
//
//        public void setDesc(String desc){
//            TextView post_desc = (TextView)mView.findViewById(R.id.description_tv);
//            post_desc.setText(desc);
//        }
//        public void setImage(Context ctx, String image){
//            ImageView post_image = (ImageView) mView.findViewById(R.id.imageView_tv);
//
//            Glide.with(ctx).load(image).into(post_image);
//        }
//    }
//}
