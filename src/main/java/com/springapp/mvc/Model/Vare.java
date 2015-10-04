package com.springapp.mvc.Model;

import com.sun.javafx.beans.IDProperty;

/**
 * Created by benny on 29.09.15.
 */


public class Vare {

private int id;
    private String navn;
    private int pris;


    public Vare(){

    }

    public Vare(int id, String navn, int pris) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
