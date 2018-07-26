package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PlanAllAssess;
import com.pms.pojo.PmsStuAssess;

import java.util.List;

/**
 * @author:wong
 */
public interface StuAssessService {
    PmsResult createAssess(PmsStuAssess pmsStuAssess);
    PmsStuAssess getAssessByPlanId(long planId);
}
