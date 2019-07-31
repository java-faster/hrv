package org.sang.controller.salary;

import org.sang.bean.AdjustSalary;
import org.sang.service.AdjustSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SalaryAdjustController
 * @Description TODO
 * @Auther YCHD-JPC
 * @Date 2019/7/29 17:23
 * 员工调薪
 **/

@RestController
@RequestMapping("/salary/adjust")
public class SalaryAdjustController {

    @Autowired
    @Qualifier("adjustSalaryServiceImpl")
    private AdjustSalaryService adjustSalaryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> dataTable(){
        Map<String,Object> map=new HashMap<>();
        List<AdjustSalary> allList=adjustSalaryService.getAllAdjustSalaryList();
        map.put("dataTable",allList);
        return map;
    }
}
