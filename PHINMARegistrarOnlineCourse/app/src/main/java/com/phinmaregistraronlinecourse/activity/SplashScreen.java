package com.phinmaregistraronlinecourse.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.phinmaregistraronlinecourse.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView tx = (TextView)findViewById(R.id.txtCompanyName);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "helvetica.ttf");

        tx.setTypeface(custom_font);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,Login.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
