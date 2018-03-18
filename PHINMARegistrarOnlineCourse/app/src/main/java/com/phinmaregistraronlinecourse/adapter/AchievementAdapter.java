package com.phinmaregistraronlinecourse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phinmaregistraronlinecourse.R;

import java.util.List;

/**
 * Created by Manipon on 02/09/2018.
 */

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.MyViewHolder> {

    private Context mContext;
    private List<Achievement> achievementList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,percent;
        public ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            percent = (TextView) view.findViewById(R.id.percent);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }


    public AchievementAdapter(Context mContext, List<Achievement> achievementList) {
        this.mContext = mContext;
        this.achievementList = achievementList;
    }

    @Override
    public AchievementAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.achievements_card, parent, false);

        return new AchievementAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AchievementAdapter.MyViewHolder holder, int position) {
        final Achievement achievement = achievementList.get(position);
        holder.title.setText(achievement.getTitle());
        holder.percent.setText(achievement.getProgress()+"%");
        holder.progressBar.setProgress(achievement.getProgress());


    }



    @Override
    public int getItemCount() {
        return achievementList.size();
    }
}
