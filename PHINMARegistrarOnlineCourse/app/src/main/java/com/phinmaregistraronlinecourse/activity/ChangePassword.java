package com.phinmaregistraronlinecourse.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.UserData;
import com.phinmaregistraronlinecourse.connection.ChangePasswordHandler;
import com.phinmaregistraronlinecourse.connection.Constants;
import com.phinmaregistraronlinecourse.connection.SharedPrefManager;

import java.util.HashMap;

public class ChangePassword extends AppCompatActivity {

    private Button send;
    private EditText newPass,confirmNew;
    UserData user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        newPass = (EditText)findViewById(R.id.txtNewPass);
        confirmNew = (EditText)findViewById(R.id.txtConfirmPass);
        send = (Button)findViewById(R.id.btnUpdate);

        user = SharedPrefManager.getInstance(this).getUser();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a =  "" + user.getId();
                if (newPass.getText().toString().isEmpty() && confirmNew.getText().toString().isEmpty()) {

                } else {
                    if (newPass.getText().toString().equals(confirmNew.getText().toString())) {
                        updatePassword();
                        //SharedPrefManager.getInstance(Profile.this).logout();
                        Intent start = new Intent(getApplicationContext(), Login.class);
                        start.putExtra("pass", a);
                        startActivity(start);
                        finish();
                    } else {
                        newPass.setError("Password dont match");
                        newPass.requestFocus();
                        newPass.setText("");
                        confirmNew.setText("");
                    }

                }




            }
        });


    }

    private void updatePassword() {
        user = SharedPrefManager.getInstance(this).getUser();
        final String id = String.valueOf(user.getId());
        final String password = newPass.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ChangePassword.this, "Updating...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //Toast.makeText(Profile.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Constants.KEY_EMP_ID, id);
                hashMap.put(Constants.KEY_EMP_PASSWORD, password);

                ChangePasswordHandler changePasswordHandler = new ChangePasswordHandler();

                String request = changePasswordHandler.sendPostRequest(Constants.URL_UPDATE_PASSWORD, hashMap);

                return request;
                // RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }
}
