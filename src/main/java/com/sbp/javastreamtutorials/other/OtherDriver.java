package com.sbp.javastreamtutorials.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class OtherDriver {

    private static final Logger Log = LoggerFactory.getLogger(OtherDriver.class);

    public static void main(String[] args){

        //printFileNameRecursivelyInDirectory();
//        variableOverride();
//        methodOverride();

        failSafeExample();
    }

    private static void printFileNameRecursivelyInDirectory(){
        FileNamePrinter fileNamePrinter = new FileNamePrinter();
    }

    private static void variableOverride(){
        Parent child = new Child();
        //What is the output? Does the variable Overrided?
        //Answer: Variable override is not happened in java. So, its refer the parent variable,
        // which resolve at compile time.
        Log.info("1. var: child.speed: " + child.speed);
    }

    private static void methodOverride(){
        Parent child = new Child();
        //What is the output? Does the method Overrided?
        //Answer: Yes, getSpeed() resolve at runtime, and use that object variable.
        child.getSpeed();
    }

    private static void failSafeExample(){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Create an iterator
        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();

            //Modified map after iterator creation is printed.
            System.out.println(key);

            // Simulate concurrent modification (no exception thrown)
            if (key == 2) {
                map.put(4, "Four");
            }
        }
    }

}
