package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 02/09/2018.
 */

public class Achievement {
    private String title;
    private int progress;


    public Achievement() {
    }

    public Achievement(String title,int progress) {
        this.title = title;
        this.progress = progress;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }


}
