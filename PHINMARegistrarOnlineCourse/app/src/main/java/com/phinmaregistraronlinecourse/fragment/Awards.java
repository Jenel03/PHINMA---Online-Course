package com.phinmaregistraronlinecourse.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.Achievement;
import com.phinmaregistraronlinecourse.adapter.AchievementAdapter;
import com.phinmaregistraronlinecourse.adapter.Award;
import com.phinmaregistraronlinecourse.adapter.AwardAdapter;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;
import com.phinmaregistraronlinecourse.volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manipon on 01/30/2018.
 */

public class Awards extends Fragment {

    private RecyclerView recyclerView;
    private AwardAdapter adapter;
    private List<Award> awardList;

    private static final String TAG = Awards.class.getSimpleName();


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



        try {
            makeJsonArrayRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }



    private void makeJsonArrayRequest() {

        JsonArrayRequest movieReq = new JsonArrayRequest(Constants.URL_AWARDS,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Award award = new Award();

                                award.setName(obj.getString("firstname")+" "+obj.getString("lastname"));
                                award.setProfile(Constants.IMAGE_URL+obj.getString("image"));
                                award.setScore(obj.getString("score"));

                                awardList.add(award);


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
        AppController.getInstance().addToRequestQueue(movieReq);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Awards");
    }



}
