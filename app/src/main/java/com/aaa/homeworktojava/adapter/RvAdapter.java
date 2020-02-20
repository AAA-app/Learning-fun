package com.aaa.homeworktojava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.data.DataClass;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    //    private ArrayList<DataClass> imageDataClass;
    List<DataClass> imageDataClass;
     Context context;
    private ViewHolder viewHolder;
    private int position;
    private DataClass model = new DataClass();


    //RecyclerView recyclerView;
    public RvAdapter(Context context, List<DataClass> imageDataClass) {
        this.imageDataClass = imageDataClass;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        DataClass uploadInfo = imageDataClass.get(position);
        viewHolder.setDescription(uploadInfo.getDescription());

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Click on Item: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new RvAdapter.ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return imageDataClass.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout relativeLayout;
        View mView;
        Context ctx;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            this.relativeLayout = (RelativeLayout) mView.findViewById(R.id.relativeLayout);
        }

        public void setDescription(String desc) {
            TextView post_description = (TextView) mView.findViewById(R.id.description_tv);
            post_description.setText(desc);
        }


        public void setImageUrl(Context ctx1 , String image) {

            ImageView image_pos = (ImageView) mView.findViewById(R.id.imageView_tv);
            Glide.with(ctx1).load(image).into(image_pos);
        }
    }
}

//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        View mView;
//        public RelativeLayout relativeLayout;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            mView = itemView;
//            relativeLayout = (RelativeLayout) mView.findViewById(R.id.relativeLayout);
//        }
//
//        public void setDescrription(String desc) {
//            TextView post_description = (TextView) mView.findViewById(R.id.textView);
//            post_description.setText(desc);
//        }
//
//        public void setImageUrl(Context ctx, String image) {
//            ImageView post_imageUrl = (ImageView) mView.findViewById(R.id.imageView);
//
//            Glide.with(ctx).load(image).into(post_imageUrl);
//        }


//        public ImageView imageView;
//        public TextView textView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
//            this.textView = (TextView) itemView.findViewById(R.id.textView);
//            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
//        }

