package com.phinmaregistraronlinecourse.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.QuizData;
import com.phinmaregistraronlinecourse.adapter.UserData;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.RequestHandler;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;
import com.phinmaregistraronlinecourse.volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizConfirmation extends AppCompatActivity {

    TextView txtHeader;
    private ProgressDialog progressDialog;
    private static final String TAG = QuizConfirmation.class.getSimpleName();
    private List<QuizData> quizDataList;
    int number;
    String module;

    Button btnQuiz,btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_confirmation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Quiz");

        txtHeader = (TextView) findViewById(R.id.lblQuizHeader);
        progressDialog = new ProgressDialog(this);
        quizDataList = new ArrayList<>();
        btnQuiz = (Button) findViewById(R.id.btnQuiz);
        btnSkip = (Button) findViewById(R.id.btnSkip);

        number = SharedPrefManager.getInstance(getApplicationContext()).getNumberOfModule();

        txtHeader.setText("Module " + number + " | _ Questions");
        makeJsonArrayRequest();

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QuizActivity.class);
                startActivity(intent);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void makeJsonArrayRequest() {

        if(number==1){
            module = "General Admission Policy";
        }
        else if (number==2){
            module = "Student Enrollment";
        }
        else if (number==3){
            module = "Enrollment Preparations";
        }
        else if (number==4){
            module = "Grading";
        }
        else if (number==5){
            module = "Graduation";
        }
        else if (number==6){
            module = "Registrars Documents and Transactions Standards";
        }
        else if (number==7){
            module = "Academic and Non-Academic Awards and Scholarships";
        }

        StringRequest quizReq = new StringRequest(Request.Method.POST, Constants.URL_QUIZ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {

                                try {

                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    QuizData quizData = new QuizData();


                                    quizData.setId(obj.getInt("id"));
                                    quizData.setModule(obj.getString("module"));
                                    quizData.setType(obj.getString("type"));
                                    quizData.setQuestion(obj.getString("question"));
                                    quizData.setChoose1(obj.getString("choose1"));
                                    quizData.setChoose2(obj.getString("choose2"));
                                    quizData.setChoose3(obj.getString("choose3"));
                                    quizData.setChoose4(obj.getString("choose4"));
                                    quizData.setAnswer(obj.getString("answer"));



                                    quizDataList.add(quizData);
                                    // do something



                                } catch (JSONException e) {

                                    e.printStackTrace();

                                }


                            }

                            int listSize = quizDataList.size();

                            for (int j = 0; j<listSize; j++){
                                Toast.makeText(getApplicationContext(),quizDataList.get(j).getAnswer().toString(),Toast.LENGTH_LONG).show();
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
        AppController.getInstance().

                addToRequestQueue(quizReq);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == android.R.id.home) {

            onBackPressed();

        }

        return super.onOptionsItemSelected(item);
    }
}
