package com.phinmaregistraronlinecourse.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.ModuleAdapter;
import com.phinmaregistraronlinecourse.adapter.UserData;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.RequestHandler;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manipon on 01/30/2018.
 */

public class Modules extends Fragment {

    private RecyclerView recyclerView;
    private ModuleAdapter adapter;
    private List<Module> moduleList;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    Module a;
    UserData user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view =  inflater.inflate(R.layout.fragment_module, container, false);

        user = SharedPrefManager.getInstance(getContext()).getUser();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        moduleList = new ArrayList<>();
        adapter = new ModuleAdapter(getActivity(), moduleList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);




        prepareModule();


        try {

            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // Refresh items
                    refreshItems();
                    /*
                    moduleList.clear();
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    prepareModule();
                    */
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }



        return view;
    }



    private void prepareModule() {


        int[] covers = new int[]{
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample};

        if(user.getModule1().equals("YES")){
            a = new Module(1,"General Admission Policy", 6, covers[0]);
            moduleList.add(a);
        }
        if(user.getModule2().equals("YES")){
            a = new Module(2,"Student Enrollment", 8, covers[1]);
            moduleList.add(a);
        }
        if(user.getModule3().equals("YES")){
            a = new Module(3,"Enrollment Preparations", 4, covers[2]);
            moduleList.add(a);
        }
        if(user.getModule4().equals("YES")){
            a = new Module(4,"Grading", 6, covers[3]);
            moduleList.add(a);
        }
        if(user.getModule5().equals("YES")){
            a = new Module(5,"Graduation", 3, covers[4]);
            moduleList.add(a);
        }
        if(user.getModule6().equals("YES")){
            a = new Module(6,"Registrar's Documents and Transaction Standards", 4, covers[5]);
            moduleList.add(a);
        }
        if(user.getModule7().equals("YES")){
            a = new Module(7,"Academic and Non-Academic Awards and Scholarships", 9, covers[6]);
            moduleList.add(a);
        }




        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Module module = moduleList.get(position);

                int number = module.getId();
                if(number==1){
                    Intent intent=new Intent(getContext(),ModuleOneActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
                else if(number==2){
                    Intent intent=new Intent(getContext(),ModuleTwoActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
                else if(number==3){
                    Intent intent=new Intent(getContext(),ModuleThreeActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
                else if(number==4){
                    Intent intent=new Intent(getContext(),ModuleFourActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
                else if(number==5){
                    Intent intent=new Intent(getContext(),ModuleFiveActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
                else if(number==6){
                    Intent intent=new Intent(getContext(),ModuleSixActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
                else if(number==7){
                    Intent intent=new Intent(getContext(),ModuleSevenActivity.class);
                    intent.putExtra("title",module.getName());
                    SharedPrefManager.getInstance(getContext()).setNumberOfModule(module.getId());
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        adapter.notifyDataSetChanged();
    }

    void refreshItems() {
        // Load items
        // ...

        // Load complete
        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...
        //refreshData();
        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void refreshData(){
        final String password = user.getPassword();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,

                Constants.URL_LOGIN,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){



                                //creating a new user object
                                UserData user = new UserData(
                                        obj.getInt("id"),
                                        obj.getString("emp_id"),
                                        obj.getString("firstname"),
                                        obj.getString("middlename"),
                                        obj.getString("lastname"),
                                        obj.getString("email"),
                                        obj.getString("username"),
                                        password,
                                        obj.getString("image"),
                                        obj.getString("general_admission_policy"),
                                        obj.getString("student_enrollment"),
                                        obj.getString("enrollment_preparation"),
                                        obj.getString("grading"),
                                        obj.getString("graduation"),
                                        obj.getString("registrar_document_and_transaction_standard"),
                                        obj.getString("academic_and_non_academic_award_and_scholarship")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getContext()).userLogin(user);



                            }else{

                                Toast.makeText(
                                        getContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
                params.put("username", user.getUsername());
                params.put("password", password);
                return params;
            }

        };

        RequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles


    }
}
