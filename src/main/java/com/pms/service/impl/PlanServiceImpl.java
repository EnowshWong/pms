package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsPlanMapper;
import com.pms.pojo.PmsPlan;
import com.pms.pojo.PmsPlanExample;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:wong
 */
@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PmsPlanMapper pmsPlanMapper;

    @Override
    public PmsResult createPlan(PmsPlan pmsPlan) {
        pmsPlanMapper.insert(pmsPlan);
        return PmsResult.ok();
    }

    @Override
    public List<PmsPlan> getPlanListByStuId(long stuId) {
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }
}
