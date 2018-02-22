package com.phinmaregistraronlinecourse.connection;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Acer on 02/06/2018.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context ctx;

    private static final String SHARED_PREF_NAME = "sharedpref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_ID = "userid";
    private static final String KEY_USER_FIRSTNAME = "firstname";
    private static final String KEY_USER_LASTNAME = "lastname";
    private static final String KEY_USER_MIDDLE_NAME = "middlename";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USER_EMAIL= "email";
    private static final String KEY_USER_CODE= "code";
    private static final String KEY_EMP_ID= "emp_id";



    private SharedPrefManager(Context context) {
        ctx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id, String firstname, String middlename, String lastname, String email, String username, String emp_id){

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_FIRSTNAME, firstname);;
        editor.putString(KEY_USER_MIDDLE_NAME, middlename);
        editor.putString(KEY_USER_LASTNAME, lastname);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMP_ID, emp_id);
        editor.apply();

        return true;
    }
    public boolean checkEmail(int id,  String firstname, String lastname, String email){

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_FIRSTNAME, firstname);
        editor.putString(KEY_USER_LASTNAME, lastname);
        editor.putString(KEY_USER_EMAIL, email);
        editor.apply();

        return true;
    }

    public boolean checkCode(int id,String firstname, String lastname, String email, String username, String code){

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_CODE, code);
        editor.putString(KEY_USER_FIRSTNAME, firstname);
        editor.putString(KEY_USER_LASTNAME, lastname);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USERNAME, code);
        editor.apply();

        return true;
    }

    public boolean userRefresh(int id, String username, String firstname, String lastname){

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USER_FIRSTNAME, firstname);
        editor.putString(KEY_USER_LASTNAME, lastname);

        editor.apply();

        return true;
    }

    //check if the user is already login
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) != null){
            return true;
        }
        return false;
    }

    //Call this function to the activity to logout
    public boolean logout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    // Get data from the user
    public String getUsername(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null);
    }
    public String getPassword(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASSWORD, null);
    }
    public Integer getId(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_USER_ID, 0);
    }
    public String getEmpid(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMP_ID, null);
    }
    public String getFirstname(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_FIRSTNAME, null);
    }
    public String getMiddlename(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_MIDDLE_NAME, null);
    }
    public String getLastname(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_LASTNAME, null);
    }
    public String getEmail(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }
    public String getCode(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_CODE, null);
    }
}


