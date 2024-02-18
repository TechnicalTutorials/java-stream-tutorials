package com.sbp.javastreamtutorials.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent {
    private static final Logger Log = LoggerFactory.getLogger(Parent.class);
    int speed = 100;

    public void getSpeed(){
        Log.info("Parent: speed: " + this.speed);
    }
}
