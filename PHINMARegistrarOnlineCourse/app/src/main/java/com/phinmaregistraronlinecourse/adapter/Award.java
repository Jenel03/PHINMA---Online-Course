package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 02/09/2018.
 */

public class Award {

    private String name;
    private int trophy;


    public Award() {
    }

    public Award(String name,int trophy) {
        this.name = name;
        this.trophy = trophy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrophy() {
        return trophy;
    }

    public void setTrophy(int trophy) {
        this.trophy = trophy;
    }


}
