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

public class AwardAdapter extends RecyclerView.Adapter<AwardAdapter.MyViewHolder> {

    private Context mContext;
    private List<Award> awardList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView trophy;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtName);
            trophy = (ImageView) view.findViewById(R.id.trophy);
        }
    }


    public AwardAdapter(Context mContext, List<Award> awardList) {
        this.mContext = mContext;
        this.awardList = awardList;
    }

    @Override
    public AwardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.awards_card, parent, false);

        return new AwardAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AwardAdapter.MyViewHolder holder, int position) {
        final Award award = awardList.get(position);
        holder.name.setText(award.getName());
        Glide.with(mContext).load(award.getTrophy()).into(holder.trophy);

    }



    @Override
    public int getItemCount() {
        return awardList.size();
    }
}

