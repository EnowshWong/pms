package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsPlanMapper;
import com.pms.pojo.*;
import com.pms.service.PlanService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        pmsPlan.setOptime(new Date());
        pmsPlan.setStatus1((byte) 0);
        pmsPlan.setStatus((byte) 0);
        pmsPlan.setStatus2((byte) 0);
        pmsPlanMapper.insert(pmsPlan);
        return PmsResult.ok();
    }

    @Override
    public PmsResult delPlanById(long id) {
        pmsPlanMapper.deleteByPrimaryKey(id);
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
    public PlanAllAssess getPlanAssess2ById(long id) {
        PlanAllAssess list = pmsPlanMapper.findPlanAssess2ById(id);
        return list;
    }

    @Override
    public PmsResult updatePlan(PmsPlan pmsPlan) {
        pmsPlan.setOptime(new Date());
        pmsPlanMapper.updateByPrimaryKeySelective(pmsPlan);
        return PmsResult.ok();
    }

    @Override
    public PlanAssess1 findPlanAssess1ById(long id) {
        PlanAssess1 planAssess1= pmsPlanMapper.findPlanAssess1ById(id);
        return planAssess1;
    }

    @Override
    public PlanAllAssess getPlanAllAssessById(long id) {
        PlanAllAssess list = pmsPlanMapper.findPlanAllAssessById(id);
        return list;
    }

    @Override
    public PmsPlan getPlanById(long id) {
        PmsPlan pmsPlan = pmsPlanMapper.selectByPrimaryKey(id);
        return pmsPlan;
    }


    @Override
    public List<PmsPlan> getDoingListByStuId(long stuId) {
        //得到学生页面正在进行的计划
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andExpiredGreaterThanOrEqualTo(new Date());
        criteria.andStuIdEqualTo(stuId);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public List<PmsPlan> getDoingList(long stuId) {
        //得到老师页面正在进行的计划
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andExpiredGreaterThanOrEqualTo(new Date());
        criteria.andStuIdEqualTo(stuId);
        criteria.andStatus1NotEqualTo((byte) 1);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public List<PmsPlan> getDoneListByStuId(long stuId) {
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andExpiredLessThanOrEqualTo(new Date());
        criteria.andStatus2NotEqualTo((byte) 1);
        criteria.andStuIdEqualTo(stuId);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public List<PmsPlan> getHistoryListByStuId(long stuId) {
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andExpiredLessThanOrEqualTo(new Date());
        criteria.andStatusEqualTo((byte) 1);
        criteria.andStuIdEqualTo(stuId);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public List<PlanAssess2> getPlanAssess2ByStuId(long stuId) {
        List<PlanAssess2> list = pmsPlanMapper.findPlanAssess2ByStuId(stuId);
        return list;
    }

    @Override
    public List<PlanAllAssess> getRecentPlanByStuId(long stuId) {
        List<PlanAllAssess> list = pmsPlanMapper.findRecentPlanByStuId(stuId);
        return list;
    }

    @Override
    public List<PlanAllAssess> getAllPlanByStuId(long stuId) {
        List<PlanAllAssess> list = pmsPlanMapper.findAllPlanByStuId(stuId);
        return list;
    }

    @Override
    public List<TeaTaskData> getTeaTaskData(Long expId) {
        List<TeaTaskData> list = pmsPlanMapper.findTeaTaskData(expId);
        return list;
    }

    @Override
    public PlanFJAndSelfJ getFJAndSelfJById(Long id) {
        PlanFJAndSelfJ plan = pmsPlanMapper.findFJAndSelfJById(id);
        return plan;
    }

    @Override
    public List<PmsPlan> getNoneSelfJudgeByStuId(long stuId) {
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        Date date=new Date();
        criteria.andExpiredLessThanOrEqualTo(date);
        criteria.andStatusEqualTo((byte) 0);
        List<PmsPlan> list = pmsPlanMapper.selectByExampleWithBLOBs(example);
        return list;
    }
}
