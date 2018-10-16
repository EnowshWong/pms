package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsTempPlanMapper;
import com.pms.pojo.PmsTempPlan;
import com.pms.pojo.PmsTempPlanExample;
import com.pms.pojo.PmsTempPlanWithBLOBs;
import com.pms.service.TemplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:wong
 */
@Service
@Transactional
public class TemplanServiceImpl implements TemplanService {

    @Autowired
    private PmsTempPlanMapper pmsTempPlanMapper;

    @Override
    public PmsResult createTemplan(PmsTempPlanWithBLOBs pmsTempPlan) {
        pmsTempPlanMapper.insert(pmsTempPlan);
        return PmsResult.ok();
    }

    @Override
    public List<PmsTempPlanWithBLOBs> getTempPlanListByStuId(long stuId) {
        PmsTempPlanExample example=new PmsTempPlanExample();
        PmsTempPlanExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        List<PmsTempPlanWithBLOBs> list = pmsTempPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public PmsResult delTemplanById(long id) {
        pmsTempPlanMapper.deleteByPrimaryKey(id);
        return PmsResult.ok();
    }

    @Override
    public PmsResult updateTemplan(PmsTempPlanWithBLOBs pmsTempPlan) {
        pmsTempPlanMapper.updateByPrimaryKeySelective(pmsTempPlan);
        return PmsResult.ok();
    }

    @Override
    public PmsTempPlanWithBLOBs getById(long id) {
        PmsTempPlanWithBLOBs pmsTempPlan = pmsTempPlanMapper.selectByPrimaryKey(id);
        return pmsTempPlan;
    }
}
