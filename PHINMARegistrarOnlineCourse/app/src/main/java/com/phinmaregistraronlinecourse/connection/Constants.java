 package com.phinmaregistraronlinecourse.connection;

/**
 * Created by Acer on 02/06/2018.
 */

public class Constants {

    private static final String ROOT_URL = "http://192.168.1.224/Phinma/Android/v1/";
    public static final String URL_LOGIN = ROOT_URL+"userLogin.php";
    public static final String URL_VERIFICATION = ROOT_URL+"verification.php";
    public static final String URL_VERIFICATION_CODE = ROOT_URL+"checkCode.php";
    public static final String URL_UPDATE_PASSWORD = ROOT_URL+"updatePassword.php";
    public static final String URL_QUIZ = ROOT_URL+"question.php";
    public static final String URL_QUESTION_COUNT = ROOT_URL+"count_questions.php";

    public static final String IMAGE_URL = "http://192.168.1.224/RegistrarOnlineCourse/others/";

    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_LASTNAME = "lastname";
    public static final String KEY_EMP_FIRSTNAME = "firstname";
    public static final String KEY_EMP_USERNAME = "username";
    public static final String KEY_EMP_PASSWORD = "password";
    public static final String KEY_EMP_CODE = "code";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_DATE = "date";
    public static final String TAG_AMOUNT = "amount";


}
