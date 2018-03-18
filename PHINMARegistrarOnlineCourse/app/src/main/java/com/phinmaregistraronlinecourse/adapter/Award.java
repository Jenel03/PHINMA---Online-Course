package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 02/09/2018.
 */

public class Award {
    private String profile;
    private String name;
    private String score;


    public Award() {
    }

    public Award(String profile,String name,String score) {
        this.profile = profile;
        this.name = name;
        this.score = score;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


}
