package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
import edu.skypro.homework.exceptions.EmployeeAlreadyAddedException;
import edu.skypro.homework.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employeeList.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> printAll() {
        return Collections.unmodifiableCollection(employeeList);
    }
}
