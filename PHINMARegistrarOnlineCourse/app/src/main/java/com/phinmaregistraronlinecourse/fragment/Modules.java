package com.phinmaregistraronlinecourse.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phinmaregistraronlinecourse.ModuleFiveActivity;
import com.phinmaregistraronlinecourse.ModuleFourActivity;
import com.phinmaregistraronlinecourse.ModuleOneActivity;
import com.phinmaregistraronlinecourse.ModuleSevenActivity;
import com.phinmaregistraronlinecourse.ModuleSixActivity;
import com.phinmaregistraronlinecourse.ModuleThreeActivity;
import com.phinmaregistraronlinecourse.ModuleTwoActivity;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.ModuleAdapter;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manipon on 01/30/2018.
 */

public class Modules extends Fragment{

    private RecyclerView recyclerView;
    private ModuleAdapter adapter;
    private List<Module> moduleList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view =  inflater.inflate(R.layout.fragment_module, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        moduleList = new ArrayList<>();
        adapter = new ModuleAdapter(getActivity(), moduleList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample};

        Module a = new Module(1,"General Admission Policy", 13, covers[0]);
        moduleList.add(a);

        a = new Module(2,"Student Enrollment", 8, covers[1]);
        moduleList.add(a);

        a = new Module(3,"Enrollment Preparations", 11, covers[2]);
        moduleList.add(a);

        a = new Module(4,"Grading", 12, covers[3]);
        moduleList.add(a);

        a = new Module(5,"Graduation", 14, covers[4]);
        moduleList.add(a);

        a = new Module(6,"Registrar's Documents and Transaction Standards", 1, covers[5]);
        moduleList.add(a);

        a = new Module(7,"Academic and Non-Academic Awards and Scholarships", 11, covers[6]);
        moduleList.add(a);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Module module = moduleList.get(position);

                int number = module.getId();
                if(number==1){
                    Intent intent=new Intent(getContext(),ModuleOneActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
                else if(number==2){
                    Intent intent=new Intent(getContext(),ModuleTwoActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
                else if(number==3){
                    Intent intent=new Intent(getContext(),ModuleThreeActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
                else if(number==4){
                    Intent intent=new Intent(getContext(),ModuleFourActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
                else if(number==5){
                    Intent intent=new Intent(getContext(),ModuleFiveActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
                else if(number==6){
                    Intent intent=new Intent(getContext(),ModuleSixActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
                else if(number==7){
                    Intent intent=new Intent(getContext(),ModuleSevenActivity.class);
                    intent.putExtra("title",module.getName());
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        adapter.notifyDataSetChanged();
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
