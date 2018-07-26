package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTutAssess2;

/**
 * @author:wong
 */
public interface TutAssess2Service {
    PmsResult createAssess(PmsTutAssess2 pmsTutAssess2);
    PmsTutAssess2 getAssessByPlanId(long planId);
}
