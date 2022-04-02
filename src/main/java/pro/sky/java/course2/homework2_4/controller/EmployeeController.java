package pro.sky.java.course2.homework2_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework2_4.Employee;
import pro.sky.java.course2.homework2_4.service.BadRequest;
import pro.sky.java.course2.homework2_4.service.EmployeeService;
import pro.sky.java.course2.homework2_4.service.InternalServerError;
import pro.sky.java.course2.homework2_4.service.NotFound;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addNewEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee newEmployee = employeeService.addEmployee(firstName, lastName);
        return newEmployee.getLastName() + " " + newEmployee.getFirstName() + " is hired.";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee disMissedEmployee = employeeService.dismissEmployee(firstName, lastName);
        return disMissedEmployee.getLastName() + " " + disMissedEmployee.getFirstName() + " is dismissed.";
    }

    @GetMapping("/find")
    public String findStaff(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.findEmloyee(firstName, lastName);
        return employee.getLastName() + " " + employee.getFirstName() + " is found.";
    }
}
