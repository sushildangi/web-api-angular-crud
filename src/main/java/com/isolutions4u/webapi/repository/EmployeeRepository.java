package com.isolutions4u.webapi.repository;


import com.isolutions4u.webapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
