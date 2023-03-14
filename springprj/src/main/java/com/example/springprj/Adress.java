package com.example.springprj;

import lombok.Data;


public class Adress {
    private String streetName;
    private int nr;

    public Adress() {
    }

    public Adress(String streetName, int nr) {
        this.streetName = streetName;
        this.nr = nr;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}
