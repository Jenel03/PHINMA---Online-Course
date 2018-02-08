package com.phinmaregistraronlinecourse.moduleFive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.phinmaregistraronlinecourse.R;

public class ModuleFiveSub1 extends AppCompatActivity {
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_five_sub1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        title = i.getStringExtra("title");

        setTitle(title);
        String htmlAsString = getString(R.string.ModuleFiveSub1);

        WebView webView = (WebView) findViewById(R.id.webView);

        loadData(webView,htmlAsString);



    }

    public void loadData(WebView webView,String htmlAsString){
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        final WebSettings webSettings = webView.getSettings();
        // Set the font size (in sp).
        webSettings.setDefaultFontSize(14);
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
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
