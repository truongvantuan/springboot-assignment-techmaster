package com.company.tividependencyinjection.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Tivi {

    @Autowired
    @Qualifier(value = "oledPanel")
    private Panel panel;

    private Os os;

    public Tivi(Os os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Tivi [panel = " + panel + ", os = " + os + "]";
    }
}
