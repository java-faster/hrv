package org.sang.service;

import org.sang.bean.AdjustSalary;
import org.sang.mapper.AdjustSalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdjustSalaryServiceImpl
 * @Description TODO
 * @Auther YCHD-JPC
 * @Date 2019/7/29 17:39
 **/

@Service("adjustSalaryServiceImpl")
public class AdjustSalaryServiceImpl implements AdjustSalaryService {


    @Autowired
    private AdjustSalaryMapper adjustSalaryMapper;

    @Override
    public List<AdjustSalary> getAllAdjustSalaryList() {
//        List<AdjustSalary> orginList=adjustSalaryMapper.queryAllAdjustSalaryList();
//        for (AdjustSalary orgin : orginList ) {
//
//            orgin.setAsDate(LocalDate.parse(orgin.getAsDate());
//        }
        return adjustSalaryMapper.queryAllAdjustSalaryList();
    }
}
