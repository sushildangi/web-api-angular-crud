package com.isolutions4u.webapi.serviceimpl;

import com.isolutions4u.webapi.model.Employee;
import com.isolutions4u.webapi.repository.EmployeeRepository;
import com.isolutions4u.webapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Qualifier("employeeRepository")
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(Employee employee) {
         employeeRepository.saveAndFlush(employee);
         return "Successfully Saved!!!";
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findProductByEmployeeId(Integer employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
         employeeRepository.delete(employeeId);
         return "Successfully Deleted";
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
        return "Successfully Updated";
    }
}
