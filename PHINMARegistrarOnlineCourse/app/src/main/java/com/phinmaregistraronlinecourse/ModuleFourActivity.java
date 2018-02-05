package com.phinmaregistraronlinecourse;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.phinmaregistraronlinecourse.adapter.SubModule;
import com.phinmaregistraronlinecourse.adapter.SubModuleAdapter;
import com.phinmaregistraronlinecourse.moduleFour.ModuleFourSub1;
import com.phinmaregistraronlinecourse.moduleFour.ModuleFourSub2;
import com.phinmaregistraronlinecourse.moduleFour.ModuleFourSub3;
import com.phinmaregistraronlinecourse.moduleFour.ModuleFourSub4;
import com.phinmaregistraronlinecourse.moduleFour.ModuleFourSub5;
import com.phinmaregistraronlinecourse.moduleFour.ModuleFourSub6;
import com.phinmaregistraronlinecourse.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class ModuleFourActivity extends AppCompatActivity {

    private static final String TAG = ModuleFourActivity.class.getSimpleName();

    String title;

    private List<SubModule> subModuleList;
    SubModuleAdapter adapter;
    Context context;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_four);

        context=this;
        recyclerView = (RecyclerView) findViewById(R.id.list_submodule);

        subModuleList = new ArrayList<>();

        Intent i = getIntent();
        title = i.getStringExtra("title");

        //Collapsing toolbar
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_container);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.my_appbar_container);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(title);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.technique_three_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                SubModule subModule = subModuleList.get(position);

                int number = subModule.getId();
                if(number==1){
                    Intent intent=new Intent(getApplicationContext(),ModuleFourSub1.class);
                    intent.putExtra("title",subModule.getTitle());
                    startActivity(intent);
                }
                else if(number==2){
                    Intent intent=new Intent(getApplicationContext(),ModuleFourSub2.class);
                    intent.putExtra("title",subModule.getTitle());
                    startActivity(intent);
                }
                else if(number==3){
                    Intent intent=new Intent(getApplicationContext(),ModuleFourSub3.class);
                    intent.putExtra("title",subModule.getTitle());
                    startActivity(intent);
                }
                else if(number==4){
                    Intent intent=new Intent(getApplicationContext(),ModuleFourSub4.class);
                    intent.putExtra("title",subModule.getTitle());
                    startActivity(intent);
                }
                else if(number==5){
                    Intent intent=new Intent(getApplicationContext(),ModuleFourSub5.class);
                    intent.putExtra("title",subModule.getTitle());
                    startActivity(intent);
                }
                else if(number==6){
                    Intent intent=new Intent(getApplicationContext(),ModuleFourSub6.class);
                    intent.putExtra("title",subModule.getTitle());
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new SubModuleAdapter(subModuleList);
        subModuleList.clear();

        SubModule a = new SubModule(1,"Encoding and Submission of Grades by Faculty Members");
        subModuleList.add(a);
        a = new SubModule(2,"Release of Grades");
        subModuleList.add(a);
        a = new SubModule(3,"Final examination as requirements for passing board subjects and board preparation subjects");
        subModuleList.add(a);
        a = new SubModule(4,"The Grade Point Average (GPA)");
        subModuleList.add(a);
        a = new SubModule(5,"Change of Grade");
        subModuleList.add(a);
        a = new SubModule(6,"Dean’s List");
        subModuleList.add(a);


        //recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        adapter.notifyDataSetChanged();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == android.R.id.home){

            onBackPressed();
            adapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }
}
