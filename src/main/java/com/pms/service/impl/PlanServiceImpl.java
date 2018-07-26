package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsPlanMapper;
import com.pms.pojo.PlanAllAssess;
import com.pms.pojo.PlanAssess1;
import com.pms.pojo.PmsPlan;
import com.pms.pojo.PmsPlanExample;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Override
    public List<PlanAssess1> findPlanAssess1ByStuId(long stuId) {
        List<PlanAssess1> list = pmsPlanMapper.findPlanAssess1ByStuId(stuId);
        return list;
    }

    @Override
    public List<PmsPlan> getExpiredPlanListByStuId(long stuId) {
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        Date date=new Date();
        criteria.andExpiredLessThanOrEqualTo(date);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public PlanAssess1 findPlanAssess1ById(long id) {
        PlanAssess1 planAssess1= pmsPlanMapper.findPlanAssess1ById(id);
        return planAssess1;
    }

    @Override
    public List<PlanAllAssess> getPlanAllAssessByStuId(long stuId) {
        List<PlanAllAssess> list = pmsPlanMapper.findPlanAllAssessByStuId(stuId);
        return list;
    }
}
