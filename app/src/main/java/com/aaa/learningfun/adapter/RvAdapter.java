package com.aaa.learningfun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.aaa.LearningFun.R;
import com.aaa.learningfun.data.DataClass;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private ArrayList<DataClass> dataClass;
    private Context context;
    private RvAdapter.OnItemClickListener mOnItemClickListener;


    //RecyclerView recyclerView;
    public RvAdapter(Context context, ArrayList<DataClass> dataClass) {
        this.dataClass = dataClass;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onItemClick(ConstraintLayout view, View view1, DataClass obj, int position);
    }

    public void setOnItemClickListener(final RvAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new RvAdapter.ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final DataClass uploadInfo = dataClass.get(position);
        viewHolder.setDescription(uploadInfo.getDescription());
        viewHolder.setImage(uploadInfo.getImage());

        viewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(viewHolder.constraintLayout, view, uploadInfo, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataClass.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

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


