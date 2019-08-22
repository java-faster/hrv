package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.AdjustSalary;

import java.util.List;

public interface AdjustSalaryMapper {

    List<AdjustSalary> queryAllAdjustSalaryList();

    int updateAdjustSalaryMapper(@Param("adjust") AdjustSalary as);

    void addAdjustSalaryMapper(@Param("adjust") AdjustSalary as);
}
