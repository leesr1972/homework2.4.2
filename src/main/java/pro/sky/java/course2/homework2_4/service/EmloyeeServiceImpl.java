package pro.sky.java.course2.homework2_4.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework2_4.Employee;

@Service
public class EmloyeeServiceImpl implements EmployeeService {
    private Employee[] staffOfEmployee;
    private int sizeOfStaff;

    public void EmployeeService() {
        this.staffOfEmployee = new Employee[3];
    }

    @Override
    public String addEmployee(String firstName, String lastName) throws InternalServerError, BadRequest {
        if (sizeOfStaff >= staffOfEmployee.length) {
            throw new InternalServerError();
        }
        Employee newEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < staffOfEmployee.length; i++) {
            if (newEmployee.getFirstName().equals(staffOfEmployee[i].getFirstName()) && newEmployee.getLastName().equals(staffOfEmployee[i].getLastName())) {
                throw new BadRequest();
            }
        }
        for (int i = 0; i < staffOfEmployee.length; i++) {
            if (staffOfEmployee[i] == null) {
            staffOfEmployee[i] = newEmployee;
            sizeOfStaff++;
            return firstName + " " + lastName + "is hired.";
            }
        }
        return newEmployee.toString();
    }

    @Override
    public String dismissEmployee(String firstName, String lastName) throws NotFound{
        Employee dismissedEmployee = new Employee(firstName, lastName);
        for (int j = 0; j < staffOfEmployee.length; j++) {
            dismissedEmployee = staffOfEmployee[j];
            if (dismissedEmployee.getFirstName().equals(firstName) && dismissedEmployee.getLastName().equals(lastName)) {
                staffOfEmployee[j] = null;
                sizeOfStaff--;
                return firstName + " " + lastName + "is dismissed.";
            }
        }
        if (findEmloyee(firstName, lastName) == null) {
            throw new NotFound();
        }
        return dismissedEmployee.toString();
    }

    @Override
    public String findEmloyee(String firstName, String lastName) throws BadRequest{
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < staffOfEmployee.length; i++) {
            employee = staffOfEmployee[i];
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return firstName + " " + lastName + "is found.";
            } else {
                employee = null;
            }
        }
        if (employee == null) {
            throw new BadRequest();
        }
       return employee.toString();
    }
}
