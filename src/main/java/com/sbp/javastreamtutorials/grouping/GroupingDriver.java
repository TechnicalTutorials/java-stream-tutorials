package com.sbp.javastreamtutorials.grouping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupingDriver {

    private static final Logger Log = LoggerFactory.getLogger(GroupingDriver.class);

    public static void main(String[] args) {
        Log.info("TechnicalTutorials: GroupingDriver");

        employeeGrouping();

        characterGrouping();
    }

    /*
    Employee grouping
     */
    private static void employeeGrouping(){
        EmployeeGrouping employeeGrouping = new EmployeeGrouping();

        employeeGrouping.NthHighestSalaryInDepartment();
        employeeGrouping.NthHighestSalaryEmpName();
        employeeGrouping.NthHighestSalaryEmpNameAndSal();
    }

    private static void characterGrouping(){
        CharacterGrouping characterGrouping = new CharacterGrouping();

        characterGrouping.findTheFirstNonRepeatingChar("abcabc");
        characterGrouping.findTheFirstNonRepeatingChar("abcdabc");
        characterGrouping.findTheFirstNonRepeatingChar("abcabcfgf");
        characterGrouping.findTheFirstNonRepeatingChar("");
        characterGrouping.findTheFirstNonRepeatingChar(" ");
        characterGrouping.findTheFirstNonRepeatingChar("1231");
        characterGrouping.findTheFirstNonRepeatingChar("a1231");
    }
}
