package pro.sky.java.course2.homework2_4.service;

import pro.sky.java.course2.homework2_4.Employee;

public interface EmployeeService {
    public String addEmployee (String firstName, String lastName);
    public String dismissEmployee (String firstName, String lastName);
    public String findEmloyee (String firstName, String lastName);
}
