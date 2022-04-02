package pro.sky.java.course2.homework2_4.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework2_4.Employee;

@Service
public class EmloyeeServiceImpl implements EmployeeService {
    private Employee[] staffOfEmployee = new Employee[3];
    private int sizeOfStaff;

    public void EmployeeServiceImpl() {
        this.staffOfEmployee = new Employee[3];
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (sizeOfStaff >= staffOfEmployee.length) {
            throw new InternalServerError();
        }
        Employee newEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < staffOfEmployee.length; i++) {
            if (staffOfEmployee[i] != null) {
                if (newEmployee.getFirstName().equals(staffOfEmployee[i].getFirstName()) && newEmployee.getLastName().equals(staffOfEmployee[i].getLastName())) {
                    throw new BadRequest();
                }
            }
        }
        for (int i = 0; i < staffOfEmployee.length; i++) {
            if (staffOfEmployee[i] == null) {
                staffOfEmployee[i] = newEmployee;
                sizeOfStaff++;
                return newEmployee;
            }
        }
        return null;
    }

    @Override
    public Employee dismissEmployee(String firstName, String lastName) {
        Employee dismissedEmployee = new Employee(firstName, lastName);
        for (int j = 0; j < staffOfEmployee.length; j++) {
            dismissedEmployee = staffOfEmployee[j];
            if (staffOfEmployee[j] != null) {
                if (dismissedEmployee.getFirstName().equals(firstName) && dismissedEmployee.getLastName().equals(lastName)) {
                    staffOfEmployee[j] = null;
                    sizeOfStaff--;
                    return dismissedEmployee;
                } else {
                    dismissedEmployee = null;
                }
            }
        }
        if (dismissedEmployee == null) {
            throw new NotFound();
        }
        return null;
    }

    @Override
    public Employee findEmloyee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < staffOfEmployee.length; i++) {
            if (staffOfEmployee[i] != null) {
                employee = staffOfEmployee[i];
                if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                    return employee;
                } else {
                    employee = null;
                }
            }
        }
        if (employee == null) {
            throw new BadRequest();
        }
        return null;
    }
}
