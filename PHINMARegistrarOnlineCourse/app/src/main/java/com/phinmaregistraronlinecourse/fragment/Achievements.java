package com.phinmaregistraronlinecourse.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.phinmaregistraronlinecourse.ModuleFiveActivity;
import com.phinmaregistraronlinecourse.ModuleFourActivity;
import com.phinmaregistraronlinecourse.ModuleOneActivity;
import com.phinmaregistraronlinecourse.ModuleSevenActivity;
import com.phinmaregistraronlinecourse.ModuleSixActivity;
import com.phinmaregistraronlinecourse.ModuleThreeActivity;
import com.phinmaregistraronlinecourse.ModuleTwoActivity;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.Achievement;
import com.phinmaregistraronlinecourse.adapter.AchievementAdapter;
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.ModuleAdapter;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manipon on 02/09/2018.
 */

public class Achievements extends Fragment {

    private RecyclerView recyclerView;
    private AchievementAdapter adapter;
    private List<Achievement> achievementList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view =  inflater.inflate(R.layout.fragment_achievement, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        achievementList = new ArrayList<>();
        adapter = new AchievementAdapter(getActivity(), achievementList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareAchievements();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void prepareAchievements() {


        Achievement a = new Achievement("General Admission Policy",12);
        achievementList.add(a);

        a = new Achievement("Student Enrollment",50);
        achievementList.add(a);

        a = new Achievement("Enrollment Preparations",60);
        achievementList.add(a);

        a = new Achievement("Grading",2);
        achievementList.add(a);

        a = new Achievement("Graduation",70);
        achievementList.add(a);

        a = new Achievement("Registrar's Documents and Transaction Standards",80);
        achievementList.add(a);

        a = new Achievement("Academic and Non-Academic Awards and Scholarships",100);
        achievementList.add(a);


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

    }

}