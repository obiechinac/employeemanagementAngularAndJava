package com.obi.employeemanager.service;

import com.obi.employeemanager.exception.UserNotFoundException;
import com.obi.employeemanager.model.Employee;
import com.obi.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){

        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){

        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User with Id: " + id + " not found"));
    }

    public void deleteEmployeeById(Long id){

        employeeRepository.delete(employeeRepository.getById(id));
    }
}
