package com.phinmaregistraronlinecourse.connection;

import android.content.Context;
import android.content.SharedPreferences;

import com.phinmaregistraronlinecourse.adapter.QuizData;
import com.phinmaregistraronlinecourse.adapter.UserData;

/**
 * Created by Acer on 02/06/2018.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

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
    private static final String KEY_IMAGE= "image";
    private static final String KEY_MODULE1= "general_admission_policy";
    private static final String KEY_MODULE2= "student_enrollment";
    private static final String KEY_MODULE3= "enrollment_preparation";
    private static final String KEY_MODULE4= "grading";
    private static final String KEY_MODULE5= "graduation";
    private static final String KEY_MODULE6= "registrar_document_and_transaction_standard";
    private static final String KEY_MODULE7= "academic_and_non_academic_award_and_scholarship";
    private static final String KEY_MODULE= "moduleNumber";

    private static final String KEY_QUIZ_ID= "id";
    private static final String KEY_QUIZ_MODULE= "module";
    private static final String KEY_QUIZ_TYPE= "type";
    private static final String KEY_QUIZ_QUESTION= "question";
    private static final String KEY_QUIZ_CHOOSE1= "choose1";
    private static final String KEY_QUIZ_CHOOSE2= "choose2";
    private static final String KEY_QUIZ_CHOOSE3= "choose3";
    private static final String KEY_QUIZ_CHOOSE4= "choose4";
    private static final String KEY_QUIZ_ANSWER= "answer";

    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    //Store data from the user
    public void userLogin(UserData userData){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, userData.getId());
        editor.putString(KEY_EMP_ID, userData.getEmp_id());
        editor.putString(KEY_USER_FIRSTNAME, userData.getFirstname());;
        editor.putString(KEY_USER_MIDDLE_NAME, userData.getMiddlename());
        editor.putString(KEY_USER_LASTNAME, userData.getLastname());
        editor.putString(KEY_USER_EMAIL, userData.getEmail());
        editor.putString(KEY_USERNAME, userData.getUsername());
        editor.putString(KEY_PASSWORD, userData.getPassword());
        editor.putString(KEY_IMAGE, userData.getImage());
        editor.putString(KEY_MODULE1, userData.getModule1());
        editor.putString(KEY_MODULE2, userData.getModule2());
        editor.putString(KEY_MODULE3, userData.getModule3());
        editor.putString(KEY_MODULE4, userData.getModule4());
        editor.putString(KEY_MODULE5, userData.getModule5());
        editor.putString(KEY_MODULE6, userData.getModule6());
        editor.putString(KEY_MODULE7, userData.getModule7());

        editor.commit();

    }

    public void quizData(QuizData quizData){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_QUIZ_ID, quizData.getId());
        editor.putString(KEY_QUIZ_MODULE, quizData.getModule());
        editor.putString(KEY_QUIZ_TYPE, quizData.getType());
        editor.putString(KEY_QUIZ_QUESTION, quizData.getQuestion());
        editor.putString(KEY_QUIZ_CHOOSE1, quizData.getChoose1());
        editor.putString(KEY_QUIZ_CHOOSE2, quizData.getChoose2());
        editor.putString(KEY_QUIZ_CHOOSE3, quizData.getChoose3());
        editor.putString(KEY_QUIZ_CHOOSE4, quizData.getChoose4());
        editor.putString(KEY_QUIZ_ANSWER, quizData.getAnswer());

        editor.commit();

    }

    // Get data from the user
    public UserData getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserData(
                sharedPreferences.getInt(KEY_USER_ID, -1),
                sharedPreferences.getString(KEY_EMP_ID, null),
                sharedPreferences.getString(KEY_USER_FIRSTNAME, null),
                sharedPreferences.getString(KEY_USER_MIDDLE_NAME, null),
                sharedPreferences.getString(KEY_USER_LASTNAME, null),
                sharedPreferences.getString(KEY_USER_EMAIL, null),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_PASSWORD, null),
                sharedPreferences.getString(KEY_IMAGE, null),
                sharedPreferences.getString(KEY_MODULE1, null),
                sharedPreferences.getString(KEY_MODULE2, null),
                sharedPreferences.getString(KEY_MODULE3, null),
                sharedPreferences.getString(KEY_MODULE4, null),
                sharedPreferences.getString(KEY_MODULE5, null),
                sharedPreferences.getString(KEY_MODULE6, null),
                sharedPreferences.getString(KEY_MODULE7, null)
        );
    }

    public QuizData getQuizData() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new QuizData(
                sharedPreferences.getInt(KEY_QUIZ_ID, -1),
                sharedPreferences.getString(KEY_QUIZ_MODULE, null),
                sharedPreferences.getString(KEY_QUIZ_TYPE, null),
                sharedPreferences.getString(KEY_QUIZ_QUESTION, null),
                sharedPreferences.getString(KEY_QUIZ_CHOOSE1, null),
                sharedPreferences.getString(KEY_QUIZ_CHOOSE2, null),
                sharedPreferences.getString(KEY_QUIZ_CHOOSE3, null),
                sharedPreferences.getString(KEY_QUIZ_CHOOSE4, null),
                sharedPreferences.getString(KEY_QUIZ_ANSWER, null)
        );
    }


    public boolean checkEmail(int id,  String firstname, String lastname, String email){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_FIRSTNAME, firstname);
        editor.putString(KEY_USER_LASTNAME, lastname);
        editor.putString(KEY_USER_EMAIL, email);
        editor.apply();

        return true;
    }

    public boolean checkCode(int id,String firstname, String lastname, String email, String username, String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
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


    //check if the user is already login
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) != null){
            return true;
        }
        return false;
    }

    //Call this function to the activity to logout
    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public boolean setNumberOfModule(int number){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_MODULE, number);

        editor.apply();

        return true;
    }

    public int getNumberOfModule(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_MODULE, -1);
    }


}


