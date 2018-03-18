package com.phinmaregistraronlinecourse.fragment;

import android.app.ProgressDialog;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.phinmaregistraronlinecourse.ModuleFiveActivity;
import com.phinmaregistraronlinecourse.ModuleFourActivity;
import com.phinmaregistraronlinecourse.ModuleOneActivity;
import com.phinmaregistraronlinecourse.ModuleSevenActivity;
import com.phinmaregistraronlinecourse.ModuleSixActivity;
import com.phinmaregistraronlinecourse.ModuleThreeActivity;
import com.phinmaregistraronlinecourse.ModuleTwoActivity;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.activity.MainActivity;
import com.phinmaregistraronlinecourse.activity.QuizConfirmation;
import com.phinmaregistraronlinecourse.adapter.Achievement;
import com.phinmaregistraronlinecourse.adapter.AchievementAdapter;
import com.phinmaregistraronlinecourse.adapter.AchievementData;
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.ModuleAdapter;
import com.phinmaregistraronlinecourse.adapter.QuizData;
import com.phinmaregistraronlinecourse.adapter.UserData;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.RequestHandler;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;
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

    private ProgressDialog progressDialog;
    UserData user;
    AchievementData score;

    //String module;
    String count_m1, count_m2, count_m3, count_m4, count_m5, count_m6, count_m7;


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




        try {
            makeJsonArrayRequest();
            makeScoreArray();
            prepareAchievements();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void prepareAchievements() {


        score = SharedPrefManager.getInstance(getContext()).getScore();
        int score1,score2,score3,score4,score5,score6,score7;
        int total1,total2,total3,total4,total5,total6,total7;
        int progress1,progress2,progress3,progress4,progress5,progress6,progress7;


        score1=Integer.parseInt(score.getScoreModule1());
        score2=Integer.parseInt(score.getScoreModule2());
        score3=Integer.parseInt(score.getScoreModule3());
        score4=Integer.parseInt(score.getScoreModule4());
        score5=Integer.parseInt(score.getScoreModule5());
        score6=Integer.parseInt(score.getScoreModule6());

        total1=Integer.parseInt(SharedPrefManager.getInstance(getContext()).getcountModule1());
        total2=Integer.parseInt(SharedPrefManager.getInstance(getContext()).getcountModule2());
        total3=Integer.parseInt(SharedPrefManager.getInstance(getContext()).getcountModule3());
        total4=Integer.parseInt(SharedPrefManager.getInstance(getContext()).getcountModule4());
        total5=Integer.parseInt(SharedPrefManager.getInstance(getContext()).getcountModule5());
        total6=Integer.parseInt(SharedPrefManager.getInstance(getContext()).getcountModule6());


        progress1=score1 * 100 / total1;
        progress2=score2 * 100 / total2;
        progress3=score3 * 100 / total3;
        progress4=score4 * 100 / total4;
        progress5=score5 * 100 / total5;
        progress6=score6 * 100 / total6;



        Achievement a = new Achievement("General Admission Policy",progress1);
        achievementList.add(a);

        a = new Achievement("Student Enrollment", progress2);
        achievementList.add(a);

        a = new Achievement("Enrollment Preparations", progress3);
        achievementList.add(a);

        a = new Achievement("Grading",progress4);
        achievementList.add(a);

        a = new Achievement("Graduation", progress5);
        achievementList.add(a);

        a = new Achievement("Registrar's Documents and Transaction Standards",progress6);
        achievementList.add(a);

        a = new Achievement("Academic and Non-Academic Awards and Scholarships", progress6);
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




        JsonArrayRequest req = new JsonArrayRequest(Constants.URL_QUESTION_COUNT,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);

                                if (i == 0) {
                                    count_m1 = obj.getString("module1");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule1(count_m1);

                                }else if (i == 1) {
                                    count_m2 = obj.getString("module2");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule2(count_m2);
                                }else if (i == 2) {
                                    count_m3 = obj.getString("module3");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule3(count_m3);
                                }else if (i == 3) {
                                    count_m4 = obj.getString("module4");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule4(count_m4);
                                }else if (i == 4) {
                                    count_m5 = obj.getString("module5");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule5(count_m5);
                                }else if (i == 5) {
                                    count_m6 = obj.getString("module6");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule6(count_m6);
                                }else if (i == 6) {
                                    count_m7 = obj.getString("module7");
                                    SharedPrefManager.getInstance(getActivity()).setcountModule7(count_m7);
                                }



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);


    }

    private void makeScoreArray(){

        user = SharedPrefManager.getInstance(getContext()).getUser();

        final String account_id = String.valueOf(user.getId());


        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,

                Constants.URL_LEADERBOARD,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {

                                try {

                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    AchievementData scoreData = new AchievementData(
                                            obj.getInt("id"),
                                            obj.getString("general_admission_policy_quiz"),
                                            obj.getString("student_enrollment_quiz"),
                                            obj.getString("enrollment_preparation_quiz"),
                                            obj.getString("grading_quiz"),
                                            obj.getString("graduation_quiz"),
                                            obj.getString("registrar_document_and_transaction_standard_quiz"),
                                            obj.getString("academic_and_non_academic_award_and_scholarship_quiz")
                                    );


                                    //storing the user in shared preferences
                                    SharedPrefManager.getInstance(getContext()).achievementScore(scoreData);
                                } catch (JSONException e) {

                                    e.printStackTrace();

                                }

                            }

                        } catch (JSONException e2) {
                            e2.printStackTrace();


                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(
                                getContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("account_id", account_id);
                return params;
            }

        };

        RequestHandler.getInstance(getContext()).addToRequestQueue(stringRequest);
    }

}