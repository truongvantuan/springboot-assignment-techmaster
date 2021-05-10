package com.company.tividependencyinjection.beans;

public class Os {

    private String name;

    public Os(String name) {
        this.name = name;
    }

    public String getOs() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
