package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId).get();
      /*  return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Böyle bir employee yok"));*/
    }


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
        return "Employee is deleted is succfully employeeId:"+ employee.getEmployeeId();
    }
}
