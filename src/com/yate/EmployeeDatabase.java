package com.yate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDatabase {


    public static List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            employees.add(new Employee(i, "employee" + i, "A", Double.valueOf(new Random().nextInt(1000 * 100))));
        }
        return employees;
    }
}
