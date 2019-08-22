package org.sang.service;


import org.sang.bean.AdjustSalary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adjustSalaryService")
public interface AdjustSalaryService {

    List<AdjustSalary> getAllAdjustSalaryList();

    int updateAdjustSalary(AdjustSalary as);

    void addAdjustSalary(AdjustSalary as);
}
