package com.phinmaregistraronlinecourse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.phinmaregistraronlinecourse.QuizResult;
import com.phinmaregistraronlinecourse.R;
import com.phinmaregistraronlinecourse.adapter.Module;
import com.phinmaregistraronlinecourse.adapter.QuizData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private ArrayList<QuizData> quizDataArrayList;
    TextView txtQuestion,txtQuestionHeader;
    RadioButton choice1,choice2,choice3,choice4;

    Button btnNext;


    private String answer;
    private int score = 0;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");

        txtQuestion =(TextView) findViewById(R.id.txtQuestion);
        txtQuestionHeader =(TextView) findViewById(R.id.txtQuestionHeader);

        choice1 =(RadioButton) findViewById(R.id.choice1);
        choice2 =(RadioButton) findViewById(R.id.choice2);
        choice3 =(RadioButton) findViewById(R.id.choice3);
        choice4 =(RadioButton) findViewById(R.id.choice4);


        btnNext =(Button) findViewById(R.id.btnNext);

        Bundle bundleObject = getIntent().getExtras();
        quizDataArrayList = (ArrayList<QuizData>) bundleObject.getSerializable("questions");

        updateQuestion();


    }



    private void updateQuestion(){

        if(questionNumber > (quizDataArrayList.size()-1)){

            checkAnswer();
            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("score",score);
            startActivity(intent);
            finish();

        }
        else{
            txtQuestionHeader.setText("Question "+ (questionNumber+1) + "/" + quizDataArrayList.size());
            QuizData quizData = quizDataArrayList.get(questionNumber);
            txtQuestion.setText(quizData.getQuestion());



            if(quizData.getChoose3().equals("") && quizData.getChoose4().equals("")){
                choice3.setVisibility(View.GONE);
                choice4.setVisibility(View.GONE);
                choice1.setText(quizData.getChoose1());
                choice2.setText(quizData.getChoose2());
            }
            else{
                choice3.setVisibility(View.VISIBLE);
                choice4.setVisibility(View.VISIBLE);
                choice1.setText(quizData.getChoose1());
                choice2.setText(quizData.getChoose2());
                choice3.setText(quizData.getChoose3());
                choice4.setText(quizData.getChoose4());

            }
            answer = quizData.getAnswer();
            checkAnswer();


        }

        questionNumber++;
    }

    public void checkAnswer(){
        if(choice1.isChecked())
        {
            if(choice1.getText().equals(answer)){
                score++;
            }
        }
        else if(choice2.isChecked())
        {
            if(choice2.getText().equals(answer)){
                score++;
            }
        }
        else if(choice3.isChecked())
        {
            if(choice3.getText().equals(answer)){
                score++;
            }
        }
        else if(choice4.isChecked())
        {
            if(choice4.getText().equals(answer)){
                score++;
            }
        }
        //Toast.makeText(QuizActivity.this,Integer.toString(score), Toast.LENGTH_SHORT).show();
    }

    public void GotoNext(View view){
        updateQuestion();

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

        }

        return super.onOptionsItemSelected(item);
    }
}
