package com.isolutions4u.webapi.controller;


import com.isolutions4u.webapi.model.Employee;
import com.isolutions4u.webapi.service.EmployeeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
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

    @PostMapping(value = "/employee", produces = "application/json")
    public String createEmployee(@RequestBody Employee employee) {

        String output = employeeService.saveEmployee(employee);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("output", output);
        return jsonObject.toString();

    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee employee) {

        String output = employeeService.updateEmployee(employee);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("output", output);
        return jsonObject.toString();
    }

    @DeleteMapping("employee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        String output = employeeService.deleteEmployee(employeeId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("output", output);
        return jsonObject.toString();
    }


}
