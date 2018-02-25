package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 02/25/2018.
 */

public class QuizData {
    private int id;
    private String module, type, question,choose1,choose2,choose3,choose4,answer;

    public QuizData(){

    }

    public QuizData(int id, String module, String type,String question, String choose1, String choose2,String choose3,String choose4 ,String answer) {
        this.id = id;
        this.module = module;
        this.type = type;
        this.question = question;
        this.choose1 = choose1;
        this.choose2 = choose2;
        this.choose3 = choose3;
        this.choose4 = choose4;
        this.answer = answer;

    }

    public int getId() {
        return id;
    }

    public String getModule() {
        return module;
    }

    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }
    public String getChoose1() {
        return choose1;
    }
    public String getChoose2() {
        return choose2;
    }
    public String getChoose3() {
        return choose3;
    }
    public String getChoose4() {
        return choose4;
    }
    public String getAnswer() {
        return answer;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setChoose1(String choose1) {
        this.choose1 = choose1;
    }
    public void setChoose2(String choose2) {
        this.choose2 = choose2;
    }
    public void setChoose3(String choose3) {
        this.choose3 = choose3;
    }
    public void setChoose4(String choose4) {
        this.choose4 = choose4;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
