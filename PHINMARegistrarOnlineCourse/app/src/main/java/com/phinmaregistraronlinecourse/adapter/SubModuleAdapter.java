package com.phinmaregistraronlinecourse.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.volley.AppController;

import java.util.List;

/**
 * Created by Manipon on 02/01/2018.
 */

public class SubModuleAdapter extends RecyclerView.Adapter<SubModuleAdapter.MyViewHolder> {

    Context mContext;
    private LayoutInflater inflater;
    private List<SubModule> subModuleList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txtTitle);
            imageView = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public SubModuleAdapter(List<SubModule> subModuleList) {
        this.subModuleList = subModuleList;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_submodule, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SubModule m = subModuleList.get(position);
        holder.title.setText(subModuleList.get(position).getTitle());
        holder.imageView.setImageResource(subModuleList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return subModuleList.size();
    }


}
