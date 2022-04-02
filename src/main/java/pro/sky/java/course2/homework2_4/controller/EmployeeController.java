package pro.sky.java.course2.homework2_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        try {
            employeeService.addEmployee(firstName, lastName);
        } catch (InternalServerError e) {
            System.out.println("Штат полностью укомплектован.");
        } catch (BadRequest e) {
            System.out.println("Такой сотрудник уже есть.");
        }
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.dismissEmployee(firstName, lastName);
        } catch (NotFound e) {
            System.out.println("Такой сотрудник не найден.");
        }
        return employeeService.dismissEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public String findStaff(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.findEmloyee(firstName, lastName);
        } catch (BadRequest e) {
            System.out.println("Такой сотрудник не найден.");
        }
        return employeeService.findEmloyee(firstName, lastName);
    }
}
