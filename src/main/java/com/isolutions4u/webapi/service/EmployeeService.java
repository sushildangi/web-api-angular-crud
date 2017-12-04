package com.isolutions4u.webapi.service;

import com.isolutions4u.webapi.model.Employee;

import java.util.List;

public interface EmployeeService {


    String saveEmployee(Employee employee);

    List<Employee> findAllEmployee();

    Employee findProductByEmployeeId(Integer employeeId);

    String deleteEmployee(Integer employeeId);

    String updateEmployee(Employee employee);



}
