package com.phinmaregistraronlinecourse.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.RequestHandler;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgotPassword extends AppCompatActivity {

    public void onBackPressed() {
        finish();
    }

    private EditText editTextEmail;
    private Button buttonSubmit;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


        editTextEmail = (EditText) findViewById(R.id.email);
        buttonSubmit = (Button)findViewById(R.id.btnSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == buttonSubmit){
                    if( editTextEmail.getText().toString().trim().equals("")){
                        editTextEmail.setError( "Email is required!" );
                        editTextEmail.requestFocus();
                    }
                    else{
                        checkEmail();
                    }

                }
            }
        });

    }
    private void checkEmail(){
        final String email = editTextEmail.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_VERIFICATION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .checkEmail(
                                                obj.getInt("id"),
                                                obj.getString("firstname"),
                                                obj.getString("lastname"),
                                                obj.getString("email")


                                        );

                                Intent start = new Intent(ForgotPassword.this,VerificationCode.class);
                                start.putExtra("pass",email);
                                startActivity(start);
                                finish();
                            }else{
                                editTextEmail.setError( "Invalid Email" );
                                editTextEmail.requestFocus();
                                Toast.makeText(
                                        getApplicationContext(),
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
                        progressDialog.dismiss();
                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


}
