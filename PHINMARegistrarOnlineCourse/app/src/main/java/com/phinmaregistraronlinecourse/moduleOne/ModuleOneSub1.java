package com.phinmaregistraronlinecourse.moduleOne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.phinmaregistraronlinecourse.R;

public class ModuleOneSub1 extends AppCompatActivity {
    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_one_sub1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        title = i.getStringExtra("title");

        setTitle(title);

        String htmlAsString = getString(R.string.ModuleOneSub1);
        String htmlAsString2 = getString(R.string.ModuleOneSub1_1);
        String htmlAsString3 = getString(R.string.ModuleOneSub1_2);
        String htmlAsString4 = getString(R.string.ModuleOneSub1_3);
        String htmlAsString5 = getString(R.string.ModuleOneSub1_4);

        WebView webView = (WebView) findViewById(R.id.webView);
        WebView webView2 = (WebView) findViewById(R.id.webView2);
        WebView webView3 = (WebView) findViewById(R.id.webView3);
        WebView webView4 = (WebView) findViewById(R.id.webView4);
        WebView webView5 = (WebView) findViewById(R.id.webView5);

        loadData(webView,htmlAsString);
        loadData(webView2,htmlAsString2);
        loadData(webView3,htmlAsString3);
        loadData(webView4,htmlAsString4);
        loadData(webView5,htmlAsString5);



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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
