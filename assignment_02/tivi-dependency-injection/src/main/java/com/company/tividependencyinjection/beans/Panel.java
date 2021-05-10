package com.company.tividependencyinjection.beans;

public class Panel {

    private String type;

    public Panel(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
