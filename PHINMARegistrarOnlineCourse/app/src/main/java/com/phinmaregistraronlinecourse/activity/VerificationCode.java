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

public class VerificationCode extends AppCompatActivity {
    private EditText codes;
    private Button verify;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


        codes = (EditText) findViewById(R.id.verficationCode);
        verify = (Button)findViewById(R.id.btnVerify);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == verify){
                    if( codes.getText().toString().trim().equals("")){
                        codes.setError( "Email is required!" );
                        codes.requestFocus();
                    }
                    else{
                        checkEmail();
                    }

                }
            }
        });

    }
    private void checkEmail(){
        final String code = codes.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_VERIFICATION_CODE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .checkCode(
                                                obj.getInt("id"),
                                                obj.getString("firstname"),
                                                obj.getString("lastname"),
                                                obj.getString("email"),
                                                obj.getString("username"),
                                                obj.getString("code")


                                        );
                                SharedPrefManager.getInstance(VerificationCode.this).logout();

                                Intent start = new Intent(VerificationCode.this,ChangePassword.class);
                                start.putExtra("pass",code);
                                startActivity(start);
                                finish();
                            }else{
                                codes.setError( "Invalid Code" );
                                codes.requestFocus();
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
                params.put("code", code);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


}
