package com.aaa.homeworktojava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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


public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {

    private ArrayList<DataClass> imageDataClass;
    private Context context;
    private OnItemClickListener mOnItemClickListener;


    //RecyclerView recyclerView;
    public RadioAdapter(Context context, ArrayList<DataClass> imageDataClass) {
        this.imageDataClass = imageDataClass;
        this.context = context;
    }


    public interface OnItemClickListener {
        void onItemClick(Button b, View view, DataClass obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_radio, viewGroup, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final DataClass uploadInfo = imageDataClass.get(position);
        viewHolder.setDescription(uploadInfo.getDescription());
        viewHolder.setImage(uploadInfo.getImage());

        viewHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(viewHolder.btnAction, view, uploadInfo, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return imageDataClass.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout constraintLayout;
        View mView;
        Context ctx;
        Button btnAction;

        public ImageView image_pos;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            this.mView = itemView;
            this.ctx = ctx;
            btnAction = (Button)mView.findViewById(R.id.btnPlay_radio);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.layout);
        }

        public void setDescription(String desc) {
            TextView post_description = (TextView) mView.findViewById(R.id.description_radio);
            post_description.setText(desc);
        }


        public void setImage(String image) {
            image_pos = (ImageView) mView.findViewById(R.id.img_radio);
            Glide.with(this.ctx).load(image).into(image_pos);
        }
    }
}


