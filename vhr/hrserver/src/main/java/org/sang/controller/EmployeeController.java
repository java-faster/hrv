package org.sang.controller;

import org.sang.bean.Employee;
import org.sang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    @Qualifier("employeeServiceImpl")
    private EmployeeService employeeService;

    @RequestMapping("/basic")
    public String basic() {
        return "basic";
    }
    @RequestMapping("/")
    public String  hello() {
        return "Hello";
    }
    @RequestMapping("/user/list")
    public Map<String,Object> getUserList() {
        Map<String,Object> map=new HashMap<>();
        List<Employee> userList=employeeService.getEmployeeUserList();
        map.put("userList",userList);
        return map;
    }
}
