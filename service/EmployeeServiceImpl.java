package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        employeeList.add(new Employee(firstName, lastName));
        return employeeList.get(employeeList.size() - 1);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employeeList.size(); i++) {
            if
                (
                    employeeList.get(i).getFirstName().equals(firstName) &&
                    employeeList.get(i).getLastName().equals(lastName)
                )
            {
                employeeList.remove(i);
                return employeeList.get(i);
            }
        }
        return employeeList.get(0); // заглушка
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if
                (
                    employee.getFirstName().equals(firstName) &&
                    employee.getLastName().equals(lastName)
                )
            {
                return employee;
            }
        }
        return employeeList.get(0); // заглушка
    }

    @Override
    public List<Employee> printEmployeeList() {
        return employeeList;
    }
}
