package com.sbp.javastreamtutorials.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Child extends Parent{

    private static final Logger Log = LoggerFactory.getLogger(Parent.class);

    int speed = 150;

    @Override
    public void getSpeed(){
        Log.info("1. Child: speed: " + speed);
        Log.info("2. Child: speed: " + this.speed);
    }
}
