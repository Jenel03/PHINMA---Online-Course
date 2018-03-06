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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.phinmaregistraronlinecourse.ModuleFiveActivity;
import com.phinmaregistraronlinecourse.ModuleFourActivity;
import com.phinmaregistraronlinecourse.ModuleOneActivity;
import com.phinmaregistraronlinecourse.ModuleSevenActivity;
import com.phinmaregistraronlinecourse.ModuleSixActivity;
import com.phinmaregistraronlinecourse.ModuleThreeActivity;
import com.phinmaregistraronlinecourse.ModuleTwoActivity;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.activity.QuizConfirmation;
import com.phinmaregistraronlinecourse.adapter.Achievement;
import com.phinmaregistraronlinecourse.adapter.AchievementAdapter;
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.ModuleAdapter;
import com.phinmaregistraronlinecourse.adapter.QuizData;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;
import com.phinmaregistraronlinecourse.volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manipon on 02/09/2018.
 */

public class Achievements extends Fragment {

    private static final String TAG = Achievement.class.getSimpleName();

    private RecyclerView recyclerView;
    private AchievementAdapter adapter;
    private List<Achievement> achievementList;


    String module;
    String count_m1,count_m2,count_m3,count_m4,count_m5,count_m6,count_m7;
    int j;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.fragment_achievement, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        achievementList = new ArrayList<>();
        adapter = new AchievementAdapter(getActivity(), achievementList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareAchievements();


        try {
            makeJsonArrayRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void prepareAchievements() {


        Achievement a = new Achievement("General Admission Policy", 12);
        achievementList.add(a);

        a = new Achievement("Student Enrollment", 50);
        achievementList.add(a);

        a = new Achievement("Enrollment Preparations", 60);
        achievementList.add(a);

        a = new Achievement("Grading", 2);
        achievementList.add(a);

        a = new Achievement("Graduation", 70);
        achievementList.add(a);

        a = new Achievement("Registrar's Documents and Transaction Standards", 80);
        achievementList.add(a);

        a = new Achievement("Academic and Non-Academic Awards and Scholarships", 100);
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

    private void makeJsonArrayRequest() {

        for (j = 0; j < 7; j++) {

            if(j==0){
                module = "General Admission Policy";
            }
            else if (j==1){
                module = "Student Enrollment";
            }
            else if (j==2){
                module = "Enrollment Preparations";
            }
            else if (j==3){
                module = "Grading";
            }
            else if (j==4){
                module = "Graduation";
            }
            else if (j==5){
                module = "Registrars Documents and Transactions Standards";
            }
            else if (j==6){
                module = "Academic and Non-Academic Awards and Scholarships";
            }

            StringRequest quizReq = new StringRequest(Request.Method.POST, Constants.URL_QUESTION_COUNT,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {

                                JSONArray jsonArray = new JSONArray(response);


                                JSONObject obj = jsonArray.getJSONObject(0);


                                if(module.equals("General Admission Policy")){
                                    count_m1 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),"lol ",Toast.LENGTH_SHORT).show();
                                }
                                else if (module.equals("Student Enrollment")){
                                    count_m2 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),count_m2,Toast.LENGTH_SHORT).show();
                                }
                                else if (module.equals("Enrollment Preparations")){
                                    count_m3 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),count_m3,Toast.LENGTH_SHORT).show();
                                }
                                else if (module.equals("Grading")){
                                    count_m4 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),count_m4,Toast.LENGTH_SHORT).show();
                                }
                                else if (module.equals("Graduation")){
                                    count_m5 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),count_m5,Toast.LENGTH_SHORT).show();
                                }
                                else if (module.equals("Registrars Documents and Transactions Standards")){
                                    count_m6 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),count_m6,Toast.LENGTH_SHORT).show();
                                }
                                else if (module.equals("Academic and Non-Academic Awards and Scholarships")){
                                    count_m7 = obj.getString("COUNT(id)");
                                    Toast.makeText(getContext(),count_m7,Toast.LENGTH_SHORT).show();
                                }



                            } catch (JSONException e2) {
                                e2.printStackTrace();


                            }

                        }
                    }, new Response.ErrorListener()

            {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());

                }
            })

            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("module", module);
                    return params;
                }

            };

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(quizReq);

        }
    }

}