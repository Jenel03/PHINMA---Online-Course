package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 01/31/2018.
 */

public class Module {
    int id;
    private String name;
    private int numOfLectures;
    private int thumbnail;

    public Module() {
    }

    public Module(int id, String name, int numOfLectures, int thumbnail) {
        this.id = id;
        this.name = name;
        this.numOfLectures = numOfLectures;
        this.thumbnail = thumbnail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
