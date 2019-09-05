package org.sang.service;

import org.sang.bean.AdjustSalary;
import org.sang.common.poi.DateUtils;
import org.sang.mapper.AdjustSalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
        List<AdjustSalary> orginList=adjustSalaryMapper.queryAllAdjustSalaryList();
        for (AdjustSalary orgin : orginList ) {
            try {
                orgin.setAsDate(DateUtils.getYYYYddmm(orgin.getAsDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return orginList;
    }

    @Override
    public int updateAdjustSalary(AdjustSalary as) {
        int id=as.getId();
        int flag=0;
            if(id==0||"".equals(id+"")){
                return 0;
            }else{
                flag=adjustSalaryMapper.updateAdjustSalaryMapper(as);
            }
        return flag;
    }

    @Override
    public void addAdjustSalary(AdjustSalary as) {
        adjustSalaryMapper.addAdjustSalaryMapper(as);
    }

    @Override
    public void deleteAdjustSalary(int id) {
        adjustSalaryMapper.deleteAdjustSalaryMapper(id);
    }
}
