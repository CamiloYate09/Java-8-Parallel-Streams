package com.yate;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        long start = 0;
        long end = 0;


        /**
         * Primer Testing
         */
        start = System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Plain  stream  took time :" +(end-start));

        System.out.println("****************************************");


        start = System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Parallel  stream  took time :" +(end-start));

        /**
         * Segundo Testing
         */

        IntStream.range(1, 10).forEach(x ->
        {
            System.out.println("Thead : " + Thread.currentThread().getName() + " : " + x);
        });

        System.out.println("****************************************");

        IntStream.range(1, 10).parallel().forEach(x ->
        {
            System.out.println("Thead : " + Thread.currentThread().getName() + " : " + x);
        });

        /**
         * Tercer Testing
         */

        List<Employee> employeeList = EmployeeDatabase.getEmployee();
        //Normal
        start = System.currentTimeMillis();
        double salaryWithStream = employeeList.stream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Normal  stream  execution time : " + (end - start) + " + Avg salary : " + salaryWithStream);

        System.out.println("*******************************************************");

        start = System.currentTimeMillis();
        double salaryWithParallelStream = employeeList.parallelStream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Parallel  stream  execution time : " + (end - start) + " + Avg salary : " + salaryWithParallelStream);


    }
}
