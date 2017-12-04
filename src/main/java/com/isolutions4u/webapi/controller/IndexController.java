package com.isolutions4u.webapi.controller;


import com.isolutions4u.webapi.model.Employee;
import com.isolutions4u.webapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    @Qualifier("employeeService")
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> showAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.findProductByEmployeeId(employeeId);
    }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);

    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("employee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }


}
