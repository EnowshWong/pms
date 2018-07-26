package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsStuAssessMapper;
import com.pms.pojo.PmsStuAssess;
import com.pms.pojo.PmsStuAssessExample;
import com.pms.service.StuAssessService;
import com.pms.service.StuService;
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
public class StuAssessServiceImpl implements StuAssessService {
    @Autowired
    private PmsStuAssessMapper pmsStuAssessMapper;

    @Override
    public PmsResult createAssess(PmsStuAssess pmsStuAssess) {
        Date date=new Date();
        pmsStuAssess.setCreated(date);
        pmsStuAssessMapper.insert(pmsStuAssess);
        return PmsResult.ok();
    }

    @Override
    public PmsStuAssess getAssessByPlanId(long planId) {
        PmsStuAssessExample example=new PmsStuAssessExample();
        PmsStuAssessExample.Criteria criteria=example.createCriteria();
        criteria.andPlanIdEqualTo(planId);
        List<PmsStuAssess> list = pmsStuAssessMapper.selectByExampleWithBLOBs(example);
        if (list==null||list.size()==0)
            return null;
        return list.get(0);
    }
}
