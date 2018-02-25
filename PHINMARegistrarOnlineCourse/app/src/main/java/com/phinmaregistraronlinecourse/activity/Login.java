package com.phinmaregistraronlinecourse.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.UserData;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.RequestHandler;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {


    private EditText txtPassword, txtUsername;
    private Button btnLogin;
    private TextView txtforgotPassword;
    private ProgressDialog progressDialog;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtforgotPassword = (TextView)findViewById(R.id.forgotPassword);

        txtforgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(getApplicationContext(), ForgotPassword.class));


            }
        });

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging In...");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view == btnLogin){
                    if( txtUsername.getText().toString().trim().equals("")){
                        txtUsername.setError( "Username is required!" );
                        txtUsername.requestFocus();
                    }else if (txtPassword.getText().toString().trim().equals("")){
                        txtPassword.setError( "Password is required!" );
                        txtPassword.requestFocus();
                    }
                    else{
                        userLogin();
                    }

                }
            }
        });


    }


    private void userLogin(){
        final String username = txtUsername.getText().toString().trim();
        final String password = txtPassword.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,

                Constants.URL_LOGIN,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
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
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                //starting the profile activity
                                Intent start = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(start);
                                finish();
                                
                            }else{

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
                params.put("username", username);
                params.put("password", password);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


}
