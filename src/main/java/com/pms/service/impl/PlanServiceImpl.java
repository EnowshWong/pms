package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsPlanMapper;
import com.pms.pojo.PmsPlan;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:wong
 */
@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PmsPlanMapper pmsPlanMapper;

    @Override
    public PmsResult createPlan(PmsPlan pmsPlan,String created,String expired) {
        pmsPlanMapper.insert(pmsPlan);
        return PmsResult.ok();
    }
}
