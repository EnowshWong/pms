package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsTutAssess1Mapper;
import com.pms.pojo.PmsTutAssess1;
import com.pms.pojo.PmsTutAssess1Example;
import com.pms.service.TutAssess1Service;
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
public class TutAssess1ServiceImpl implements TutAssess1Service {

    @Autowired
    private PmsTutAssess1Mapper pmsTutAssess1Mapper;

    @Override
    public PmsTutAssess1 getAssess1ByPlanId(long planId) {
        PmsTutAssess1Example example=new PmsTutAssess1Example();
        PmsTutAssess1Example.Criteria criteria=example.createCriteria();
        criteria.andPlanIdEqualTo(planId);
        List<PmsTutAssess1> list = pmsTutAssess1Mapper.selectByExampleWithBLOBs(example);
        if (list==null||list.size()==0)
            return null;
        return list.get(0);
    }

    @Override
    public PmsResult createTutAssess1(PmsTutAssess1 pmsTutAssess1) {
        Date date=new Date();
        pmsTutAssess1.setCreated(date);
        pmsTutAssess1Mapper.insert(pmsTutAssess1);
        return PmsResult.ok();
    }
}
