package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 01/31/2018.
 */

public class Module {
    private String name;
    private int numOfLectures;
    private int thumbnail;

    public Module() {
    }

    public Module(String name, int numOfLectures, int thumbnail) {
        this.name = name;
        this.numOfLectures = numOfLectures;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfLectures() {
        return numOfLectures;
    }

    public void setNumOfLectures(int numOfLectures) {
        this.numOfLectures = numOfLectures;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
