package com.aaa.homeworktojava.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.data.MusicData;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private ViewHolder viewHolder;

    private MusicData[] musicdata;


    //RecyclerView recyclerView;
    public MusicAdapter(MusicData[] musicdata) {
        this.musicdata = musicdata;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_list, parent, false);
        viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MusicData musicData = musicdata[position];
        holder.textView.setText(musicdata[position].getDescription());
        holder.imageView.setImageResource(musicdata[position].getImgID());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Click on Item: " + musicData.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return musicdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
