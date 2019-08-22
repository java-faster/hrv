package org.sang.service;

import org.sang.bean.Employee;
import org.sang.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeServiceImpl
 * @Description TODO
 * @Auther YCHD-JPC
 * @Date 2019/8/22 13:59
 **/


@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeUserList() {
        return employeeMapper.getEmployeeUserList();
    }
}
