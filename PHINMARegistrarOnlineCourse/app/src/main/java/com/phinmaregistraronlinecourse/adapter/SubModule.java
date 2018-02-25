package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 02/01/2018.
 */

public class SubModule {

    private String title;
    private int id;
    private int image;

    public SubModule() {
    }

    public SubModule(int id,String title,int image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage () {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
