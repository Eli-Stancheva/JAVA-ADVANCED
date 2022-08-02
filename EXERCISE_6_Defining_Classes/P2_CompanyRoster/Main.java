package ADVANCED.EXERCISE_6_Defining_Classes.P2_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Employee>> departmentsMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split(" ");

            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];

            Employee employee = null;

            if (employeeInfo.length == 6) {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (employeeInfo.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (employeeInfo.length == 5) {
                String forthParameter = employeeInfo[4];
                if (forthParameter.contains("@")) {
                    String email = forthParameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(forthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            }

            departmentsMap.putIfAbsent(department, new ArrayList<>());
            departmentsMap.get(department).add(employee);
        }

        String maxAvgSalaryDepartment = departmentsMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(e -> getAvgSalary(e.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s\n", maxAvgSalaryDepartment);

        List<Employee> employeeList = departmentsMap.get(maxAvgSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    private static double getAvgSalary(List<Employee> value) {
        double sum = 0;
        for (Employee employee : value) {
            sum += employee.getSalary();
        }
        return sum / value.size();
    }
}
