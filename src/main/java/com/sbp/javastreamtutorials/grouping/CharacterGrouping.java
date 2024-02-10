package com.sbp.javastreamtutorials.grouping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterGrouping {

    private final Logger Log = LoggerFactory.getLogger(CharacterGrouping.class);

    /*
    Problem statement: Find first non-repeating char in string.
    1) Detect te repeatation of character
    2) Order
    3) Input String: abcaebcfg
    */
    public void findTheFirstNonRepeatingChar(String inputStr) {

        findTheFirstNonRepeatingCharApproach1(inputStr);
        findTheFirstNonRepeatingCharApproach2(inputStr);
        findTheFirstNonRepeatingCharApproach3(inputStr);
        findTheFirstNonRepeatingCharApproach4(inputStr);
    }

    private void findTheFirstNonRepeatingCharApproach1(String inputStr){
        String output = Arrays.stream(inputStr.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .findFirst()
                .map(x-> ""+x.getKey())
                .orElse("No character found");

        Log.info("Approach1: First Non Repeated Character in " + inputStr + " is: " + output);
    }

    private void findTheFirstNonRepeatingCharApproach2(String inputStr){
//        String output = inputStr.chars() //intStream
//                .mapToObj(x->Character.valueOf((char)x)) //Converted intSteam to Character Stream.
//                .map(x->Character.toLowerCase(x)) // Converted to lower case.
        String output = Arrays.stream(inputStr.split(""))
            .collect(Collectors.groupingBy(x-> x, LinkedHashMap::new, Collectors.counting() ))
            .entrySet().stream().filter(e -> e.getValue() == 1)
            .findFirst()
            .map(x->""+x.getKey())
            .orElse("No character found");

        Log.info("Approach2: First Non Repeated Character in " + inputStr + " is: " + output);
    }

    private void findTheFirstNonRepeatingCharApproach3(String inputStr){
        LinkedHashMap<String, Long> linkedHashMap = Arrays.stream(inputStr.split(""))
                .collect(Collectors.groupingBy(x-> x, LinkedHashMap::new, Collectors.counting()));

        String output = linkedHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(x-> "" + x.getKey())
                .orElse("No character found");
        Log.info("Approach3: First Non Repeated Character in " + inputStr + " is: " + output);
    }

    private void findTheFirstNonRepeatingCharApproach4(String inputStr){
        LinkedHashMap<String, Long> linkedHashMap = Arrays.stream(inputStr.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        String ch = linkedHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(x->""+x.getKey())
                .orElse("No character found");

        Log.info("Approach4: First Non Repeated Character in " + inputStr + " is: " + ch);
    }
}