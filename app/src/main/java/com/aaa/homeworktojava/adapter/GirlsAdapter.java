package com.aaa.homeworktojava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.aaa.homeworktojava.R;
import com.aaa.homeworktojava.data.GirlsData;


public class GirlsAdapter extends RecyclerView.Adapter<GirlsAdapter.ViewHolder> {

    private ViewHolder viewHolder;

    private GirlsData[] girlsdata;

    //RecyclerView recyclerView;
    public GirlsAdapter(GirlsData[] girlsdata) {
        this.girlsdata = girlsdata;
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
        final GirlsData girlsData = girlsdata[position];
        holder.textView.setText(girlsdata[position].getDescription());
        holder.imageView.setImageResource(girlsdata[position].getImgID());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Click on Item: " +girlsData.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return girlsdata.length;
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
