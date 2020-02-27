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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.data.DataClass;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private ArrayList<DataClass> imageDataClass;
   private Context context;



    //RecyclerView recyclerView;
    public RvAdapter(Context context, ArrayList<DataClass> imageDataClass) {
        this.imageDataClass = imageDataClass;
        this.context = context;
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new RvAdapter.ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        DataClass uploadInfo = imageDataClass.get(position);
        viewHolder.setDescription(uploadInfo.getDescription());

        viewHolder.setImage(uploadInfo.getImage());



        viewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Click on Item: ", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return imageDataClass.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout constraintLayout;
        View mView;
        Context ctx;

        public ImageView image_pos;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            mView = itemView;
            this.ctx = ctx;
            this.constraintLayout = (ConstraintLayout) mView.findViewById(R.id.layout);
        }

        public void setDescription(String desc) {
            TextView post_description = (TextView) mView.findViewById(R.id.description_tv);
            post_description.setText(desc);
        }


        public void setImage(String image) {
            image_pos = (ImageView) mView.findViewById(R.id.imageView_tv);
            Glide.with(this.ctx).load(image).into(image_pos);
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

