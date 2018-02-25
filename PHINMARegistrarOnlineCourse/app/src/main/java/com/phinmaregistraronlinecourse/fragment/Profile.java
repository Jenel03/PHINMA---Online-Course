package com.phinmaregistraronlinecourse.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.UserData;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;
import com.phinmaregistraronlinecourse.other.CircularNetworkImageView;
import com.phinmaregistraronlinecourse.volley.AppController;

import org.w3c.dom.Text;

/**
 * Created by Manipon on 01/30/2018.
 */

public class Profile extends Fragment {

    UserData user;
    TextView txtName,txtID,txtUsername,txtEmail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        user = SharedPrefManager.getInstance(getContext()).getUser();

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtID = (TextView) view.findViewById(R.id.txtID);
        txtUsername = (TextView) view.findViewById(R.id.txtUsername);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        //Collapsing toolbar
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_container);
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.my_appbar_container);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    //collapsingToolbarLayout.setTitle(name);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle("");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        CircularNetworkImageView image = (CircularNetworkImageView) view.findViewById(R.id.image);
        ImageLoader netImageLoader= AppController.getInstance().getImageLoader();
        image.setImageUrl(Constants.IMAGE_URL+user.getImage(), netImageLoader);

        txtName.setText(user.getFirstname()+" "+user.getMiddlename()+" "+user.getLastname());
        txtID.setText(user.getEmp_id());
        txtUsername.setText(user.getUsername());
        txtEmail.setText(user.getEmail());
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles


    }

}
