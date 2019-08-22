package org.sang.service;

import org.sang.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public interface EmployeeService {
    List<Employee> getEmployeeUserList();
}
