package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsTutAssess2Mapper;
import com.pms.pojo.PmsTutAssess2;
import com.pms.pojo.PmsTutAssess2Example;
import com.pms.service.TutAssess2Service;
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
public class TutAssess2ServiceImpl implements TutAssess2Service {
    @Autowired
    private PmsTutAssess2Mapper pmsTutAssess2Mapper;

    @Override
    public PmsTutAssess2 getAssessByPlanId(long planId) {
        PmsTutAssess2Example example=new PmsTutAssess2Example();
        PmsTutAssess2Example.Criteria criteria=example.createCriteria();
        criteria.andPlanIdEqualTo(planId);
        List<PmsTutAssess2> list = pmsTutAssess2Mapper.selectByExampleWithBLOBs(example);
        if (list==null||list.size()==0)
            return null;
        return list.get(0);
    }

    @Override
    public PmsResult createAssess(PmsTutAssess2 pmsTutAssess2) {
        Date date=new Date();
        pmsTutAssess2.setCreated(date);
        pmsTutAssess2Mapper.insert(pmsTutAssess2);
        return PmsResult.ok();
    }
}
