package com.phinmaregistraronlinecourse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phinmaregistraronlinecourse.R;

import java.util.List;

/**
 * Created by Manipon on 01/31/2018.
 */

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.MyViewHolder> {

    private Context mContext;
    private List<Module> moduleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public ModuleAdapter(Context mContext, List<Module> moduleList) {
        this.mContext = mContext;
        this.moduleList = moduleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.module_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Module module = moduleList.get(position);
        holder.title.setText(module.getName());
        holder.subtitle.setText(module.getNumOfLectures() + " lectures");

        // loading album cover using Glide library
        Glide.with(mContext).load(module.getThumbnail()).into(holder.thumbnail);



    }



    @Override
    public int getItemCount() {
        return moduleList.size();
    }
}
