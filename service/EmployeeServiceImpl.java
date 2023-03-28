package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
import edu.skypro.homework.exceptions.EmployeeAlreadyAddedException;
import edu.skypro.homework.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже существует");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Данный сотрудник не существует в системе");
        }
        employeeList.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Данный сотрудник не существует в системе");
        }
        return employee;
    }

    @Override
    public List<Employee> printEmployeeList() {
        return employeeList;
    }
}
