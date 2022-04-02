package pro.sky.java.course2.homework2_4.service;

import pro.sky.java.course2.homework2_4.Employee;

public interface EmployeeService {
    public Employee addEmployee (String firstName, String lastName);
    public Employee dismissEmployee (String firstName, String lastName);
    public Employee findEmloyee (String firstName, String lastName);
}
