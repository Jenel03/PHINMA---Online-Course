package com.phinmaregistraronlinecourse.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.Achievement;
import com.phinmaregistraronlinecourse.adapter.AchievementAdapter;
import com.phinmaregistraronlinecourse.adapter.Award;
import com.phinmaregistraronlinecourse.adapter.AwardAdapter;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manipon on 01/30/2018.
 */

public class Awards extends Fragment {

    private RecyclerView recyclerView;
    private AwardAdapter adapter;
    private List<Award> awardList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view =  inflater.inflate(R.layout.fragment_awards, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        awardList = new ArrayList<>();
        adapter = new AwardAdapter(getActivity(), awardList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareAwards();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void prepareAwards() {

        int[] trophy = new int[]{
                R.drawable.ic_trophy_outline_grey600_18dp};


        Award a = new Award("Name",trophy[0]);
        awardList.add(a);

        a = new Award("Name",trophy[0]);
        awardList.add(a);

        a = new Award("Name",trophy[0]);
        awardList.add(a);

        a = new Award("Name",trophy[0]);
        awardList.add(a);

        a = new Award("Name",trophy[0]);
        awardList.add(a);

        a = new Award("Name",trophy[0]);
        awardList.add(a);

        a = new Award("Name",trophy[0]);
        awardList.add(a);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        adapter.notifyDataSetChanged();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Awards");
    }

}
