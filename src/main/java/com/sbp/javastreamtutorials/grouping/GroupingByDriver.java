package com.sbp.javastreamtutorials.grouping;

import com.sbp.javastreamtutorials.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupingByDriver {
    private static final Logger Log = LoggerFactory.getLogger(GroupingByDriver.class);

    private static List<Employee> employees = null;
    public static void main(String[] args) {
        Log.info("TechnicalTutorials: GroupingByDriver");

        //Create List of Employee
        createEmployees();

        // 1) Do the groupingBy department
        // 2) In each department find the nth highest salary employee
        NthHighestSalaryInDepartment();

        // 1) Do the groupingBy department
        // 2) In each department find the nth highest salary employee particular attribute
        // 3) Get the name of that employee
        NthHighestSalaryEmpName();

        // 1) Do the groupingBy department
        // 2) In each department find the nth highest salary employee particular attribute
        // 3) Get the name and Salary of that employee
        NthHighestSalaryEmpNameAndSal();

    }

    private static void createEmployees(){
        employees = Arrays.asList(
                new Employee(1, 1, "emp1", 3000000.00f),
                new Employee(1, 2, "emp2", 4100000.00f),
                new Employee(1, 3, "emp3", 5100000.00f),
                new Employee(2, 4, "emp4", 6100000.00f),
                new Employee(2, 5, "emp5", 7100000.00f),
                new Employee(2, 6, "emp6", 8100000.00f),
                new Employee(3, 7, "emp7", 9100000.00f),
                new Employee(3, 8, "emp8", 10100000.00f),
                new Employee(3, 9, "emp9", 15100000.00f),
                new Employee(4, 10, "emp10", 20000000.00f),
                new Employee(4, 11, "emp11", 25000000.00f),
                new Employee(4, 12, "emp12", 30000000.00f),
                new Employee(5, 13, "emp13", 40000000.00f),
                new Employee(5, 14, "emp14", 50000000.00f),
                new Employee(5, 15, "emp15", 100000000.00f),
                new Employee(6, 16, "emp16", 110000000.00f),
                new Employee(6, 17, "emp17", 110000000.00f),
                new Employee(6, 18, "emp18", 900000000.00f)
        );
    }

    /*
    Find the Nth highest salary employee in each Department
    N=2;
     */
    private static void NthHighestSalaryInDepartment(){

        Map<Integer, Optional<Employee>> nthHighestSalaryEmployee = employees.stream()
                .collect(groupingBy(
                        Employee::getDepartmentId,
                        collectingAndThen(toList(),
                                list -> list.stream()
                                                .sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst()

                )));

        Log.info("1. 2nd highest salary employee in each department: "+ nthHighestSalaryEmployee);
    }

    /*
   Find the Nth highest salary employee name and salary in each Department
   N=2;
    */
    private static void NthHighestSalaryEmpName(){

        Map<Integer, String> nthHighestSalaryEmployee = employees.stream()
                .collect(groupingBy(
                        Employee::getDepartmentId,
                        collectingAndThen(toList(),
                                list -> {
                            Optional<Employee> emp = list.stream()
                                            .sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
                                return emp.isEmpty()? "No such employee" : emp.get().getName();
                                }
                        )));

        Log.info("2. 2nd highest salary employee details in each department: "+ nthHighestSalaryEmployee);
    }

    /*
   Find the Nth highest salary employee name and salary in each Department
   N=2;
    */
    private static void NthHighestSalaryEmpNameAndSal(){

        Map<Integer, String> nthHighestSalaryEmployee = employees.stream()
                .collect(groupingBy(
                        Employee::getDepartmentId,
                        collectingAndThen(toList(),
                                list -> {
                                    Optional<Employee> emp = list.stream()
                                            .sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
                                    return emp.isEmpty()? "No such employee" : emp.get().getName() + ": " + emp.get().getSalary();
                                }
                        )));

        Log.info("3. 2nd highest salary employee Name and Sal in each department: "+ nthHighestSalaryEmployee);
    }
}
